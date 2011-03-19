package com.qin;

import javax.ejb.Stateless;

@Stateless
public class HelloImpl implements Hello {
	public String getMessage() {
		return "Holaaaaaa";
	}
}
