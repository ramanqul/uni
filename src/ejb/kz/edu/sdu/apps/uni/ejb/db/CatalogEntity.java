package kz.edu.sdu.apps.uni.ejb.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="catalogs")
public class CatalogEntity {

	private Long catalogId;
	private Integer credits;
	private SubjectEntity subjectEntity;
	private FacultyEntity facultyEntity;
	private TermEntity termEntity;
	
	public CatalogEntity(){}


	@Id
	@Column(name="catalog_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}
	
	@Column(name="credits")
	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	@ManyToOne
	@JoinColumn(name="subject_id",referencedColumnName="subject_id")
	public SubjectEntity getSubjectEntity() {
		return subjectEntity;
	}

	public void setSubjectEntity(SubjectEntity subjectEntity) {
		this.subjectEntity = subjectEntity;
	}

	@ManyToOne
	@JoinColumn(name="faculty_id",referencedColumnName="faculty_id")
	public FacultyEntity getFacultyEntity() {
		return facultyEntity;
	}

	public void setFacultyEntity(FacultyEntity facultyEntity) {
		this.facultyEntity = facultyEntity;
	}

	@ManyToOne
	@JoinColumn(name="term_id",referencedColumnName="term_id")
	public TermEntity getTermEntity() {
		return termEntity;
	}

	public void setTermEntity(TermEntity termEntity) {
		this.termEntity = termEntity;
	}
}
