package kz.edu.sdu.apps.uni.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import kz.edu.sdu.apps.uni.client.ICourseManagerRemote;

public class CourseManagerTest {

	public static void main(String[] args) throws NamingException {
		Context ctx=new InitialContext();
		ICourseManagerRemote courseManager=(ICourseManagerRemote) ctx.lookup("uni/CourseManagerBean/remote");
		System.out.println(courseManager.createCourse("Programming"));
	}
	
}
