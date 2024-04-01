package com.letsChat.controller;

import com.letsChat.model.Message;
import com.letsChat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
  @Autowired
  MessageService service;

  @RequestMapping("/hello")
  public String helloWorld(){
    return "Hello World from Spring Boot";
  }

  @PostMapping("/message")
  public String addMessage(@RequestBody Message message) throws Exception {
    System.out.println("Message received: " + message.toJsonString());
    service.process(message);
    return "Hello World from Spring Boot";
  }

}