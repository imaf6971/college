package ru.tisbi.college.specializations;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
    Optional<Specialization> findByCode(String code);
}
