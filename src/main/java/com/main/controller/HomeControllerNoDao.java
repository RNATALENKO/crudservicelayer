package com.main.controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.dto.StudentDto;
import com.main.service.DaoService;
import com.main.service.DaoServiceImpl;
import com.main.student.Student;

//this class will capture and send data to pages, and make calls to the service layer which calls the dao methods
//use the studentDto to send data through to the dao Impl so you don't reveal the table column names
//if you get an error like this you might be missing the model attribute it's binded to: org.apache.jasper.JasperException: An exception occurred processing [WEB-INF/views/add.jsp] at line [20]

@Controller
public class HomeControllerNoDao {
	
	@Autowired
	private DaoService DaoServiceImpl; 
	
	
	/*
	 * fetch entire database
	 */
	
	
	@GetMapping("/")
	public String table(Model model) {
		
		List<Student> studentList = DaoServiceImpl.fetchStudents(); 
		model.addAttribute("studentList", studentList);
		
		return "table";
	}
	

	/*
	 * add student 
	 */
	
	@GetMapping("/add")
	public String add(Model model, StudentDto studentDto) {
		
		model.addAttribute("studentDto", studentDto);

		return "add";
		
	}
	
	//since updateData student object gets sent to studentData, it has an Id, we can know which sql method to call
	@PostMapping("/studentData")
	public String studentData(Model model, StudentDto studentDto) {
		
		//business logic for update or for add student
		//model.addAttribute("studentDto", studentDto);
		
		System.out.println(studentDto.getName());
		System.out.println(studentDto.getSchool());
		
		 //id can be 0 and doesn't bind bec no form field with path="id", you lose the id when transferrign object from /updateStudent
		System.out.println(studentDto.getId());
		
		
		//if user has id, do an update, otherwise do an insert
		if(studentDto.getId()>0) {
			int recordsUpdated = DaoServiceImpl.updateStudent(studentDto); 
			System.out.println(recordsUpdated);
		}
		else {
			DaoServiceImpl.addStudent(studentDto);
		}
		

		return "redirect:/"; //to redirect the page
		
	}
	
	/*
	 * update student
	 * to update you need to fetch the id, and the record, then add it to the student Dto
	 * to get the id add it as a query parameter into the <a> link reference
	 * that's one way to transfer data to the next page, is through query parameters
	 * use @RequestParam("paramname") to capture the data of the query parameter
	 * warning: if this object is sent to /studentData, id will be lost since there's no field binded to modelAttribute
	 */
	
	//replace model with model attribute
	//we need an object that's not null
	
	
	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int id, Model model, StudentDto studentDto) {
		
		//fetch the student record here, and set it to the studentDto
		studentDto = DaoServiceImpl.fetchStudent(id); 
		
		//set the model attribute
		model.addAttribute("studentDto", studentDto);
		
		System.out.println("inside updateStudent" + studentDto.getId());
		
		//now we have to call the update method
		return "add"; 
		
	}
	
	/*delete a student */
	@GetMapping("/deleteStudent")
	public String deleteStudent() {
		
		return "confirm";
	}
	
	
	

}
