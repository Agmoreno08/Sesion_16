package interfaces;

import models.Student;
import java.util.List;

public interface IStudent {
    List<Student> findAll();
    Student findByEmail(String email);
    void save(Student student);
    void update(Student student);
    void delete(Student student);
}

