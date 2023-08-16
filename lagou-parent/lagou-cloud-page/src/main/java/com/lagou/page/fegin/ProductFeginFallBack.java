package com.lagou.page.fegin;

import com.lagou.pojo.Products;
import org.springframework.stereotype.Component;

@Component
public class ProductFeginFallBack implements ProductFegin{
    @Override
    public Products queryById(Integer id) {
        return new Products();
    }

    @Override
    public String getPort() {
        return null;
    }
}
