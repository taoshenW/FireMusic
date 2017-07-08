package com.sfp.test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sfp.web.LoginController;
import com.sfp.web.TestAdminController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

	@Value("${temp.path}")
	String path;
	@Autowired
	LoginController loginController;
	@Mock
	HttpSession session;

	@Test
	public void exampleTest() throws JsonProcessingException {
		System.out.println(path);
		//assertEquals(true, loginController.checkLogin("韬神w", "123456",session));
	}

}