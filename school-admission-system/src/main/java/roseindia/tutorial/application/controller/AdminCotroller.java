package roseindia.tutorial.application.controller;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import roseindia.tutorial.application.form.StudentForm;
import roseindia.tutorial.application.form.StudentSearchForm;
import roseindia.tutorial.application.service.SchoolService;
import roseindia.tutorial.application.domain.Student;

@SuppressWarnings("unchecked")
@Controller
public class AdminCotroller {

	@Resource(name="addmissionService")
	private SchoolService service;


	@RequestMapping(value = "/admin/load-home-page")
	public String loadHomePage(Map model){
		return "admin/index";
	}

	@RequestMapping(value = "/admin/load-student-form")
	public String loadStudentForm(Map model, StudentForm studentForm, HttpServletRequest request){				
		if(request.getParameter("id") != null){
			int rollNo = Integer.parseInt(request.getParameter("id"));
			studentForm = service.findStudent(rollNo);
		}
		if(request.getParameter("courseId") != null){
			int courseId = Integer.parseInt(request.getParameter("courseId"));
			studentForm.setCourse(courseId);
		}
		model.put("studentForm", studentForm);
		model.put("courseList", service.loadCourse());		
		return "admin/student-form";
	}
	
	@RequestMapping(value = "/admin/add-update-student")
	public String addUpdateStudent(Map model, StudentForm studentForm){
		model.put("studentForm", studentForm);
		model.put("courseList", service.loadCourse());
		if(studentForm.getRollNo() != null){
			System.out.println("Updating Records to the Database");
			service.updateStudent(studentForm);
			return "forward:/admin/search";
		}else{		
			System.out.println("Saving Records to the Database");
			service.addSudent(studentForm);
			return "forward:/admin/load-home-page";
		}
	}

	@RequestMapping(value = "/admin/search-student")
	public String searchStudent(Map model, StudentSearchForm studentSearchForm){
		model.put("courseList", service.loadCourse());
		model.put("studentSearchForm", studentSearchForm);
		return "admin/student-search-form";
	}

	@RequestMapping(value = "/admin/search")
	public String search(Map model, StudentSearchForm studentSearchForm){
		model.put("courseList", service.loadCourse());
		model.put("studentSearchForm", studentSearchForm);
		model.put("studentList", service.findStudent(studentSearchForm));
		return "admin/student-search-form";
	}
	
	@RequestMapping(value = "/admin/delete-student")
	public String delete(Map model, StudentSearchForm studentSearchForm, HttpServletRequest request){
		model.put("studentSearchForm", studentSearchForm);
		int rollNo = 0;
		if(request.getParameter("id") != null){
			rollNo = Integer.parseInt(request.getParameter("id"));			
			service.deleteStudent(rollNo);
		}
		return "forward:/admin/search-student";
	}

}