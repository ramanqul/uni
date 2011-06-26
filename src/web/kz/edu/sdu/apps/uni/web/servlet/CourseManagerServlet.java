package kz.edu.sdu.apps.uni.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

import kz.edu.sdu.apps.uni.client.ICourseManagerLocal;
import kz.edu.sdu.apps.uni.client.dto.CourseDTO;

public class CourseManagerServlet extends HttpServlet{
	@EJB ICourseManagerLocal courseManager;
	
	// courses/view/{id} - return one existing course
	// courses/ - return list of results
	// courses/new - post - create
	// courses/edit - post- save existing
	// courses/del - post - delete existing
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		String path=req.getRequestURI();
				
		XStream xstream=new XStream(new JsonHierarchicalStreamDriver());
		
		PrintWriter out=resp.getWriter();
		CourseDTO courses[]=courseManager.getCourses(null).toArray(new CourseDTO[]{}); 
		
		xstream.alias("courses", CourseDTO[].class);
		xstream.alias("course", CourseDTO.class);
		out.println(xstream.toXML(courses));		
		/*
		if(path.contains("view")) {

		} else {
			// return list of courses			
		}
						
		req.setAttribute("courses", courseManager.getCourses(null));
		req.getRequestDispatcher("/courses/courseManager.jsp").forward(req, resp);
		*/
	}
	
	// for create,update,delete operations
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		
		String path=req.getRequestURI();
		XStream xstream=new XStream(new JettisonMappedXmlDriver());
		String strJson=req.getParameter("course");
		CourseDTO course=new CourseDTO();
		xstream.alias("course", CourseDTO.class);
		xstream.fromXML(strJson, course);
				
		boolean result=courseManager.createCourse(course.getName());
		
		if(result) {
			out.print("{\"result\":\"ok\"}");
		} else {
			out.print("{\"result\":\"failed\"}");
		}
				
//		XStream xstream=new XStream(new JsonHierarchicalStreamDriver());
//		
//		PrintWriter out=resp.getWriter();
//		CourseDTO courses[]=courseManager.getCourses(null).toArray(new CourseDTO[]{}); 
//		
//		xstream.alias("courses", CourseDTO[].class);
//		xstream.alias("course", CourseDTO.class);
				
		if(path.contains("new")) {
			
		} else if(path.contains("del")) {
			// delete one			
		} else if(path.contains("edit")) {
			// edit one existing		
		}			
	}
}
