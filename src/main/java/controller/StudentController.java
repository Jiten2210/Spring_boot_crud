package controller;

import exception.RecordNotFoundException;
import model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        List<StudentEntity> list = service.getAllStudents();

        return new ResponseEntity<List<StudentEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        StudentEntity entity = service.getStudentById(id);

        return new ResponseEntity<StudentEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentEntity> createOrUpdateStudent(@Valid @RequestBody StudentEntity student)
            throws RecordNotFoundException {
        StudentEntity updated = service.createOrUpdateStudent(student);
        return new ResponseEntity<StudentEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteStudentById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteStudentById(id);
        return HttpStatus.FORBIDDEN;
    }

}
