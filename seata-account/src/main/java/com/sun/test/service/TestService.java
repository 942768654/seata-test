package com.sun.test.service;

import com.sun.test.fegin.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    @Qualifier("accountJdbcTemplate")
    JdbcTemplate accountJdbcTemplate;

    @Autowired
    @Qualifier("storageJdbcTemplate")
    JdbcTemplate storageJdbcTemplate;

    @Autowired
    OrderService orderService;

    @GlobalTransactional
    public void test(){
        accountJdbcTemplate.update("insert into account_tbl(user_id,money) value (1003,1)");
        orderService.test();
        storageJdbcTemplate.update("insert into storage_tbl(commodity_code,count) value (300,20)");
        int a = 1/0;
    }
}
