package kz.edu.sdu.apps.uni.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kz.edu.sdu.apps.uni.client.IClassEnrollLocal;
import kz.edu.sdu.apps.uni.client.IFacultyManagerLocal;
import kz.edu.sdu.apps.uni.client.ISubjectManagerLocal;
import kz.edu.sdu.apps.uni.client.ITermManagerLocal;
import kz.edu.sdu.apps.uni.client.dto.ClassDTO;
import kz.edu.sdu.apps.uni.client.dto.ClassSearchFilterDTO;
import kz.edu.sdu.apps.uni.client.exceptions.ClassNotExistsException;
import kz.edu.sdu.apps.uni.web.servlet.exceptions.PageNotFoundException;

/**
 * @author Buzaubakov_Raman
 *
 */
public class ClassEnrollServlet extends HttpServlet {

	@EJB ISubjectManagerLocal subjectManager;
	@EJB ITermManagerLocal termManager;
	@EJB IFacultyManagerLocal facultyManager;
	@EJB IClassEnrollLocal classEnroll;
	
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path=req.getRequestURI();
		
		String direction=processPath(path);
		
		if("search".equals(direction)) {
			doGetSearchPage(req, resp);
		} else if("apply".equals(direction)) {
			doGetApplyPage(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String path=req.getRequestURI();
		
		String direction=processPath(path);
		
		if("search".equals(direction)) {
			doPostSearchPage(req, resp);
		} else if("apply".equals(direction)) {
			//TODO: doPostApplyPage(..,..);
			doPostApplyPage(req, resp);
		}
		
		
	}
	
	/**
	 * @param path:String
	 * @return (the 4-th element i path splited by slash):String
	 */
	private String processPath(String path)	{
		// /uni/class/{subpage}
		
		String[] subs=path.split("/");
		if(subs.length<3) return null;
		return subs[3];
		
	}
	
	private void doGetSearchPage(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException	{
		req.setAttribute("subjects", subjectManager.getAllSubjects());
		req.setAttribute("terms", termManager.getAllTerms());
		req.setAttribute("faculties", facultyManager.getAllFaculties());
		
		req.getRequestDispatcher("/jsps/classSearch.jsp").forward(req, resp);
	}
	private void doPostSearchPage(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException	{
		req.setAttribute("subjects", subjectManager.getAllSubjects());
		req.setAttribute("terms", termManager.getAllTerms());
		req.setAttribute("faculties", facultyManager.getAllFaculties());
		
		Long termId=null;
		
		if(req.getParameter("termId")!=null)
			try {
				termId=Long.parseLong(req.getParameter("termId"));	
			} catch (NumberFormatException e) {
				// termId=null;
			}
		
		Long subjectId=null;
		if(req.getParameter("subjectId")!=null)
			try {
				subjectId=Long.parseLong(req.getParameter("subjectId"));	
			} catch (NumberFormatException e) {
				// subjectId=null;
			}
		
		Long facultyId=null;
		
		if(req.getParameter("facultyId")!=null)
			try {
				facultyId=Long.parseLong(req.getParameter("facultyId"));	
			} catch (NumberFormatException e) {
				// facultyId=null;
			}
		
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
	
	private void doGetApplyPage(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException, PageNotFoundException	{
		String classIdStr=req.getParameter("id");
		
		long classId=0l;
		try {
			classId=Long.parseLong(classIdStr);
		} catch(NumberFormatException e) {
			//TODO: show 404 page 
			throw new PageNotFoundException("");
		}
		
		ClassDTO foundClassDTO=null;
		
		try {
			foundClassDTO=classEnroll.getClassById(classId);
		} catch (ClassNotExistsException e) {
			//TODO: show 404 page 
			throw new PageNotFoundException("");
		}
		
		req.setAttribute("foundClass",foundClassDTO);
		
		req.getRequestDispatcher("/jsps/classApply.jsp").forward(req, resp);
	}
	
	
	private void doPostApplyPage(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException	{
		req.setAttribute("error", "Some Error!");
		String classIdStr=req.getParameter("id");
		
		long classId=0l;
		try {
			classId=Long.parseLong(classIdStr);
		} catch(NumberFormatException e) {
			//TODO: show 404 page 
			throw new PageNotFoundException("");
		}
		
		ClassDTO foundClassDTO=null;
		
		try {
			foundClassDTO=classEnroll.getClassById(classId);
		} catch (ClassNotExistsException e) {
			//TODO: show 404 page 
			throw new PageNotFoundException("");
		}
		
		req.setAttribute("foundClass",foundClassDTO);
		
		req.getRequestDispatcher("/jsps/classApply.jsp").forward(req, resp);
	}
}
