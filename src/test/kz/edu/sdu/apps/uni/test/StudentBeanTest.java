package kz.edu.sdu.apps.uni.test;

import static org.junit.Assert.assertTrue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import kz.edu.sdu.apps.uni.client.IStudentBeanRemote;
import kz.edu.sdu.apps.uni.client.exceptions.ClassNotExistsException;
import kz.edu.sdu.apps.uni.client.exceptions.StudentAlreadyEnrolledClassException;
import kz.edu.sdu.apps.uni.client.exceptions.StudentNotExistsException;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StudentBeanTest {

	private static IStudentBeanRemote studentBean;
	private static Context ctx;

	private Long testStudentId=1L;
	private Long testClassId=1L;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@BeforeClass   
	public static void runBeforeClass() throws NamingException {   
		ctx=new InitialContext();
		studentBean=(IStudentBeanRemote) ctx.lookup("uni/StudentBean/remote");
		
		
	}   

	
	@Ignore @Test 
	public void testIsStudentEnrolledToClass(){
		boolean res=true;
		int count=0;
		try {
			res=studentBean.isStudentEnrolledToClass(-287349L, testClassId);
		} catch (StudentNotExistsException e) {
			count++;
		} catch (ClassNotExistsException e) {
		} catch (StudentAlreadyEnrolledClassException e) {
		}
		
		assert count==1;
		
		try {
			res=studentBean.isStudentEnrolledToClass(-287349L, testClassId);
		} catch (StudentNotExistsException e) {
		} catch (ClassNotExistsException e) {
			count++;
		} catch (StudentAlreadyEnrolledClassException e) {
		}

		assert count==2;

		try {
			res=studentBean.isStudentEnrolledToClass(testStudentId, testClassId);
			count++;
		} catch (StudentNotExistsException e) {
		} catch (ClassNotExistsException e) {
		} catch (StudentAlreadyEnrolledClassException e) {
		}

		assert count==3;
	}
	
	@Test
	public void testStudentWantsToEnrollClass(){
		boolean res=studentBean.studentWantsToEnrollClass(testStudentId, testClassId,"testGroup");
		assertTrue(res);
	}
	
}
