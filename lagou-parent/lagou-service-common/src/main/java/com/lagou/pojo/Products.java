package com.lagou.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * products
 */
@Data
@Table(name="products")
public class Products implements Serializable {
    @Id
    private Integer id;

    private String name;

    private BigDecimal price;

    private String flag;

    private String images;

    private String goodstype;

    private byte[] goodsstock;

    private static final long serialVersionUID = 1L;
}