package ru.tisbi.college.eventplan;

import java.time.Month;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventPlanRepository extends JpaRepository<Event, Long> {
    List<Event> findByMonth(Month month);
}
