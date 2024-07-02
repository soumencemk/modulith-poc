package com.soumen.poc.modulith_poc.product;

import com.soumen.poc.modulith_poc.notification.NotificationService;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

  private final ProductRepository productRepository;
  private final NotificationService notificationService;


  public Product createProduct(Product product) {
    var p = productRepository.save(product);
    log.info("Product : [{}] created !", p);
    return p;
  }

  @Transactional
  public void buyProduct(Integer id, int qty) {
    Optional<Product> product = productRepository.findById(id);
    product.ifPresent(p -> notificationService.createNotification(p.getId(), qty));
    log.info("Buy request placed");
  }
}
