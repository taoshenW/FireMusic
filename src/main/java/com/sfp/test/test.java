package com.sfp.test;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sfp.web.TestAdminController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

	@Autowired
	TestAdminController testAdminController;

	@Test
	public void exampleTest() throws JsonProcessingException {
		assertEquals("admin", testAdminController.findById(1).getName());
	}

}