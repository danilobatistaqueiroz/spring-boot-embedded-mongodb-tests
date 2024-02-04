package com.example.entities;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

public class Produto {

  @Id
  public String id;
  public Integer codigo;
  public String nome;
  public String descricao;
  public Boolean ativo;
  public BigDecimal valor;
  public String dataCadastro;
  public String imagem;
  public BigDecimal quantidadeEstoque;

  public Dimensoes dimensoes;
  
  @DocumentReference
  public List<Categoria> categorias;

}