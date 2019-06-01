package com.cooper.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

	@RequestMapping("/test")
	public ModelAndView greeting() {
		ModelAndView modelAndView = new ModelAndView("/index");
        return modelAndView;
	}
}