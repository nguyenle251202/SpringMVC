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

    @GetMapping("/getall")
//    public List<Product> getAll(){
//        List<Product> products = productService.getAllProducts();
//        return products;
    public ResponseEntity<Page<Product>> getAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size,
            @RequestParam(value = "sort", defaultValue = "id, asc") String[] sort
    ) {
        Sort.Direction direction = Sort.Direction.fromString(sort[1]);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort[0]));
        Page<Product> products = productService.getAllProducts(pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable int id){
        return productService.getProductById(id);
    }
    @PostMapping("/delete/{id}")
    public Product deleteProduct(@PathVariable int id){
        productService.getDelete(id);
        return null;
    }

    @PostMapping("/add")
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO, HttpServletResponse response) {
        productService.getAdd(productDTO);
        response.setStatus(201);
        return productDTO;
    }

    @PostMapping("/edit")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO, HttpServletResponse response){
        productService.getUpdate(productDTO);
        response.setStatus(201);
        return productDTO;
    }

    @GetMapping("/test")
    public String test(HttpServletResponse response){
        response.setStatus(500);
        return "test";
    }
}