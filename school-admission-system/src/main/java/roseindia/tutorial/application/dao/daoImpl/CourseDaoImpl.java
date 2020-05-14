package roseindia.tutorial.application.dao.daoImpl;

import roseindia.tutorial.application.domain.Course;
import roseindia.tutorial.application.dao.CourseDao;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Service("courseDao")
@Transactional
public class CourseDaoImpl implements CourseDao{

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	public List<Course> loadCourse(){
		Query query = entityManager.createQuery("FROM Course c order by c.name ASC");
		return query.getResultList();
	}

	public String loadCourse(int id){
		List<Course> courseList = (List<Course>) entityManager.createQuery("FROM Course c WHERE c.id=" + id).getResultList();
		for(Course c : courseList){
			return (String) c.getName();
		}
		return "";
	}

	public List<Course> findCourse(int id){
		return entityManager.createQuery("FROM Course c WHERE c.id=" + id).getResultList();
	}
}