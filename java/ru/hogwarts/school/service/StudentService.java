package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final Map<Long, Student> studentMap = new HashMap<>();
    private Long generatedStudentId = 1L;

    public Student createStudent(Student student) {
        student.setId(generatedStudentId);
        studentMap.put(generatedStudentId, student);
        generatedStudentId++;
        return student;
    }

    public Student getStudentById (Long id) {
        return studentMap.get(id);
    }

    public Student updateStudent(Long id, Student student) {
        studentMap.put(id, student);
        return student;
    }

    public Student deleteStudent(Long id) {
        return studentMap.remove(id);
    }

    public Collection<Student> findByAge(int age) {
        return studentMap.values().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }

    public Collection<Student> getAllStudents() {
        return studentMap.values();
    }

}
