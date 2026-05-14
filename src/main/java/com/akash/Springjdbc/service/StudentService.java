package com.akash.Springjdbc.service;

import com.akash.Springjdbc.Repositry.StudentRepo;
import com.akash.Springjdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }

    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student s) {
      repo.save(s);
    }

    public List<Student> getStudent() {

       return repo.findAll();

    }
}
