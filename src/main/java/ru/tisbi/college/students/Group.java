package ru.tisbi.college.students;

import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ru.tisbi.college.model.BaseEntity;

@Entity
@Table(name = "student_groups")
public class Group extends BaseEntity {

    @Column(name = "admission_year", nullable = false)
    private Year admissionYear;

    @Column(name = "is_after_senior", nullable = false)
    private boolean isAfterSeniorSchool;

    @Column(name = "num", nullable = false)
    private short number;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id", nullable = false)
    private List<Student> students = new ArrayList<>();

    public Year getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(Year admissionYear) {
        this.admissionYear = admissionYear;
    }

    public boolean isAfterSeniorSchool() {
        return isAfterSeniorSchool;
    }

    public void setAfterSeniorSchool(boolean isAfterSeniorSchool) {
        this.isAfterSeniorSchool = isAfterSeniorSchool;
    }

    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    public void addStudent(Student student) {
        if (student.isNew()) {
            students.add(student);
        }
    }

    public String getNumberString() {
        var stringBuilder = new StringBuilder();
        stringBuilder.append(admissionYear.format(DateTimeFormatter.ofPattern("yy")));
        stringBuilder.append(isAfterSeniorSchool ? '2' : '1');
        stringBuilder.append('.');
        stringBuilder.append(number);
        return stringBuilder.toString();
    }
}
