package ru.tisbi.college.groups;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Year;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.tisbi.college.students.Group;

public class GroupTest {
    @Test
    void testToNumberString() {
        var underTest = new Group();
        underTest.setAdmissionYear(Year.of(2019));
        underTest.setAfterSeniorSchool(false);
        underTest.setNumber((short) 2);
        assertEquals("191.2", underTest.toNumberString());
    }

    @Test
    void testStringCompare() {
        var a = "1.1";
        var b = "1.2";

        var result = a.compareTo(b);

        Assertions.assertThat(result).isLessThan(0);
    }
}
