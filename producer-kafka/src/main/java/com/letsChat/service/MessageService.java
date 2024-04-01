package com.letsChat.service;

import com.letsChat.model.Message;
import com.letsChat.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageService {

  @Autowired
  MessageProducer messageProducer;


  public void process(Message message) throws Exception {
    messageProducer.sendMessage(message);
  }
}
