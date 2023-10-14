package com.caronas.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "carona")
public class User {
  
  @Id
  private int id;

  private String nome;
  private int meia;
  private int inteira;
}
