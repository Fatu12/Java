package com.fatuma.form;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication

@Controller
public class FormApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormApplication.class, args);
	}
	@RequestMapping("/")
	public String index() {
		return "redirect:/counting";
	}

}
