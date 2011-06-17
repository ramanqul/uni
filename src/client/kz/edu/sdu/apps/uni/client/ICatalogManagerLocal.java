package kz.edu.sdu.apps.uni.client;

import javax.ejb.Local;

import kz.edu.sdu.apps.uni.client.dto.FacultyDTO;
import kz.edu.sdu.apps.uni.client.dto.SubjectDTO;
import kz.edu.sdu.apps.uni.client.dto.TermDTO;

@Local
public interface ICatalogManagerLocal {

	boolean createCatalog(Integer credits,SubjectDTO subjectDTO,FacultyDTO facultyDTO,TermDTO term);
	
}
