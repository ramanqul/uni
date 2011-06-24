package kz.edu.sdu.apps.uni.test;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import kz.edu.sdu.apps.uni.client.IClassEnrollRemote;
import kz.edu.sdu.apps.uni.client.dto.ClassDTO;
import kz.edu.sdu.apps.uni.client.dto.ClassSearchFilterDTO;

import org.junit.BeforeClass;
import org.junit.Test;

public class ClassEnrollBeanTest {

	private static IClassEnrollRemote classEnrollBean;
	private static Context ctx;

	private Long testStudentId=1L;
	private Long testClassId=1L;
	
	
	@BeforeClass   
	public static void runBeforeClass() throws NamingException {   
		ctx=new InitialContext();
		classEnrollBean=(IClassEnrollRemote) ctx.lookup("uni/ClassEnrollBean/remote");
	}   

	
	@Test //@Ignore 
	public void testClassSearch(){
		ClassSearchFilterDTO filter=new ClassSearchFilterDTO();
		filter.setSubjectId(1L);
		filter.setFacultyId(1L);
		
		
		List<ClassDTO> classes=classEnrollBean.search(filter, 0, 0);
		System.out.println(classes);
		
	}
	
}
