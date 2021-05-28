package com.doraemon.microservice.utils;

import com.doraemon.microservice.base.log.LogUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LogUtilsTest {
    @Test
    public void logTest() {
        Logger log = LogUtils.getExceptionLogger();
        Logger log1 = LogUtils.getBussinessLogger();
        Logger log2 = LogUtils.getDBLogger();

        log.error("getExceptionLogger===日志测试");
        log1.info("getBussinessLogger===日志测试");
        log2.debug("getDBLogger===日志测试");
    }

}