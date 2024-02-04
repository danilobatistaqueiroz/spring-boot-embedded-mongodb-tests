package com.example.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {
  Optional<Produto> findByCodigo(Integer codigo);
}
