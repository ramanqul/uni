package kz.edu.sdu.apps.uni.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import kz.edu.sdu.apps.uni.client.ITermManagerLocal;
import kz.edu.sdu.apps.uni.client.ITermManagerRemote;
import kz.edu.sdu.apps.uni.client.dto.TermDTO;
import kz.edu.sdu.apps.uni.ejb.db.TermEntity;

@Stateless
public class TermManagerBean implements ITermManagerLocal,ITermManagerRemote{
	@PersistenceContext(unitName="UniPU")
	EntityManager em;

	@Override
	public List<TermDTO> getAllTerms(){
		List<TermDTO> result = new ArrayList<TermDTO>();		
		List<TermEntity> result2 = em.createQuery("Select t From TermEntity t").getResultList();
		for(TermEntity t:result2) {
			result.add(t.toTermDTO());
		}
		return result;
	}
}
