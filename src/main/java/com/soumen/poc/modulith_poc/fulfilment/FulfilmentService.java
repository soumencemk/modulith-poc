package com.soumen.poc.modulith_poc.fulfilment;

import com.soumen.poc.modulith_poc.notification.NotificationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FulfilmentService {

  @ApplicationModuleListener
  public void processNotifications(NotificationEvent notificationEvent)
      throws InterruptedException {
    log.info("Received notification event : {}", notificationEvent);
    Thread.sleep(2_000);
    log.info("Fulfilment processed for : {}", notificationEvent);
  }
}
