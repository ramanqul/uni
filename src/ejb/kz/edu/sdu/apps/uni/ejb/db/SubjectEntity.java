package kz.edu.sdu.apps.uni.ejb.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import kz.edu.sdu.apps.uni.client.dto.SubjectDTO;


@Entity
@Table(name="subjects")
public class SubjectEntity {

	private Long subjectId;
	private String subjectCode;
	private String title;
	private String description;
	private CourseEntity courseEntity;
	
	public SubjectEntity(){}

	
	@Id
	@Column(name="subject_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	@Column(name="subject_code")
	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	@Column(name="title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="course_id",referencedColumnName="course_id")
	public CourseEntity getCourseEntity() {
		return courseEntity;
	}

	public void setCourseEntity(CourseEntity courseEntity) {
		this.courseEntity = courseEntity;
	}
	
	@Transient
	public SubjectDTO toSubjectDTO()	{
		SubjectDTO subject=new SubjectDTO();
		subject.setSubjectId(getSubjectId());
		subject.setDescription(getDescription());
		subject.setTitle(getTitle());
		subject.setSubjectCode(getSubjectCode());
		
		if(getCourseEntity()!=null)
			subject.setCourseDTO(getCourseEntity().toCourseDTO());
		
		return subject;
	}
}
