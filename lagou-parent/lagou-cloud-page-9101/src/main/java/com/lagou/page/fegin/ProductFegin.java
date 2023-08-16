package com.lagou.page.fegin;

import com.lagou.pojo.Products;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Component
@FeignClient(name="lagou-service-product",fallback = ProductFeginFallBack.class)
public interface ProductFegin {
    @GetMapping("product/query/{id}")
    public Products queryById(@PathVariable Integer id);
    @GetMapping("service/getPort")
    public String getPort();
}
