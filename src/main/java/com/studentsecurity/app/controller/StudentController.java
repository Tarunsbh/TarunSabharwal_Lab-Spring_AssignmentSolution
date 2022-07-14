package com.studentsecurity.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentsecurity.app.entity.Student;
import com.studentsecurity.app.services.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/list")
	public String listBooks(Model theModel) {
		System.out.println("Request received");
		List<Student> theStudents = studentService.findAll();
		theModel.addAttribute("Students", theStudents);
		return "list-Students";

	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Student theStudent = new Student();

		theModel.addAttribute("Student", theStudent);

		return "Student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id, Model theModel) {
		Student theStudent = studentService.findById(id);
		theModel.addAttribute("Student", theStudent);
		return "Student-form";
	}

	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id, @RequestParam("fname") String fname,@RequestParam("lname") String lname,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		System.out.println(id);	
		Student theStudent;
		if (id != 0) {
			theStudent = studentService.findById(id);
			theStudent.setFname(fname);
			theStudent.setLname(lname);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);
		} else {
			theStudent = new Student(fname, lname, department, country);
		}
		studentService.save(theStudent);
		return "redirect:/student/list";


	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		System.out.println(theId);

		studentService.deleteById(theId);
		return "redirect:/student/list";

	}
	
	@RequestMapping("/403")
	public String denied() {
		
		return "403";

	}
	
}
