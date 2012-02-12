package ar.com.ospim.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.com.ospim.service.LoginService;

@Controller
public class ConsultaController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/secure/consultar.do")
	protected String consultar(Model model, HttpSession session)
			throws Exception {

		model.addAttribute("nombre", SecurityContextHolder.getContext()
				.getAuthentication().getName());
		return "consulta";
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}