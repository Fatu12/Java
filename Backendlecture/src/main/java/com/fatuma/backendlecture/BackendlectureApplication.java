package com.fatuma.backendlecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class BackendlectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendlectureApplication.class, args);
	}
	// this is going to be redirect right we run our brower
	@GetMapping("/")
	public String rootRedirect() {
		
		return "redirect:/tweet";
	}

}
