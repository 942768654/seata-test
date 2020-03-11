package com.sun.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void test(){
        jdbcTemplate.update("insert into order_tbl(user_id,money,update_time) value (1003,1,null)");
    }
}
