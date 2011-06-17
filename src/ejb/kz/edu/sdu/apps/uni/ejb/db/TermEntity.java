package kz.edu.sdu.apps.uni.ejb.db;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="terms")
public class TermEntity {

	private Long termId;
	private String name;
	private Date startDate;
	private Date endDate;
	
	public TermEntity(){}

	
	@Id
	@Column(name="term_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getTermId() {
		return termId;
	}

	public void setTermId(Long id) {
		this.termId = id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="start_date")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name="end_date")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
}
