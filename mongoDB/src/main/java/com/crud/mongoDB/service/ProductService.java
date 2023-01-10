package com.crud.mongoDB.service;

import com.crud.mongoDB.model.ProductDetails;
import com.crud.mongoDB.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private  SequenceGeneratorService sequenceGeneratorService;


    public List<ProductDetails> returnAll() {
        List<ProductDetails> Items = new ArrayList<>();
        productRepository.findAll()
                .forEach(Items::add);
        return Items;
    }


    public Optional<ProductDetails> getProduct(Long id) {

        return productRepository.findById(id);
    }

    public ProductDetails addProduct(ProductDetails Inventory) {
        Inventory.setId(sequenceGeneratorService.generateSequence(ProductDetails.SEQUENCE_NAME));
        return productRepository.save(Inventory);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(Long id, ProductDetails Inventory) {
        productRepository.save(Inventory);
    }


}

