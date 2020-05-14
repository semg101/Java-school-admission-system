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
public class UserController{
	
	@Resource(name="addmissionService")
	private SchoolService service;


	@RequestMapping(value = "/load-home-page")
	public String loadHomePage(Map model){
		return "user/index";
	}

	@RequestMapping(value = "/view-cources")
	public String loadCources(Map model, HttpServletRequest request){
		int id = 0;
		if(request.getParameter("id") != null){
			id = Integer.parseInt(request.getParameter("id"));
			model.put("courseList", service.findCourse(id));
			return "user/view-courses";
		}
		model.put("courseList", service.loadCourse());
		return "user/view-courses";
	}
}