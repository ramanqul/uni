package kz.edu.sdu.apps.uni.client;

import javax.ejb.Local;

import kz.edu.sdu.apps.uni.client.exceptions.ClassNotExistsException;
import kz.edu.sdu.apps.uni.client.exceptions.StudentAlreadyEnrolledClassException;
import kz.edu.sdu.apps.uni.client.exceptions.StudentNotExistsException;

@Local
public interface IStudentBeanLocal {
	boolean isStudentEnrolledToClass(Long studentId,Long classId) throws StudentNotExistsException,ClassNotExistsException,StudentAlreadyEnrolledClassException;
	boolean studentWantsToEnrollClass(Long studentId,Long classId,String groupName);
}
