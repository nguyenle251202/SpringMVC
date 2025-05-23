package com.kunfeng2002.springmvc.Service;

import com.kunfeng2002.springmvc.DTO.ProductDTO;
import com.kunfeng2002.springmvc.Repo.ProductRepo;
import com.kunfeng2002.springmvc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
//
//    public ProductService(ProductRepo productRepo) {
//        this.productRepo = productRepo;
//    }

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepo.findAll(pageable);
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

    public void getAdd(ProductDTO productDTO) {
        productRepo.findById(productDTO.getPid());
        if(productRepo.existsById(productDTO.getPid())) {
            Product product1 = new Product();
            product1.setPid(productDTO.getPid());
            product1.setPname(productDTO.getPname());
            product1.setPdescription(productDTO.getPdescription());
            product1.setPprice(productDTO.getPprice());
            product1.setPcategory(productDTO.getPcategory());
            productRepo.save(product1);
            System.out.println("Xoa xog");
        }
        else {
            System.out.println("ID nay co r, chon ID khac di");
        }
    }

    public void getUpdate(ProductDTO productDTO) {
        Product product = productRepo.findById(productDTO.getPid());
        product.setPname(productDTO.getPname());
        product.setPdescription(productDTO.getPdescription());
        product.setPprice(productDTO.getPprice());
        product.setPcategory(productDTO.getPcategory());
        productRepo.save(product);
    }

}
