package com.qin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class ElaboracionTPController extends MultiActionController{

	@RequestMapping(value = "/alta_tp.html")
	public String altaTP(){
		return "/trabajos_practicos/alta_tp";
	}
}
