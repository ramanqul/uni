package kz.edu.sdu.apps.uni.client.dto;

import java.io.Serializable;

public class ClassSearchFilterDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3758146746251947956L;
	
	private Long termId;
	private Long facultyId;
	private Long subjectId;
	
	
	public Long getTermId() {
		return termId;
	}
	public void setTermId(Long termId) {
		this.termId = termId;
	}
	public Long getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	
	
	
}
