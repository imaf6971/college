package ru.tisbi.college.groups;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Year;

import org.junit.jupiter.api.Test;

import ru.tisbi.college.students.Group;

public class GroupTest {
    @Test
    void testGetNumberString() {
        getNumberStringCaseA();
        getNumberStringCaseB();
        getNumberStringCaseC();
        getNumberStringCaseD();
    }

    void getNumberStringCaseA() {
        var underTest = new Group();
        underTest.setAdmissionYear(Year.of(2019));
        underTest.setAfterSeniorSchool(false);
        underTest.setNumber((short) 1);
        assertThat(underTest.getNumberString()).isEqualTo("191.1");
    }

    void getNumberStringCaseB() {
        var underTest = new Group();
        underTest.setAdmissionYear(Year.of(2019));
        underTest.setAfterSeniorSchool(false);
        underTest.setNumber((short) 2);
        assertThat(underTest.getNumberString()).isEqualTo("191.2");
    }

    void getNumberStringCaseC() {
        var underTest = new Group();
        underTest.setAdmissionYear(Year.of(2019));
        underTest.setAfterSeniorSchool(true);
        underTest.setNumber((short) 1);
        assertThat(underTest.getNumberString()).isEqualTo("192.1");
    }

    void getNumberStringCaseD() {
        var underTest = new Group();
        underTest.setAdmissionYear(Year.of(2019));
        underTest.setAfterSeniorSchool(true);
        underTest.setNumber((short) 2);
        assertThat(underTest.getNumberString()).isEqualTo("192.2");
    }
}
