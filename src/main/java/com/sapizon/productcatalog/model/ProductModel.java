package com.sapizon.productcatalog.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
public class ProductModel implements Serializable {

    private Long id;
    private String productName;
    private boolean available;
}
