package kz.edu.sdu.apps.uni.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import kz.edu.sdu.apps.uni.client.ISubjectManagerLocal;
import kz.edu.sdu.apps.uni.client.ISubjectManagerRemote;
import kz.edu.sdu.apps.uni.client.dto.SubjectDTO;
import kz.edu.sdu.apps.uni.ejb.db.SubjectEntity;

@Stateless
public class SubjectManagerBean implements ISubjectManagerLocal, ISubjectManagerRemote {
	@PersistenceContext(unitName="UniPU")
	EntityManager em;

	@Override
	public List<SubjectDTO> getAllSubjects() {
		List<SubjectDTO> result = new ArrayList<SubjectDTO>();
		List<SubjectEntity> result2 = em.createQuery("Select s From SubjectEntity s").getResultList();
		for(SubjectEntity s2:result2){
			result.add(s2.toSubjectDTO());
		}
		return result;
	}	
}
