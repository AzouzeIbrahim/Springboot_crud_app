package com.azouze.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
public class studentService {
    private final studentRepository studentRepository;
    @Autowired
    public studentService(studentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<student> getstudent() {
        return studentRepository.findAll();

    } public List<student> Deletestudents() {
         studentRepository.deleteAll();
         return null ;

    }

    public void addStudent(student student) {
             studentRepository.save(student);
    }

    public void Deletestudent( Long id ) {
        studentRepository.deleteById( id);
    };
    public void updateStudent(Long id, student student) {
        student existingStudent = studentRepository.findById(id) .orElseThrow(() -> new IllegalStateException("student with id " + id + " does not exist."));
        if (studentRepository.findByEmail(student.getEmail()).isPresent() && !existingStudent.getEmail().equals(student.getEmail()))
        { throw new IllegalStateException("Email already in use."); }
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setBirthday(student.getBirthday());
        studentRepository.save(existingStudent); }
}
