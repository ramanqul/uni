package kz.edu.sdu.apps.uni.client.dto;

import java.io.Serializable;

public class FacultyDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4316568280638438737L;
	
	
	private Long facultyId;
	private String name;
	private String facultyCode;
	public Long getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFacultyCode() {
		return facultyCode;
	}
	public void setFacultyCode(String facultyCode) {
		this.facultyCode = facultyCode;
	}


	
	
}
