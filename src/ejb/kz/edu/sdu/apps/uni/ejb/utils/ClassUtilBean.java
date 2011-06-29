package kz.edu.sdu.apps.uni.ejb.utils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import kz.edu.sdu.apps.uni.client.exceptions.ClassNotExistsException;
import kz.edu.sdu.apps.uni.ejb.db.ClassEntity;
import kz.edu.sdu.apps.uni.ejb.interfaces.IClassUtilLocal;


@Stateless
public class ClassUtilBean implements IClassUtilLocal{

	@PersistenceContext(unitName="UniPU")
	EntityManager em;
	
	@Override
	public ClassEntity getClassById(long id) throws ClassNotExistsException {
		ClassEntity foundClass=em.find(ClassEntity.class, id);
		if(foundClass==null) throw new ClassNotExistsException(String.format("Class(id=%s) does not exists",id));
		return foundClass;
	}

}