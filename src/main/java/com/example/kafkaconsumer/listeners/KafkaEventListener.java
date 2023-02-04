package com.example.kafkaconsumer.listeners;

import com.example.kafkaconsumer.models.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaEventListener {

    @KafkaListener(topics = "user-topic", groupId = "user-group-1", containerFactory = "userKafkaListenerContainerFactory")
    void listener(UserModel userModel) {

        if (userModel == null) {
            log.warn("😔 empty payload received");
        } else {
            log.info("🎉 received user: " + userModel.getName());
        }

    }

}
