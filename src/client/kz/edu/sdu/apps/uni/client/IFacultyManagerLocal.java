package kz.edu.sdu.apps.uni.client;

import java.util.List;

import javax.ejb.Local;

import kz.edu.sdu.apps.uni.client.dto.FacultyDTO;

@Local
public interface IFacultyManagerLocal {
	List<FacultyDTO> getAllFaculties();
}
