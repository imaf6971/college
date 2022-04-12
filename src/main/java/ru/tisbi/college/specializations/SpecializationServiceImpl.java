package ru.tisbi.college.specializations;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SpecializationServiceImpl implements SpecializationService {

    private final SpecializationRepository specializationRepository;

    public SpecializationServiceImpl(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    @Override
    public List<Specialization> findAllSpecializations() {
        return specializationRepository.findAll();
    }

    @Override
    public Specialization getSpecializationByCode(String code) {
        return specializationRepository.findByCode(code)
                .orElseThrow(() -> new SpecializationNotFoundException("Cant find specialization by code " + code));
    }

    @Override
    public Specialization addNewSpecialization(String code, String title) {
        var specialization = new Specialization();
        specialization.setCode(code);
        specialization.setTitle(title);
        return specializationRepository.save(specialization);
    }

}
