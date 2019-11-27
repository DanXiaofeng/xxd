package com.hqyj.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.demo.vo.ApplicationConfigTestBean;

@Controller
public class TestController {

	@Value("${server.port}")
	private int port;
	@Value("${com.hqyj.name}")
	private String name;
	@Value("${com.hqyj.age}")
	private int age;
	@Value("{com.hqyj.description}")
	private String description;
	@Value("${com.hqyj.random}")
	private String random;

	@Autowired
	private ApplicationConfigTestBean configTestBean;

	@RequestMapping("/test/config")
	@ResponseBody
	public String getConfig(){
		StringBuffer sb=new StringBuffer();
		sb.append(port)
		.append("-----").append(name)
		.append("----").append(age).append("<br>")
		.append("----").append(description).append("<br>")
		.append("----").append(random);
		sb.append(configTestBean.getName())
		.append("----").append(configTestBean.getAge())
		.append("----").append(configTestBean.getDescription())
		.append("----").append(configTestBean.getRandom()).append("</br>");
		return sb.toString();
	}

	@RequestMapping("/testInfo")
	@ResponseBody
	public String getInfo() {
		return "sb-lh.";
	}

}
