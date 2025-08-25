package com.booleanuk.api.product.model.repository;

import com.booleanuk.api.product.controller.Dto.ProductCreateDto;
import com.booleanuk.api.product.model.pojo.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();

        this.products.add(new Product("Spoon", "Kitchen", 100));
        this.products.add(new Product("Laptop", "Electronics", 10000));
        this.products.add(new Product("Book", "Education", 150));

    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getOne(int id){
        for (Product product : this.products) {
            if (product.getId() == id) {
                return product;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");

    }

    public void createProduct(Product product) {
        products.add(product);
    }

    public Product updateProduct(int id, ProductCreateDto body) {
        for (Product p : this.products) {
            if (p.getId() == id) {
                p.setName(body.getName());
                p.setPrice(body.getPrice());
                p.setCategory(body.getCategory());
                return p;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "product not found");
    }

    public Product deleteProduct(int id) {
        for (Product p : this.products){
            if (p.getId() == id) {
                this.products.remove(p);
                return p;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
    }
}
