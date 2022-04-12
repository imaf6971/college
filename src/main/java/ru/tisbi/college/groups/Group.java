package ru.tisbi.college.groups;

import java.time.Year;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import ru.tisbi.college.specializations.Specialization;
import ru.tisbi.utils.jpa.AbstractEntity;

@Getter
@Setter
@Entity
@Table(name = "student_groups")
public class Group extends AbstractEntity {
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "specialization_id", nullable = false)
    private Specialization specialization;

    @Column(name = "admission_year", nullable = false)
    private Year admissionYear;

    @Column(name = "is_after_senior", nullable = false)
    private boolean isAfterSeniorSchool;

    @Column(name = "num", nullable = false)
    private short number;

    public String toNumberString() {
        var stringBuilder = new StringBuilder();
        stringBuilder.append(admissionYear.format(DateTimeFormatter.ofPattern("yy")));
        stringBuilder.append(isAfterSeniorSchool ? '2' : '1');
        stringBuilder.append('.');
        stringBuilder.append(number);
        return stringBuilder.toString();
    }
}
