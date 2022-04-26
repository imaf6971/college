package ru.tisbi.college.students;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.tisbi.college.groups.Group;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(String firstName, String lastName, Optional<String> patronymic, Group group) {
        var student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setPatronymic(patronymic.orElse(null));
        student.setGroup(group);
        return studentRepository.save(student);
    }

}
