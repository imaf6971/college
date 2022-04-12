package ru.tisbi.college.groups;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Year;

import org.junit.jupiter.api.Test;

public class GroupTest {
    @Test
    void testToNumberString() {
        var underTest = new Group();
        underTest.setAdmissionYear(Year.of(2019));
        underTest.setAfterSeniorSchool(false);
        underTest.setNumber((short) 2);
        assertEquals("191.2", underTest.toNumberString());
    }
}
