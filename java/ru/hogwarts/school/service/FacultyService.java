package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final Map<Long, Faculty> facultyMap = new HashMap<>();
    private Long generatedFacultyId = 1L;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(generatedFacultyId);
        facultyMap.put(generatedFacultyId, faculty);
        generatedFacultyId++;
        return faculty;
    }

    public Faculty getFacultyById (Long id) {
        return facultyMap.get(id);
    }

    public Faculty updateFaculty(Long id, Faculty faculty) {
        facultyMap.put(id, faculty);
        return faculty;
    }

    public Faculty deleteFaculty (Long id) {
        return facultyMap.remove(id);
    }

    public Collection<Faculty> findByColor(String color) {
        return facultyMap.values().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }

    public Collection<Faculty> getAllFaculties() {
        return facultyMap.values();
    }


}
