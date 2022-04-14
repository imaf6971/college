package ru.tisbi.college.eventplan;

import java.time.Month;
import java.util.List;
import java.util.Map;

public interface EventPlanService {

    Map<EventModule, List<Event>> getEventPlanByMonth(Month month);

}
