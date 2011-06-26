package kz.edu.sdu.apps.uni.ejb;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import kz.edu.sdu.apps.uni.client.IStudentBeanLocal;
import kz.edu.sdu.apps.uni.client.IStudentBeanRemote;
import kz.edu.sdu.apps.uni.client.dto.ClassEnrollStatus;
import kz.edu.sdu.apps.uni.client.exceptions.ClassNotExistsException;
import kz.edu.sdu.apps.uni.client.exceptions.StudentAlreadyEnrolledClassException;
import kz.edu.sdu.apps.uni.client.exceptions.StudentNotExistsException;
import kz.edu.sdu.apps.uni.ejb.db.ClassEnrollEntity;
import kz.edu.sdu.apps.uni.ejb.db.ClassEntity;
import kz.edu.sdu.apps.uni.ejb.db.StudentEntity;

@Stateless
public class StudentBean implements IStudentBeanLocal,IStudentBeanRemote{
	@PersistenceContext(unitName="UniPU")
	EntityManager em;

	@Override
	public boolean isStudentEnrolledToClass(Long studentId, Long classId)
			throws StudentNotExistsException, ClassNotExistsException,
			StudentAlreadyEnrolledClassException {

		StudentEntity student=em.find(StudentEntity.class, studentId);
		if(student==null) throw new StudentNotExistsException(String.format("Student with studentId(%s) does not exists",studentId));
		
		ClassEntity clazz=em.find(ClassEntity.class, classId);
		if(clazz==null) throw new ClassNotExistsException(String.format("Class with classId(%s) does not exists",classId));
		
		long count=(Long) em.createQuery("Select count(ce) from ClassEnrollEntity ce Where ce.studentEntity.studentId=:studentId and ce.classEntity.classId=:classId and ce.enrollStatus in(:waitingStatus,:enrolledStatus)")
			.setParameter("studentId", studentId)
			.setParameter("classId", classId)
			.setParameter("waitingStatus", ClassEnrollStatus.WAITING)
			.setParameter("enrolledStatus", ClassEnrollStatus.ENROLLED)
			.getSingleResult();				
		
		if(count>0L) 
				throw new StudentAlreadyEnrolledClassException(String.format("Student(%s) has already taken Class(%s)",studentId,classId));

		return false;
	}

	@Override
	public boolean studentWantsToEnrollClass(Long studentId, Long classId,String groupName) {
		try {
			if(!isStudentEnrolledToClass(studentId, classId)) {
				ClassEnrollEntity ce=new ClassEnrollEntity();
				ce.setStudentEntity(em.find(StudentEntity.class,studentId));
				ce.setClassEntity(em.find(ClassEntity.class,classId));
				ce.setApplyDate(new Date());
				ce.setEnrollStatus(ClassEnrollStatus.WAITING);
				ce.setGroupName(groupName);
				em.persist(ce);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}		
}
