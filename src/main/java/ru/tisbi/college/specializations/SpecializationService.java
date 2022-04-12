package ru.tisbi.college.specializations;

import java.util.List;

/**
 * SpecializationService
 */
public interface SpecializationService {

    Specialization getSpecializationById(Long id);

    List<Specialization> findAllSpecializations();

    Specialization getSpecializationByCode(String code);

    Specialization addNewSpecialization(String code, String title);
}
