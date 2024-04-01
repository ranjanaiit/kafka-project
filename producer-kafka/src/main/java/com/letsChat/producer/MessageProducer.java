package com.letsChat.producer;

import com.letsChat.model.Message;
import com.letsChat.repository.MessageChangeHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Component
public class MessageProducer {

  public static final Logger logger = Logger.getLogger(MessageProducer.class.getName());
  private KafkaTemplate<String, String > kafkaTemplate;

  public MessageProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(Message message) throws Exception {
    // to read real time stream data from wikimedia, we use event source
    kafkaTemplate.send("letsChat-topic", message.toJsonString());
  }
}

