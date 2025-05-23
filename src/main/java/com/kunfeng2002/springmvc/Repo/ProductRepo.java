package com.kunfeng2002.springmvc.Repo;

import com.kunfeng2002.springmvc.DTO.ProductDTO;
import com.kunfeng2002.springmvc.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

//    @Query(nativeQuery = true, value = "select * from product")
//    List<Product> findAll();

    @Query("select p from Product p")
    Page<Product> findAll(Pageable pageable);

    @Query(nativeQuery = true, value = "select * from product where id_product=?1")
    Product findById(int id);

    @Modifying
    @Query(nativeQuery = true, value = "delete from product where id_product =?1")
    Product delProduct(int id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into product " +
            "(id_product, name_product, description_product, price_product, category_product) " +
            "values (?1, ?2, ?3, ?4, ?5) ")
    Product addProduct(Product product);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update product " +
            "set name_product =?2, description_product =?3, price_product =?4, category_product=?5 where id_product=?1")
    ProductDTO updateProduct(ProductDTO productDTO);
}
