package com.tests.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.controllers.ProdutoController;
import com.example.repositories.ProdutoRepository;
import com.tests.configs.MongoConfig;
import com.tests.startup.InitializeData;


@DataMongoTest()
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={InitializeData.class,ProdutoController.class,ProdutoRepository.class,MongoConfig.class})
public class ProdutoTest {

  @Autowired
  ProdutoController produtoController;

  @Autowired
  ProdutoRepository produtoRepository;

  @Test
  void obter_produto_por_codigo(){
    var produto = produtoController.obterPorCodigo(1);
    assertEquals("Xícara Dev", produto.nome);
  }

  @Test
  void obter_produto_por_id(){
    var all = produtoRepository.findAll();
    var produto = produtoController.obterPorId(all.get(0).id);
    var i = produto.indexOf("Xícara Dev");
    assertEquals(true,i>0);
  }

  @Test
  void verificar_dimensoes(){
    var all = produtoRepository.findAll();
    assertEquals(new BigDecimal(1),all.get(0).dimensoes.altura);
  }

  @Test
  void verificar_categoria(){
    var all = produtoRepository.findAll();
    assertEquals(1,all.get(0).categorias.get(0).codigo);
  }

  

}