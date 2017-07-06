package com.sfp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sfp.domain.Admin;
import com.sfp.service.TestAdminService;

@Controller
public class TestAdminController {

	@Autowired
	TestAdminService testAdminService;
	
	@RequestMapping("/admin")
    public Admin findById(int id) {
        return testAdminService.findById(id);
    }
	
}
