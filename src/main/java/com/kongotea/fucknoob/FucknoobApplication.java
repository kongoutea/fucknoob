package com.kongotea.fucknoob;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kongotea.fucknoob.mapper")
public class FucknoobApplication {

    public static void main(String[] args) {
        SpringApplication.run(FucknoobApplication.class, args);
    }


}
