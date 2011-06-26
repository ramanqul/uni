package kz.edu.sdu.apps.uni.ejb.db;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import kz.edu.sdu.apps.uni.client.dto.ClassDTO;
import kz.edu.sdu.apps.uni.client.dto.ClassStatus;


@Entity
@Table(name="classes")
public class ClassEntity {

	private Long classId;
	private SubjectEntity subjectEntity;
	private TermEntity termEntity;
	private FacultyEntity facultyEntity;
	private Integer seatNumber;
	private Integer credits;
	private String comments;
	private ClassStatus classStatus;
	
	public ClassEntity(){}

	
	@Id
	@Column(name="class_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="subject_id",referencedColumnName="subject_id")
	public SubjectEntity getSubjectEntity() {
		return subjectEntity;
	}

	public void setSubjectEntity(SubjectEntity subjectEntity) {
		this.subjectEntity = subjectEntity;
	}

	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="term_id",referencedColumnName="term_id")
	public TermEntity getTermEntity() {
		return termEntity;
	}

	public void setTermEntity(TermEntity termEntity) {
		this.termEntity = termEntity;
	}

	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="faculty_id",referencedColumnName="faculty_id")
	public FacultyEntity getFacultyEntity() {
		return facultyEntity;
	}

	public void setFacultyEntity(FacultyEntity facultyEntity) {
		this.facultyEntity = facultyEntity;
	}

	@Column(name="seat_number")
	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	@Column(name="credits")
	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	@Column(name="comments")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="class_status")
	public ClassStatus getClassStatus() {
		return classStatus;
	}


	public void setClassStatus(ClassStatus classStatus) {
		this.classStatus = classStatus;
	}


	@Transient
	public ClassDTO toClassDTO()	{
		ClassDTO clazz=new ClassDTO();
		clazz.setClassId(getClassId());
		clazz.setComments(getComments());
		clazz.setCredits(getCredits());
		clazz.setSeatNumber(getSeatNumber());
		clazz.setClassStatus(getClassStatus());
		
		if(getFacultyEntity()!=null)
			clazz.setFaculty(getFacultyEntity().toFacultyDTO());
		if(getTermEntity()!=null) 
			clazz.setTerm(getTermEntity().toTermDTO());
		if(getSubjectEntity()!=null) 
			clazz.setSubject(getSubjectEntity().toSubjectDTO());
		
		return clazz;
	}
	
	
}
