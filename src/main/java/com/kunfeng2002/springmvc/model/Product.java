package com.kunfeng2002.springmvc.model;

import com.kunfeng2002.springmvc.annotation.ControllerAdvice;
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
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduct")
    private int Pid;

    @ControllerAdvice(message = "CMM, name dell dc phep co ky tu dac biet")
    @Column(name = "nameProduct")
    private String Pname;

    @Column(name = "descriptionProduct")
    private String Pdescription;

    @Column(name = "priceProduct")
    private double Pprice;

    @Column(name = "categoryProduct")
    private String Pcategory;
}
