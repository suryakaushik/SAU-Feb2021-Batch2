package com.au.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.au.kafka.model.Order;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, String> producerKafkaTemplate;

    public void createOrder(Order order) {
        String topicName = "createOrder";
        producerKafkaTemplate.send(topicName, order.toString());
        log.info("Order Created by Producer, msg = {}", order.toString());
    }

    public void shipOrder(Order order) {
        String topicName = "shipOrder";
        producerKafkaTemplate.send(topicName, order.toString());
        log.info("Order Shipped by Producer , msg = {}", order.toString());
    }

}