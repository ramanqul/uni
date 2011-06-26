package kz.edu.sdu.apps.uni.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kz.edu.sdu.apps.uni.client.ICommonBeanLocal;

public class CommonServlet extends HttpServlet{
	@EJB ICommonBeanLocal commonBean;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		out.print(commonBean.test());
	}
}
