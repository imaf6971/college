package ru.tisbi.college.eventplan;

import static java.util.stream.Collectors.groupingBy;

import java.time.Month;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventPlanServiceImpl implements EventPlanService {

    private final EventPlanRepository eventRepository;

    @Override
    public Map<EventModule, List<Event>> getEventPlanByMonth(Month month) {
        return getEventsByMonth(month).stream()
                .collect(
                        groupingBy(Event::getModule,
                                () -> new LinkedHashMap<>(),
                                Collectors.toList()));
    }

    private List<Event> getEventsByMonth(Month month) {
        return eventRepository.findByMonth(month);
    }
}
