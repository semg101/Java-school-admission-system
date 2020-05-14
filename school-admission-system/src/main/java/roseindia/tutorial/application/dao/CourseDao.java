package roseindia.tutorial.application.dao;

import roseindia.tutorial.application.domain.Course;
import java.util.List;

public interface CourseDao{
	public List<Course> loadCourse();
	public String loadCourse(int id);
	public List<Course> findCourse(int id);
}