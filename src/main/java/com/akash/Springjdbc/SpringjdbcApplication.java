package com.akash.Springjdbc;

import com.akash.Springjdbc.model.Student;
import com.akash.Springjdbc.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringjdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringjdbcApplication.class, args);
		Student s = context.getBean(Student.class);
		s.setRoll(1);
		s.setName("PRAKASH");
		s.setMarks(83);
		StudentService ss = context.getBean(StudentService.class);
		ss.addStudent(s);
		List<Student> stud = ss.getStudent();
		System.out.println(stud);
	}

}
