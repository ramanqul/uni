package kz.edu.sdu.apps.uni.web.servlet.exceptions;

import javax.servlet.ServletException;

public class PageNotFoundException extends ServletException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4031413760919134L;

	public PageNotFoundException(String title)	{
		super(title);
	}
	
}
