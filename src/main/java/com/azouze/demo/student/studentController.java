package com.azouze.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.nio.file.Path;
import java.util.List;

@RestController
public class studentController {
    private final studentService studentService;
    @Autowired
    public studentController(studentService studentService) {
        this.studentService = studentService;
    }
        @GetMapping("/get")
        public List<student> getStudents() {
            return studentService.getstudent();
        }

        @PostMapping("/post")
        public void postStudent(@RequestBody student student) {
        studentService.addStudent (student);

        }

        @DeleteMapping ("/deleteall")
              public List<student> deletedtudents() {
                return studentService.Deletestudents();
    }
        @DeleteMapping ("{id}")
             public void   deletetudent( @PathVariable("id")  Long id  ) {
            studentService.Deletestudent(id);
    }


}
