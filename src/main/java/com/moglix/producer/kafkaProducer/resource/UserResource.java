package com.moglix.producer.kafkaProducer.resource;

import com.moglix.producer.kafkaProducer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")

public class UserResource {
    @Autowired
    KafkaTemplate<String , User> kafkaTemplate;
    private static final String TOPIC="test-v";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name){
        kafkaTemplate.send(TOPIC,new User(name,"technology",360000L));
        return  "published json successfully";
    }

}
