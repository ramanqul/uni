package kz.edu.sdu.apps.uni.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import kz.edu.sdu.apps.uni.client.IFacultyManagerLocal;
import kz.edu.sdu.apps.uni.client.IFacultyManagerRemote;
import kz.edu.sdu.apps.uni.client.dto.FacultyDTO;
import kz.edu.sdu.apps.uni.ejb.db.FacultyEntity;

@Stateless
public class FacultyManagerBean implements IFacultyManagerLocal, IFacultyManagerRemote {
	@PersistenceContext(unitName="UniPU")
	EntityManager em;
	
	public List<FacultyDTO> getAllFaculties(){
		List<FacultyDTO> result = new ArrayList<FacultyDTO>();
		List<FacultyEntity> result2 = em.createQuery("Select f From FacultyEntity f").getResultList();
		for(FacultyEntity f2:result2){			
			result.add(f2.toFacultyDTO());
		}
		return result;
	}
}
