package com.dyh.transaction;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.concurrent.CountDownLatch;

/**
 * Created by dengyunhui on 2017/12/5 13:31.
 */
@MapperScan({"com.dyh.transaction.dao.mapper"})
@SpringBootApplication
@ComponentScan(basePackages = { "com.dyh.transaction"})
public class Bootstrap {
    private static final Logger log = LoggerFactory.getLogger(Bootstrap.class);

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new SpringApplicationBuilder().sources(Bootstrap.class).web(false).run(args);

        log.info("transaction 启动成功！");
        countDownLatch.await();
    }
}
