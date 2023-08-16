package com.lagou.product.service;

import com.lagou.pojo.Products;

/**
 * @author HP
 */
public interface ProductService {
    /**
     * 查询商品
     * @param id
     * @return
     */
    public Products findById(Integer id);
}
