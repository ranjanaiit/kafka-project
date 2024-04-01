package com.letsChat.service;
import com.letsChat.model.BaseData;
import org.springframework.stereotype.Service;

@Service
public interface ServiceInterface {
  public void process(BaseData message) throws InterruptedException;
}
