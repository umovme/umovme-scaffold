package me.umov.springbootdemo.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	public String hello(@RequestParam Optional<String> name) {
		var greetingName = "'no request parameter name informed'";

		if (name.isPresent())
			greetingName = name.get();

		return "Hello, " + greetingName;
	}

}
