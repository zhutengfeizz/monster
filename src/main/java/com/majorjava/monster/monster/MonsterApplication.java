package com.majorjava.monster.monster;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.majorjava.monster.monster.mapper")
public class MonsterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonsterApplication.class, args);
    }

}
