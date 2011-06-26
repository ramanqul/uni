package kz.edu.sdu.apps.uni.client;

import java.util.List;

import javax.ejb.Local;

import kz.edu.sdu.apps.uni.client.dto.SubjectDTO;

@Local
public interface ISubjectManagerLocal {
	List<SubjectDTO> getAllSubjects();
}
