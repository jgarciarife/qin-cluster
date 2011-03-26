package com.qin.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.qin.Registracion;

@Controller
public class LoginController extends AbstractController {

	// EJB inyectado por spring
	// si fuera un servlet pelado con "@EJB" alcanza
	private Registracion registracionBean;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		String user = req.getParameter("user");
		getRegistracionBean().login(user);

		ModelAndView mav = new ModelAndView("home");
		return mav;
	}

	public void setRegistracionBean(Registracion registracionBean) {
		this.registracionBean = registracionBean;
	}

	public Registracion getRegistracionBean() {
		return registracionBean;
	}
}
