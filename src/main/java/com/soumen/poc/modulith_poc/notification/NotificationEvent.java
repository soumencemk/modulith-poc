package com.soumen.poc.modulith_poc.notification;

import java.util.Date;
import lombok.Builder;

@Builder
public record NotificationEvent(Integer productId, Date date, int quantity) {

}
