package ru.tisbi.college.students;

import java.util.Optional;

import ru.tisbi.college.groups.Group;

public interface StudentService {

    Student createStudent(
            String firstName,
            String lastName,
            Optional<String> patronymic,
            Group group);

}
