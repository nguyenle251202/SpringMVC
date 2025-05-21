package com.kunfeng2002.springmvc.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(schema = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduct")
    private int Pid;

    @Column(name = "nameProduct")
    private String Pname;

    @Column(name = "descriptionProduct")
    private String Pdescription;

    @Column(name = "priceProduct")
    private double Pprice;

    @Column(name = "categoryProduct")
    private String Pcategory;
}
