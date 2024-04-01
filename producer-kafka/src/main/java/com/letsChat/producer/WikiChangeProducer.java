package com.letsChat.producer;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import com.letsChat.repository.WikiChangeHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Service
public class WikiChangeProducer {

  public static final Logger logger = Logger.getLogger(WikiChangeProducer.class.getName());

  private KafkaTemplate<String, String > kafkaTemplate;

  public WikiChangeProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage() throws InterruptedException {
    // to read real time stream data from wikimedia, we use event source
    EventHandler eventHandler = new WikiChangeHandler(kafkaTemplate, "letsChat-topic");
    String url = "https://stream.wikimedia.org/v2/stream/recentchange";
    EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
    EventSource eventSource = builder.build();
    eventSource.start();
    TimeUnit.MINUTES.sleep(10);
}
}
