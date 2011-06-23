package kz.edu.sdu.apps.uni.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import kz.edu.sdu.apps.uni.client.ClassDTO;
import kz.edu.sdu.apps.uni.client.ClassSearchFilterDTO;
import kz.edu.sdu.apps.uni.client.IClassEnrollLocal;
import kz.edu.sdu.apps.uni.client.IClassEnrollRemote;
import kz.edu.sdu.apps.uni.ejb.db.ClassEntity;

@Stateless
public class ClassEnrollBean implements IClassEnrollLocal,IClassEnrollRemote{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<ClassDTO> search(ClassSearchFilterDTO filter,int page,int size) {
		String where="";
		
		if(filter.getFacultyId()!=null) 
			where+="class.facultyEntity.facultyId=:facultyId";
		
		if(filter.getTermId()!=null&&where.length()>1) 
			where+=" and class.termEntity.termId=:termId";
		else 
			where+="class.termEntity.termId=:termId";
		
		if(filter.getSubjectId()!=null&&where.length()>1) 
			where+=" and class.subjectEntity.subjectId=:subjectId";
		else 
			where+="class.subjectEntity.subjectId=:subjectId";
		
		List<ClassEntity> classes=em.createQuery("Select class From ClassEntity class "+where)
			.setParameter("facultyId",filter.getFacultyId())
			.setParameter("termId",filter.getTermId())
			.setParameter("subjectId",filter.getSubjectId())
			.getResultList();
		
		
		System.out.println(classes);
		
		return null;
	}

	
	
}
