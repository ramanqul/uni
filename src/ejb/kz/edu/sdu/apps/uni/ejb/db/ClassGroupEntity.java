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
@Table(name="class_group")
public class ClassGroupEntity {

	private Long classGroupId;
	private ClassEntity classEntity;
	private String groupName;
	private Integer seatNumber;
	
	public ClassGroupEntity(){}

	@Id
	@Column(name="class_group_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getClassGroupId() {
		return classGroupId;
	}

	public void setClassGroupId(Long classGroupId) {
		this.classGroupId = classGroupId;
	}

	@ManyToOne
	@JoinColumn(name="class_id",referencedColumnName="class_id")
	public ClassEntity getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}

	@Column(name="group_name")
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Column(name="seat_number")
	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	
	
}
