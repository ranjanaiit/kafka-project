package com.letsChat.repository;

import com.letsChat.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageChangeHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(MessageChangeHandler.class);


  public MessageChangeHandler() {

  }
  public void onMessage( Message message) throws Exception {
  }

}
