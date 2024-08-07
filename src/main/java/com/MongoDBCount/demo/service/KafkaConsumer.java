package com.MongoDBCount.demo.service;

import com.MongoDBCount.demo.model.HttpRequest;
import com.MongoDBCount.demo.repository.HttpRequestRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @Autowired
    private HttpRequestRepository httpRequestRepository;

    @KafkaListener(topics = "request_stats", groupId = "group_id")
    public void listen(ConsumerRecord<String, String> record) {
        String message = record.value();
        System.out.println("Consumed record with key " + record.key() + " from partition " + record.partition() + " with offset " + record.offset());
        System.out.println(message);
        HttpRequest httpRequest = new HttpRequest(message);
        httpRequestRepository.save(httpRequest);
    }

}
