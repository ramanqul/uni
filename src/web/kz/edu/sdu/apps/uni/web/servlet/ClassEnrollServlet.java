package kz.edu.sdu.apps.uni.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kz.edu.sdu.apps.uni.client.IClassEnrollLocal;
import kz.edu.sdu.apps.uni.client.IFacultyManagerLocal;
import kz.edu.sdu.apps.uni.client.ISubjectManagerLocal;
import kz.edu.sdu.apps.uni.client.ITermManagerLocal;
import kz.edu.sdu.apps.uni.client.dto.ClassDTO;
import kz.edu.sdu.apps.uni.client.dto.ClassSearchFilterDTO;

public class ClassEnrollServlet extends HttpServlet {

	@EJB ISubjectManagerLocal subjectManager;
	@EJB ITermManagerLocal termManager;
	@EJB IFacultyManagerLocal facultyManager;
	@EJB IClassEnrollLocal classEnroll;
	
	
	
	
	@Override
	public void service(ServletRequest req, ServletResponse arg1)
			throws ServletException, IOException {
		req.setAttribute("subjects", subjectManager.getAllSubjects());
		req.setAttribute("terms", termManager.getAllTerms());
		req.setAttribute("faculties", facultyManager.getAllFaculties());

		super.service(req, arg1);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/jsps/classSearch.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Long termId=null;
		
		if(req.getParameter("termId")!=null)
			termId=Long.parseLong(req.getParameter("termId"));
		
		Long subjectId=null;
		if(req.getParameter("subjectId")!=null)
			subjectId=Long.parseLong(req.getParameter("subjectId"));

		
		Long facultyId=null;
		
		if(req.getParameter("facultyId")!=null)
			facultyId=Long.parseLong(req.getParameter("facultyId"));
		
		ClassSearchFilterDTO filter = new ClassSearchFilterDTO();
		filter.setFacultyId(facultyId);
		filter.setSubjectId(subjectId);
		filter.setTermId(termId);
		
		List<ClassDTO> classes=classEnroll.search(filter, 0, 0);
		
		req.setAttribute("selectedSubjectId", subjectId);
		req.setAttribute("selectedTermId", termId);
		req.setAttribute("selectedFacultyId", facultyId);
		
		req.setAttribute("classes", classes);
		
		req.getRequestDispatcher("/jsps/classSearch.jsp").forward(req, resp);
	}
}
