package ru.tisbi.college.specializations;

public class SpecializationNotFoundException extends RuntimeException {

    public SpecializationNotFoundException() {
    }

    public SpecializationNotFoundException(String arg0) {
        super(arg0);
    }

    public SpecializationNotFoundException(Throwable arg0) {
        super(arg0);
    }

    public SpecializationNotFoundException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

}
