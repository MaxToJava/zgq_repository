package com.zgq.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

/**
 * TODO
 *
 * @author zgq
 * @date 2020/10/28
 */
@SpringBootApplication
@MapperScan("com.zgq.mall.mapper")
public class MallApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class,args);
    }
}
