package kz.edu.sdu.apps.uni.client;

import kz.edu.sdu.apps.uni.client.dto.FacultyDTO;
import kz.edu.sdu.apps.uni.client.dto.SubjectDTO;
import kz.edu.sdu.apps.uni.client.dto.TermDTO;

public class ClassDTO {

	private Long classId;
	private SubjectDTO subject;
	private TermDTO term;
	private FacultyDTO faculty;
	private int seatNumber;
	private int credits;
	private String comments;
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
	
	
	
}
