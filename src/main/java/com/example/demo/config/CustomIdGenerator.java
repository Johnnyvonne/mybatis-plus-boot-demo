package com.example.demo.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.example.demo.util.SnowflakeIdGenerator;
import org.springframework.stereotype.Component;

@Component
public class CustomIdGenerator implements IdentifierGenerator {
    @Override
    public Number nextId(Object entity) {
        return SnowflakeIdGenerator.next();
    }
}
