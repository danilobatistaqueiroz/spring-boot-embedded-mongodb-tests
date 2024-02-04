package com.tests.startup;

import com.example.entities.Categoria;
import com.example.entities.Produto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class InitializeData {

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Categoria> categorias = objectMapper.readValue(new ClassPathResource("categoria.json").getFile(), new TypeReference<List<Categoria>>() {});
        mongoTemplate.insertAll(categorias);
        List<Produto> produtos = objectMapper.readValue(new ClassPathResource("produto.json").getFile(), new TypeReference<List<Produto>>() {});
        produtos.get(0).categorias = categorias;
        mongoTemplate.insertAll(produtos);
    }

}