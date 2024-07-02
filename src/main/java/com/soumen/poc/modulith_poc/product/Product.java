package com.soumen.poc.modulith_poc.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {

  @Id
  @GeneratedValue
  Integer id;
  String name;
  String description;
  Integer price;
}
