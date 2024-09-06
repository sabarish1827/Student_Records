package com.example.student_records.Service;

import com.example.student_records.Domain.Student;
import com.example.student_records.Repository.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentsRepo studentsRepo;
    public List<Student> listAll(){
        return studentsRepo.findAll();
    }
    public void save(Student student){
        studentsRepo.save(student);
    }
    public Student get(int id){
        return studentsRepo.findById(id).orElse(null);
    }
    public void delete(int id){
        studentsRepo.deleteById(id);
    }
}
