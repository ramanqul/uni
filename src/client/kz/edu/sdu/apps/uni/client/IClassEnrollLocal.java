package kz.edu.sdu.apps.uni.client;

import java.util.List;

import javax.ejb.Local;

@Local
public interface IClassEnrollLocal {

	List<ClassDTO> search(ClassSearchFilterDTO filter,int page,int size) ;
	
}
