package kz.edu.sdu.apps.uni.ejb.db;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import kz.edu.sdu.apps.uni.client.dto.ClassEnrollStatus;


@Entity
@Table(name="class_enroll")
public class ClassEnrollEntity {

	
	
	private Long classEnrollId;
	private ClassEntity classEntity;
	private StudentEntity studentEntity;
	private String groupName;
	private Date applyDate;
	private Date enrollDate;
	private ClassEnrollStatus status;
	
	
	public ClassEnrollEntity(){}

	@Id
	@Column(name="class_enroll_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getClassEnrollId() {
		return classEnrollId;
	}


	public void setClassEnrollId(Long classEnrollId) {
		this.classEnrollId = classEnrollId;
	}

	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="class_id",referencedColumnName="class_id")
	public ClassEntity getClassEntity() { 
		return classEntity;
	}


	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}


	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="student_id",referencedColumnName="student_id")
	public StudentEntity getStudentEntity() {
		return studentEntity;
	}


	public void setStudentEntity(StudentEntity studentEntity) {
		this.studentEntity = studentEntity;
	}


	@Column(name="group_name")
	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Column(name="apply_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getApplyDate() {
		return applyDate;
	}


	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}


	@Column(name="enroll_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}


	@Enumerated(EnumType.STRING)
	@Column(name="enroll_status")
	public ClassEnrollStatus getEnrollStatus() {
		return status;
	}


	public void setEnrollStatus(ClassEnrollStatus status) {
		this.status = status;
	}
	
	
	
	
}
