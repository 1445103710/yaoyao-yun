package com.yao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.yao.project.*.*.mapper")
public class SpringbootServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServerApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  尧应用启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                     " ___.__._____    ____ ___.__._____    ____  \n" +
                        "<   |  |\\__  \\  /  _ <   |  |\\__  \\  /  _ \\ \n" +
                        " \\___  | / __ \\(  <_> )___  | / __ \\(  <_> )\n" +
                        " / ____|(____  /\\____// ____|(____  /\\____/ \n" +
                        " \\/          \\/       \\/          \\/        \n" +
                        "                                       "
        );
    }
}
