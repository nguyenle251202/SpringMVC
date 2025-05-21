package com.kunfeng2002.springmvc.DTO;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.kunfeng2002.springmvc.model.Product}
 */
@Value
public class ProductDTO implements Serializable {
    int Pid;
    String Pname;
    String Pdescription;
    double Pprice;
    String Pcategory;
}