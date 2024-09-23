package com.julio.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.julio.springboot.di.app.springboot_di.models.Product;
import com.julio.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl  implements ProductService{

    //@Autowired
    //@Qualifier("productFoo")
    private ProductRepository repository;

    @Value("${config.price.tax}")
    private Double tax;

    public ProductServiceImpl(@Qualifier("productJson") ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * tax;
            //Product newProd = new Product(p.getId(),p.getName(),priceTax.longValue());

            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;

            //p.setPrice(priceTax.longValue());
            //return p;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }

}
