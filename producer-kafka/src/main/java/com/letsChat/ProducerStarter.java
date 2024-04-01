package com.letsChat;

import com.letsChat.producer.WikiChangeProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerStarter implements CommandLineRunner {
  public static void main(String[] args) {
    SpringApplication.run(ProducerStarter.class, args);
  }

  @Autowired
  WikiChangeProducer kafkaChangeProducer;

  @Override
  public void run(String... args) throws Exception {
    kafkaChangeProducer.sendMessage();

  }
}
