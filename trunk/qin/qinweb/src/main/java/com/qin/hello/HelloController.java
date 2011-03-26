package com.qin.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.qin.Hello;

@Controller
public class HelloController extends AbstractController {

	private static final long serialVersionUID = -1614274324160236963L;

	//EJB inyectado por spring
	//si fuera un servlet pelado con "@EJB" alcanza
	private Hello helloBean;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {

        ModelAndView mav = new ModelAndView("hello");
        mav.addObject("message", helloBean.getMessage());
        return mav;
	}

	public void setHelloBean(Hello helloBean) {
		this.helloBean = helloBean;
	}

	public Hello getHelloBean() {
		return helloBean;
	};
}
