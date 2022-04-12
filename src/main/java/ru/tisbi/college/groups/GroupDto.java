package ru.tisbi.college.groups;

import lombok.Data;

@Data
public class GroupDto {

    private long specializationId;

    private int admissionYear;

    private boolean isAfterSeniorSchool;

    private short number;

    public boolean getIsAfterSeniorSchool() {
        return isAfterSeniorSchool;
    }
}
