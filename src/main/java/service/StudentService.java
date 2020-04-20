package service;

import exception.RecordNotFoundException;
import model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public List<StudentEntity> getAllStudents() {
        List<StudentEntity> studentList = repository.findAll();

        if (studentList.size() > 0) {
            return studentList;
        } else {
            return new ArrayList<StudentEntity>();
        }
    }

    public StudentEntity getStudentById(Long id) throws RecordNotFoundException {
        Optional<StudentEntity> student = repository.findById(id);

        if (student.isPresent()) {
            return student.get();
        } else {
            throw new RecordNotFoundException("No student record exist for given id", id);
        }
    }

    public StudentEntity createOrUpdateStudent(StudentEntity entity) throws RecordNotFoundException {

        if (entity.getId() != null) {
            Optional<StudentEntity> student = repository.findById(entity.getId());

            if (student.isPresent()) {
                StudentEntity newEntity = student.get();
                newEntity.setEmailId(entity.getEmailId());
                newEntity.setFirstName(entity.getFirstName());
                newEntity.setLastName(entity.getLastName());
                newEntity.setBranch(entity.getBranch());

                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                entity = repository.save(entity);

                return entity;
            }
        } else {
            entity = repository.save(entity);
            return entity;
        }
    }

    public void deleteStudentById(Long id) throws RecordNotFoundException {
        Optional<StudentEntity> student = repository.findById(id);

        if (student.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No student record exist for given id", id);
        }
    }
}

