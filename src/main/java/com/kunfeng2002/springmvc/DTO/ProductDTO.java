package com.kunfeng2002.springmvc.DTO;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.kunfeng2002.springmvc.model.Product}
 */
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ProductDTO implements Serializable {
    private int Pid;
    private String Pname;
    private String Pdescription;
    private double Pprice;
    private String Pcategory;
}