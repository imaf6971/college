package ru.tisbi.college.eventplan;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventPlanRepository extends JpaRepository<Event, Long> {

}
