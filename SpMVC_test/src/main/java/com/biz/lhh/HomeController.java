package com.biz.lhh;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/babo")
@Controller
public class HomeController {
	
	@RequestMapping(value = "/babo/lhh", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "list";
	}
	
	@RequestMapping(value = "/cat/lhh", method = RequestMethod.GET)
	public String home1(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/no/lhh", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) {
		return "home";
	}
	
}
