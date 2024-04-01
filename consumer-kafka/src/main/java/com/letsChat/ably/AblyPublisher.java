package com.letsChat.ably;

import io.ably.lib.realtime.AblyRealtime;
import io.ably.lib.realtime.Channel;
import io.ably.lib.types.AblyException;

public class AblyPublisher {
  private static final String API_KEY = "lets-chat-API-key";
  private static final String CHANNEL_NAME = "letschat-channel";

  public void publishMessage(String eventName, String messagePayload) {
    try {
      AblyRealtime ably = new AblyRealtime(API_KEY);
      Channel channel = ably.channels.get(CHANNEL_NAME);
      channel.publish(eventName, messagePayload);
      System.out.println("Message published to Ably");
    } catch (AblyException e) {
      e.printStackTrace();
    }
  }
}


