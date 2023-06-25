package com.fatuma.lecture3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller

public class SessionControllers {
	@RequestMapping("/counting")
//	@GetMapping("/")
//	we can add Model but if we don't want to we don't have too
	public String index() {
//		Integer sessionValue =0;
//		session.setAttribute("count", sessionValue);
//		model.addAttribute("currentCount", sessionValue);
	return "Hello";

}}
