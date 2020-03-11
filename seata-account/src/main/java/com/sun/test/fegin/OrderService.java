package com.sun.test.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "spring-cloud-order")
public interface OrderService {

    @RequestMapping("/insert")
    void test();
}
