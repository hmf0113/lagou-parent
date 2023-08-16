package com.lagou.page.controller;

import com.lagou.page.fegin.ProductFegin;
import com.lagou.pojo.Products;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("page")
public class PageController {
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private DiscoveryClient discoveryClient;
    @Autowired
    private ProductFegin productFeign;

    @GetMapping("getProduct/{id}")
    public Products getProduct(@PathVariable Integer id){
        return productFeign.queryById(id);
    }
    @GetMapping("loadProductServicePort")
    public String getProductServerPort(){

        return productFeign.getPort();
    }
    @GetMapping("loadProductServicePort2")
    @HystrixCommand(
            threadPoolKey = "getProductServerPort2", //给线程池起的一个名称，实际方法每个方法维护一个线程池，如果重复将会两个方法维护一个线程池
            //每一个属性对应的都是一个hystrixproper
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize",value = "1"),//并发线程数
                    @HystrixProperty(name = "maxQueueSize",value = "20")//默认线程队列值是-1

            },
            //超时时间的设置,都是command
            commandProperties = {
                    //设置请求的超时时间,一旦超过此时间按超时处理
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
            }

    )
    public String getProductServerPort2(){

        return productFeign.getPort();
    }
    @HystrixCommand(
            commandProperties = {
                    //设置请求的超时时间,一旦超过此时间按超时处理
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
            },//回退的方法不在commandProperties里面
            fallbackMethod = "getProductServerPortFallBack"
    )
    @GetMapping("loadProductServicePort3")
    public String getProductServerPort3(){

       return productFeign.getPort();
    }
    /**
     * 定义回退方法，当请求触发熔断后执行的补救措施
     *  注意：
     *  1.方法形参和原方法保持一致
     *  2.方法的返回值与原方法保持一致
     */

    public String getProductServerPortFallBack(){
        return "-1";
    }
}
