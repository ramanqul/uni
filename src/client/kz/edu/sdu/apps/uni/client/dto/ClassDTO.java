package kz.edu.sdu.apps.uni.client.dto;

import java.io.Serializable;


public class ClassDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4879789385513350082L;
	
	private Long classId;
	private SubjectDTO subject;
	private TermDTO term;
	private FacultyDTO faculty;
	private int seatNumber;
	private int credits;
	private String comments;
	private ClassStatus classStatus;
	
	public Long getClassId() {
		return classId;
	}
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	public SubjectDTO getSubject() {
		return subject;
	}
	public void setSubject(SubjectDTO subject) {
		this.subject = subject;
	}
	public TermDTO getTerm() {
		return term;
	}
	public void setTerm(TermDTO term) {
		this.term = term;
	}
	public FacultyDTO getFaculty() {
		return faculty;
	}
	public void setFaculty(FacultyDTO faculty) {
		this.faculty = faculty;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public ClassStatus getClassStatus() {
		return classStatus;
	}
	public void setClassStatus(ClassStatus classStatus) {
		this.classStatus = classStatus;
	}
	@Override
	public String toString() {
		return "ClassDTO [classId=" + classId + ", subject=" + subject
				+ ", term=" + term + ", faculty=" + faculty + ", seatNumber="
				+ seatNumber + ", credits=" + credits + ", comments="
				+ comments + "]";
	}
	
	
	
}
