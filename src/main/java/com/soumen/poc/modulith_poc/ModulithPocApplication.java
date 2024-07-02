package com.soumen.poc.modulith_poc;

import com.soumen.poc.modulith_poc.product.Product;
import com.soumen.poc.modulith_poc.product.ProductService;
import java.util.Random;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ModulithPocApplication {

  public static void main(String[] args) {
    SpringApplication.run(ModulithPocApplication.class, args);
  }

  @Bean
  ApplicationRunner init(ProductService productService) {
    return args -> {
      var random = new Random();
      var xbox = new Product();
      xbox.setName("XBOX");
      xbox.setDescription("Gaming console");
      xbox.setPrice(2000);
      var p = productService.createProduct(xbox);
      while (true) {
        Thread.sleep(5000);
        productService.buyProduct(p.getId(), random.nextInt());
      }
    };
  }
}
