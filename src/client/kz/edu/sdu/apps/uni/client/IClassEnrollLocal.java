package kz.edu.sdu.apps.uni.client;

import java.util.List;

import javax.ejb.Local;

import kz.edu.sdu.apps.uni.client.dto.ClassDTO;
import kz.edu.sdu.apps.uni.client.dto.ClassSearchFilterDTO;
import kz.edu.sdu.apps.uni.client.exceptions.ClassNotExistsException;

@Local
public interface IClassEnrollLocal {
	List<ClassDTO> search(ClassSearchFilterDTO filter,int page,int size) ;	
	ClassDTO getClassById(long id) throws ClassNotExistsException;
}
