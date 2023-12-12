package com.example.catalogservice.messagequeue;

import com.example.catalogservice.jpa.CatalogEntity;
import com.example.catalogservice.jpa.CatalogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final CatalogRepository repository;
    private final ObjectMapper objectMapper;
    @KafkaListener(topics = "example-catalog-topic")
    public void updateQty(String kafkaMessage){
        log.info("Kafka Message: {}", kafkaMessage);

        Map<Object, Object> map = new HashMap<>();
        try {
            // DESERIALIZE String to Object
             map = objectMapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {});
        }catch (JsonProcessingException e) {
            e.getStackTrace();
        }

        Optional<CatalogEntity> catalogEntity = repository.findByProductId(map.get("product_id").toString());
        var qty = Integer.parseInt(map.get("qty").toString());
        var updateEntity = catalogEntity.
                map(entity -> {
                    entity.setStock(entity.getStock() - qty);
                    return entity;
                }).
                orElseThrow(()-> new RuntimeException("qty"));

        repository.save(updateEntity);
    }
}
