package com.sfp.test;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.*;

import com.fasterxml.jackson.core.JsonProcessingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

	@Autowired
	RedisTemplate<String, String> redisTemplate;
	@Value("${spring.datasource.url}")
	String value;

	@Test
	public void exampleTest() throws JsonProcessingException {
		System.out.println(value);
	}

}