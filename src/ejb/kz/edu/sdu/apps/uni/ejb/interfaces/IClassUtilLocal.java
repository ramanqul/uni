package kz.edu.sdu.apps.uni.ejb.interfaces;

import javax.ejb.Local;

import kz.edu.sdu.apps.uni.client.exceptions.ClassNotExistsException;
import kz.edu.sdu.apps.uni.ejb.db.ClassEntity;

@Local
public interface IClassUtilLocal {
	ClassEntity getClassById(long id) throws ClassNotExistsException;
}
