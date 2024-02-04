package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Produto;
import com.example.repositories.ProdutoRepository;


@RestController
public class ProdutoController {

  @Autowired
  ProdutoRepository produtoRepository;

  @GetMapping(value = {"/produto/{id}"})
  public String obterPorId(@PathVariable String id) {
      Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Não foi possível encontrar o produto " + id));
      return "nome: "+produto.nome+" valor:"+produto.valor;
  }

  @GetMapping(value = {"/produto/codigo/{codigo}"})
  public Produto obterPorCodigo(@PathVariable Integer codigo) {
      Produto produto = produtoRepository.findByCodigo(codigo).orElseThrow(() -> new RuntimeException("Não foi possível encontrar o produto de codigo " + codigo));
      return produto;
  }

}