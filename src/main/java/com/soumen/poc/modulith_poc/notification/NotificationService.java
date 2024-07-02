package com.soumen.poc.modulith_poc.notification;

import jakarta.transaction.Transactional;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationService {

  private final ApplicationEventPublisher eventPublisher;

  @Transactional
  public void createNotification(int productId, int quantity) {
    var notification = NotificationEvent.builder()
        .productId(productId)
        .date(new Date())
        .quantity(quantity)
        .build();
    log.info("Created notification : {}", notification);
    eventPublisher.publishEvent(notification);
  }

}
