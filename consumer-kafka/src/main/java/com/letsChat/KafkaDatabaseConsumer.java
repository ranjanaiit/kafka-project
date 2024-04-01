package com.letsChat;


import com.letsChat.ably.AblyPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class KafkaDatabaseConsumer {
  Logger logger = Logger.getLogger(KafkaDatabaseConsumer.class.getName());

  @KafkaListener(topics = "letsChat-topic", groupId = "consumer-group")
  public void consume(String message) {
    AblyPublisher ablyPublisher = new AblyPublisher();
    ablyPublisher.publishMessage("meesage", message);
    logger.info(String.format("Consumed message -> %s", message));
  }
}
