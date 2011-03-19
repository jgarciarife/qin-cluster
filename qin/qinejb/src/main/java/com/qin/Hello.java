package com.qin;

import javax.ejb.Local;

@Local
public interface Hello {
	public String getMessage();
}
