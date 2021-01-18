package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.dto.StudentDto;
import com.main.service.DaoService;
import com.main.service.DaoServiceImpl;
import com.main.student.Student;

//use the studentDto to send data through to the dao Impl so you don't reveal the table column namess

@Controller
public class HomeControllerNoDao {
	
	@Autowired
	private DaoService DaoServiceImpl; 
	
	@GetMapping("/")
	public String table(Model model) {
		
		List<Student> studentList = DaoServiceImpl.fetchStudents(); 
		model.addAttribute("studentList", studentList);
		
		return "table";
	}
	

	@GetMapping("/add")
	public String add(Model model, StudentDto studentDto) {
		
		model.addAttribute("studentDto", studentDto);

		return "add";
		
	}
	
	@PostMapping("/studentData")
	public String studentData(Model model, StudentDto studentDto) {
		
		DaoServiceImpl.addStudent(studentDto);

		return "redirect:/"; //to redirect the page
		
	}
	

}
