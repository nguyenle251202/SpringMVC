package com.kunfeng2002.springmvc.control;

import com.kunfeng2002.springmvc.DTO.ProductDTO;
import com.kunfeng2002.springmvc.Repo.ProductRepo;
import com.kunfeng2002.springmvc.Service.ProductService;
import com.kunfeng2002.springmvc.model.Product;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductCtrl {

    @Autowired
    private ProductService productService;
//    private final ProductRepo productRepo;

    @GetMapping("/getall")
    public List<Product> getAll(){
        List<Product> products = productService.getAllProducts();
        return products;
    }

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable int id){
        return productService.getProductById(id);
    }
//    @PostMapping("/delete/{id}")
//    public Product deleteProduct(@PathVariable int id, HttpServletResponse response){
//        productRepo.deleteById(id);
//        response.setStatus(200);
//        return null;
//    }
//
//    @PostMapping("/add")
//    public ProductDTO addProduct(@RequestBody ProductDTO productDTO, HttpServletResponse response) {
//        productService.batchAdd(productDTO);
//        response.setStatus(200);
//        System.out.println("Added product(s) successfully");
//        return productDTO;
//    }
//
//    @PostMapping("/edit")
//    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO, HttpServletResponse response){
//        productService.batchUpdate(productDTO);
//        response.setStatus(200);
//        System.out.println("Added product(s) successfully");
//        return productDTO;
//    }
}