package roseindia.tutorial.application.dao;

import roseindia.tutorial.application.domain.Student;
import roseindia.tutorial.application.form.StudentSearchForm;
import java.util.List;


public interface StudentDao{
	public void addStudent(Student student);
	public List<Student> findStudent(StudentSearchForm studentSearchForm);
	public Student findStudent(int rollNo);
	public void updateStudent(Student student);
	public void deleteStudent(int rollNo);
}