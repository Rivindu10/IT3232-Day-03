package lk.ac.vau.fas.ict.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lk.ac.vau.fas.ict.controller.model.Student;
@RestController
@RequestMapping("/app")
public class AppController {
	//create some student object
	
	Student Rivindu = new Student("2020ICT93","R.P.Jayathunga",25,"ICT",3.38);
	Student Tharushi = new Student("2020ICT112","M.M.T.N.Munasinghe",25,"ICT",2.85);
	Student Nera = new Student("2020ICT97","N.P.Ponnamperuma",25,"ICT",3.47);
	
	List<Student> Students = new ArrayList<Student>();
	public AppController() {
		Students.add(Rivindu);
		Students.add(Tharushi);
		Students.add(Nera);
	}
	@GetMapping("/msg")
	public String myMessage() {
		return "Hello SpirngBoot";
	}
	@GetMapping("/name")
	public String myName() {
		return "My name is SpirngBoot";
	}
	@GetMapping("/age/{ag}")
	public String MyAge(@PathVariable("ag") int age) {
		return "MY age is "+age;
	}
	@GetMapping("/Student")
	public Student getStudent() {
		return Rivindu;
	}
	//get multiple students 
	@GetMapping("/Students")
	public List<Student> getStudents() {
		return Students;
	}
	
	//find students using regNo
	@GetMapping("/Student/{id}")
	public Student findRegNo(@PathVariable("id") String RegNo) {
		for(Student student : Students) {
			if(student.getRegNo().equals(RegNo)) {
				return student;
			}
		}
		return null;
	}
	//find the students whose age between 20-23
	//Sort the student by gpa
	
	
}
