package com.kunfeng2002.springmvc.control;

import com.kunfeng2002.springmvc.Repo.ProductRepo;
import com.kunfeng2002.springmvc.model.Product;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductCtrl {

    private final ProductRepo productRepo;

    public ProductCtrl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping("/getall")
    public List<Product> getAll(){
        return productRepo.findAll();
    }

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable int id){
        Product product = productRepo.findById(id);
        return product;
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addproduct(@RequestBody Product product){
        productRepo.addProduct(product);
        return null;
    }

    @PostMapping("/edit")
    public ResponseEntity<Product> editProduct(@RequestBody Product product){
        productRepo.updateProduct(product);
        return null;
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, HttpServletResponse response){
        productRepo.deleteById(id);
        return "Deleted product with id: " + id;
    }
}
