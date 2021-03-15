package me.umov.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

	@Value("${version}")
	private String version;

	@GetMapping(value = { "", "status" })
	public String index() {
		return "uMov.me Scaffold - " + getVersion();
	}

	public String getVersion() {
		return version;
	}

}
