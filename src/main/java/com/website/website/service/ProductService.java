package com.website.website.service;

import com.website.website.model.Product;
import com.website.website.repository.ProductRepository;
import net.bytebuddy.implementation.MethodDelegation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// implémentation des traitements métiers spécifiques à l'application
// dédier au métier -> executer les traitements métier -> fait le pont entre controller et repository
@Service
public class ProductService {

    private final ProductRepository productRepository;


    @Autowired //injecter une instance ProductRepository
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductList(){
        return productRepository.findAll();
    }

    public List<Product> getProductByCategory(String productCategory){
        return productRepository.findProductByProductCategory(productCategory);
    }
    // get product by id
    public Product getProductById(int productId){
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()){
            return productOptional.get();
        }
        throw new IllegalStateException("productId does not exists");
    }


    // delete product by id
    public void deleteProductById(int productId) {
        boolean exists = productRepository.existsById(productId);
        if (!exists){
            throw new IllegalStateException("Product with id : " + productId + " does not exist");
        }
        productRepository.deleteById(productId);
    }

    public Product saveProduct(Product product){
        System.out.println(product.getProductImage());
        return productRepository.save(product);
    }

}
