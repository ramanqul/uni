package kz.edu.sdu.apps.uni.web.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kz.edu.sdu.apps.uni.client.ICourseManagerLocal;

public class CourseManagerServlet extends HttpServlet{

	@EJB ICourseManagerLocal courseManager;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setAttribute("courses", courseManager.getCourses(null));
		
		req.getRequestDispatcher("/courseManager.jsp").forward(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
	
}
