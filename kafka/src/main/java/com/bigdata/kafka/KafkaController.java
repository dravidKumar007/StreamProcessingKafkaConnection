package com.bigdata.kafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/publish")
    public Message publishMessage(@RequestBody KafkaTemplate kafkabody) {
        kafkaProducerService.sendMessage(kafkabody.email()+','+kafkabody.id());
        return new Message("Message published successfully!");
    }
}