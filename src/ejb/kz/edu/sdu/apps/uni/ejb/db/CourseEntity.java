package kz.edu.sdu.apps.uni.ejb.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import kz.edu.sdu.apps.uni.client.dto.CourseDTO;


@Entity
@Table(name="courses")
public class CourseEntity {

	private Long courseId;
	private String name;
	
	@Id
	@Column(name="course_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public CourseDTO toCourseDTO() {
		CourseDTO course=new CourseDTO();
		course.setCourseId(getCourseId());
		course.setName(getName());
		return course;
	}
	
	
	
}
