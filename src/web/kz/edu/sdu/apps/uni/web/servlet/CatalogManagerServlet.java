package kz.edu.sdu.apps.uni.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kz.edu.sdu.apps.uni.client.ICatalogManagerLocal;
import kz.edu.sdu.apps.uni.client.dto.FacultyDTO;
import kz.edu.sdu.apps.uni.client.dto.SubjectDTO;
import kz.edu.sdu.apps.uni.client.dto.TermDTO;

public class CatalogManagerServlet extends HttpServlet{

	@EJB ICatalogManagerLocal catalogManager;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {

		SubjectDTO subject=new SubjectDTO();
		TermDTO term=new TermDTO();
		FacultyDTO faculty=new FacultyDTO();

		int credits=4;

		if("a1".equals(req.getParameter("action"))) {
			subject.setSubjectId(1L);
			term.setTermId(1L);
			faculty.setFacultyId(10L);
		} else {
			subject.setSubjectCode("SBJ");
			subject.setDescription("Some Description");
			subject.setTitle("Some Title");


			term.setName("Fall 2010/2011");
			term.setStartDate(new Date());
			term.setEndDate(new Date());

			faculty.setFacultyCode("EN");
			faculty.setName("Engineering");

		}
		
		boolean result=catalogManager.createCatalog(credits, subject, faculty, term);

		PrintWriter out=resp.getWriter();
		out.print("result: "+result);

	}



}
