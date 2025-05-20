package com.kunfeng2002.springmvc.Service;

import com.kunfeng2002.springmvc.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
}
