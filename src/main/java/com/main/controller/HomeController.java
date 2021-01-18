package com.main.controller;

import java.io.Console;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.main.dao.Dao;
import com.main.dao.DaoImpl;
import com.main.dto.StudentDto;
import com.main.student.Student;

// to redirect page, write return "redirect: {url map of page} https://www.tutorialspoint.com/spring/spring_page_redirection_example.html
//we shouldn't call the dao in a controller, instead call a service layer object, which calls the dao, https://www.youtube.com/watch?v=G39Z3J_6lKY
//@Post mapping, can be used instead of @RequestMapping

/*
@Controller
public class HomeController {
	
	@Autowired
	Dao daoImpl; 
	
	@GetMapping("/")
	public String table(Model model) {
		
		List<Student> studentList = daoImpl.fetchStudents(); 
		model.addAttribute("studentList", studentList);
		
		return "table";
	}
	
	//adding to the database
	
	@RequestMapping("/add")
	public String add(Model model) {
		//add the sudent dto into the model
		model.addAttribute("StudentDto", new StudentDto());
		return "add";
		
	}
	
	
	//spring will inject the data into the method parameter, can't call from Model model, since it's a new object and not the same as above
	//spring will bind the data from the form to studentDto
	@RequestMapping("/studentData")
	public String studentData(StudentDto studentDto, Model model, BindingResult result) {
		
		//execute the update
		int recordAdded = daoImpl.addStudent(studentDto);

		return "redirect:/"; //to redirect the page
		
	}
}

*/
