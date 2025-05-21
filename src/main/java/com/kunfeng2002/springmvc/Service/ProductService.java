package com.kunfeng2002.springmvc.Service;

import com.kunfeng2002.springmvc.DTO.ProductDTO;
import com.kunfeng2002.springmvc.Repo.ProductRepo;
import com.kunfeng2002.springmvc.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id);
    }

    public Product getDelete(int id) {
        productRepo.findById(id);
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            System.out.println("Xoa xog");
        }
        else {
            System.out.println("Co dell dau ma doi xoa");
        }
        return null;
    }
//
//    public void batchAdd(ProductDTO productDTO) {
//        Product product = productRepo.findById(productDTO.getPid());
//        if (product != null) {
//            product.setPid(productDTO.getPid());
//            product.setPname(productDTO.getPname());
//            product.setPdescription(productDTO.getPdescription());
//            product.setPprice(productDTO.getPprice());
//            product.setPcategory(productDTO.getPcategory());
//            productRepo.save(product);
//        }
//        else {
//            System.out.println("<UNK>");
//        }
//    }

//    public void batchUpdate(ProductDTO productDTO) {
//        Product product = productRepo.findById(productDTO.getPid());
//        if (product != null) {
//            product.setPname(productDTO.getPname());
//            product.setPdescription(productDTO.getPdescription());
//            product.setPprice(productDTO.getPprice());
//            product.setPcategory(productDTO.getPcategory());
//            productRepo.save(product);
//        }
//        else {
//            System.out.println("<UNK>");
//        }
//    }
}
