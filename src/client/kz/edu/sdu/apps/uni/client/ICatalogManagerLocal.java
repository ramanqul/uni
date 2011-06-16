package kz.edu.sdu.apps.uni.client;

import javax.ejb.Local;

import kz.edu.sdu.apps.uni.client.dto.FacultyDTO;
import kz.edu.sdu.apps.uni.client.dto.SubjectDTO;

@Local
public interface ICatalogManagerLocal {

	boolean createCatalog(Integer credits,SubjectDTO subjectDTO,FacultyDTO facultyDTO);
	
}
