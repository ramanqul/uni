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

	
	
	// some changes
	@PersistenceContext(unitName="UniPU")
	EntityManager em;
	
	@Override
	public boolean createCatalog(Integer credits, SubjectDTO subjectDTO,
			FacultyDTO facultyDTO,TermDTO termDTO) {

		SubjectEntity subject=null;
		
		if(subjectDTO.getSubjectId()!=null) { 
			subject=em.find(SubjectEntity.class, subjectDTO.getSubjectId());
		} else {
			subject=new SubjectEntity();
			subject.setSubjectCode(subjectDTO.getSubjectCode());
			subject.setTitle(subjectDTO.getTitle());
			subject.setDescription(subjectDTO.getDescription());
		}
		
		
		FacultyEntity faculty=null;
		
		if(facultyDTO.getFacultyId()!=null) {
			faculty=em.find(FacultyEntity.class, facultyDTO.getFacultyId());
		} else {
			faculty=new FacultyEntity();
			faculty.setFacultyCode(facultyDTO.getFacultyCode());
			faculty.setName(facultyDTO.getName());
		}
		
		TermEntity term=null;
		
		if(termDTO.getTermId()!=null) {
			term=em.find(TermEntity.class, termDTO.getTermId());
		} else {
			term=new TermEntity();
			term.setName(termDTO.getName());
			term.setStartDate(termDTO.getStartDate());
			term.setEndDate(termDTO.getEndDate());
		}
		
		
		CatalogEntity catalog=new CatalogEntity();
		catalog.setCredits(credits);
		catalog.setFacultyEntity(faculty);
		catalog.setSubjectEntity(subject);
		catalog.setTermEntity(term);
		
		em.persist(catalog);
		
		return true;
	}

}
