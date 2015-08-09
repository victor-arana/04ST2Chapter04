package com.strutstwoinaction.chapterfour;

import com.opensymphony.xwork2.ActionSupport;

public class ErrorProne extends ActionSupport {

	private static final long serialVersionUID = 3346759539969220407L;
	
	@Override
	public String execute() throws Exception {
		throw new Exception ( "Routine Code Explosion");
	}

}