package roseindia.tutorial.application.dao.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import roseindia.tutorial.application.domain.Student;
import roseindia.tutorial.application.form.StudentSearchForm;
import roseindia.tutorial.application.dao.StudentDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentDao")
@Transactional
public class StudentDaoImpl implements StudentDao{
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	public void addStudent(Student student){
		entityManager.persist(student);
		entityManager.flush();
	}
	
	public List<Student> findStudent(StudentSearchForm studentSearchForm){
		String sql = "FROM Student s ";
		String where = "";
		if(!studentSearchForm.getName().equals("")){
			if(where.equals("")){
				where = "WHERE s.name like '%"+studentSearchForm.getName()+"%'";
			}else{
				where = where +" and s.name like '%"+studentSearchForm.getName()+"%'";
			}
		}
		if(studentSearchForm.getCourse() > 0){
			if(where.equals("")){
				where = "WHERE s.course ="+studentSearchForm.getCourse();
			}else{
				where = where +" and s.course ="+studentSearchForm.getCourse();
			}
		}
		if(studentSearchForm.getPhoneNumber() != null){
			if(where.equals("")){
				where = "WHERE s.phoneNo ="+studentSearchForm.getPhoneNumber();
			}else{
				where = where +" and s.phoneNo ="+studentSearchForm.getPhoneNumber();
			}
		}
		if(studentSearchForm.getRollNo() != null){
			if(where.equals("")){
				where = "WHERE s.rollNo ="+studentSearchForm.getRollNo();
			}else{
				where = where +" and s.rollNo ="+studentSearchForm.getRollNo();
			}
		}
		return entityManager.createQuery(sql + where + " ORDER BY s.rollNo DESC").getResultList();
	}

	public Student findStudent(int rollNo){
		return (Student) entityManager.createQuery("FROM Student s WHERE s.rollNo="+rollNo).getResultList().get(0);
	}

	public void updateStudent(Student student){
		entityManager.merge(student);
		entityManager.flush();
	}

	public void deleteStudent(int rollNo){
		entityManager.createQuery("DELETE FROM Student s WHERE s.rollNo=" + rollNo).executeUpdate();
		entityManager.flush();
	}
}