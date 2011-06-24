package kz.edu.sdu.apps.uni.client.dto;

import java.io.Serializable;

public class CourseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6748578199490359474L;
	
	protected Long courseId;
	protected String name;
	
	public CourseDTO(){}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CourseDTO [courseId=" + courseId + ", name=" + name + "]";
	}

	
	
	
}
