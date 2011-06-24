package kz.edu.sdu.apps.uni.client;

import java.util.List;

import javax.ejb.Local;

import kz.edu.sdu.apps.uni.client.dto.ClassDTO;
import kz.edu.sdu.apps.uni.client.dto.ClassSearchFilterDTO;

@Local
public interface IClassEnrollLocal {

	List<ClassDTO> search(ClassSearchFilterDTO filter,int page,int size) ;
	
}
