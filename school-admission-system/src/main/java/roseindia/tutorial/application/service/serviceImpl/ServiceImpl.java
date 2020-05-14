package roseindia.tutorial.application.service.serviceImpl;

import roseindia.tutorial.application.domain.Student;
import roseindia.tutorial.application.form.StudentForm;
import roseindia.tutorial.application.form.StudentSearchForm;
import roseindia.tutorial.application.service.SchoolService;
import roseindia.tutorial.application.dao.StudentDao;
import roseindia.tutorial.application.dao.CourseDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.annotation.Resource;

import roseindia.tutorial.application.domain.Course;

import java.util.List;

import org.springframework.stereotype.Component;
import java.sql.Timestamp;

@Service("addmissionService")
public class ServiceImpl implements SchoolService {

	@Resource(name="studentDao")
	private StudentDao studentDao;

	@Resource(name = "courseDao")
	private CourseDao courseDao;

	public void addSudent(StudentForm studentForm){
		Timestamp time = new Timestamp(System.currentTimeMillis());		

		Student student = new Student();
		//student.setRollNo(studentForm.getRollNo());
		student.setName(studentForm.getName());
		student.setCourse(studentForm.getCourse());
		student.setAddress(studentForm.getAddress());
		student.setPhoneNo(studentForm.getPhoneNo());
		student.setAdmissinDate(time);
		studentDao.addStudent(student);
	}

	public List<Course> loadCourse(){
		return courseDao.loadCourse();
	}	

	public List<Student> findStudent(StudentSearchForm studentSearchForm){
		return studentDao.findStudent(studentSearchForm);
	}

	public String loadCourse(int id){
		return courseDao.loadCourse(id);
	}

	public StudentForm findStudent(int rollNo){
		Student student = studentDao.findStudent(rollNo);
		StudentForm studentForm = new StudentForm();

		studentForm.setRollNo(student.getRollNo());
		studentForm.setName(student.getName());
		studentForm.setCourse(student.getCourse());
		studentForm.setAddress(student.getAddress());
		studentForm.setPhoneNo(student.getPhoneNo());

		return studentForm;
	}

	public void updateStudent(StudentForm studentForm){
		
		Student student = new Student();
		student.setRollNo(studentForm.getRollNo());
		student.setName(studentForm.getName());
		student.setCourse(studentForm.getCourse());
		student.setAddress(studentForm.getAddress());
		student.setPhoneNo(studentForm.getPhoneNo());
		//student.setAdmissinDate(time);
		studentDao.updateStudent(student);
	}

	public void deleteStudent(int rollNo){
		studentDao.deleteStudent(rollNo);
	}

	public List<Course> findCourse(int id){
		return courseDao.findCourse(id);
	}
}