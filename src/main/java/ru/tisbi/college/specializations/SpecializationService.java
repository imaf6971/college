package ru.tisbi.college.specializations;

import java.util.List;

/**
 * SpecializationService
 */
public interface SpecializationService {

    List<Specialization> findAllSpecializations();

    Specialization getSpecializationByCode(String code);

    Specialization addNewSpecialization(String code, String title);
}
