package kz.edu.sdu.apps.uni.client;

import java.util.List;

import javax.ejb.Local;

import kz.edu.sdu.apps.uni.client.dto.CourseDTO;

@Local
public interface ICourseManagerLocal {	
	boolean createCourse(String name);
	List<CourseDTO> getCourses(String name);
}
