package kz.edu.sdu.apps.uni.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import kz.edu.sdu.apps.uni.client.ICourseManagerLocal;
import kz.edu.sdu.apps.uni.client.ICourseManagerRemote;
import kz.edu.sdu.apps.uni.client.dto.CourseDTO;
import kz.edu.sdu.apps.uni.ejb.db.CourseEntity;

@Stateless
public class CourseManagerBean implements ICourseManagerLocal,ICourseManagerRemote{
	@PersistenceContext(unitName="UniPU")
	EntityManager em;
	
	@Override
	public boolean createCourse(String name) {
		CourseEntity c=new CourseEntity();
		c.setName(name);
		try {
			em.persist(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<CourseDTO> getCourses(String name) {
		List<CourseDTO> result=new ArrayList<CourseDTO>();
		
		List<CourseEntity> result2=em.createQuery("Select c From CourseEntity c").getResultList();
		for(CourseEntity c2:result2) {
			CourseDTO c=new CourseDTO();
			c.setCourseId(c2.getCourseId());
			c.setName(c2.getName());
			result.add(c);
		}
		return result;
	}
}
