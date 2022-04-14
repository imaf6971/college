package ru.tisbi.college.students;

public class GroupDto {

    private long specializationId;

    private int admissionYear;

    private boolean isAfterSeniorSchool;

    private short number;

    public long getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(long specializationId) {
        this.specializationId = specializationId;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }

    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    public boolean getIsAfterSeniorSchool() {
        return isAfterSeniorSchool;
    }

    public void setIsAfterSeniorSchool(boolean value) {
        isAfterSeniorSchool = value;
    }
}
