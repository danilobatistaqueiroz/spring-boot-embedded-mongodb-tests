package com.example.entities;

import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

public class Categoria {

  @Id
  public String id;
  public String nome;
  public Integer codigo;
  
  @DocumentReference
  @Transient
  @BsonIgnore
  List<Produto> produtos;

  public Categoria(){}

  Categoria(String nome, Integer codigo) {
    this.nome = nome;
    this.codigo = codigo;
  }

}
