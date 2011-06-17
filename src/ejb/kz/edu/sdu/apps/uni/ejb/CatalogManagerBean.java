package kz.edu.sdu.apps.uni.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import kz.edu.sdu.apps.uni.client.ICatalogManagerLocal;
import kz.edu.sdu.apps.uni.client.ICatalogManagerRemote;
import kz.edu.sdu.apps.uni.client.dto.FacultyDTO;
import kz.edu.sdu.apps.uni.client.dto.SubjectDTO;
import kz.edu.sdu.apps.uni.client.dto.TermDTO;
import kz.edu.sdu.apps.uni.ejb.db.CatalogEntity;
import kz.edu.sdu.apps.uni.ejb.db.FacultyEntity;
import kz.edu.sdu.apps.uni.ejb.db.SubjectEntity;
import kz.edu.sdu.apps.uni.ejb.db.TermEntity;

@Stateless
public class CatalogManagerBean implements ICatalogManagerLocal,ICatalogManagerRemote{

	
	@PersistenceContext(unitName="UniPU")
	EntityManager em;
	
	@Override
	public boolean createCatalog(Integer credits, SubjectDTO subjectDTO,
			FacultyDTO facultyDTO,TermDTO termDTO) {

		CatalogEntity catalog=new CatalogEntity();
		
		SubjectEntity subject=new SubjectEntity(); 
		
		FacultyEntity faculty=new FacultyEntity();
		faculty.setFacultyId(facultyDTO.getFacultyId());
		
		catalog.setFacultyEntity(faculty);
		catalog.setSubjectEntity(subject);
		
		TermEntity term=new TermEntity();
		
		em.persist(catalog);
		
		return false;
	}

}
