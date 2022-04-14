package ru.tisbi.college.eventplan;

import static java.time.format.TextStyle.FULL_STANDALONE;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/event-plan")
public class EventPlanController {

    private final EventModuleRepository moduleRepository;

    public EventPlanController(EventModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @ModelAttribute("months")
    public Map<Month, String> monthDropdown() {
        return stream(Month.values())
                .collect(toMap(month -> month, this::getMonthName));
    }

    private String getMonthName(Month month) {
        return month.getDisplayName(FULL_STANDALONE, new Locale("ru"));
    }

    @GetMapping
    public String getEventPlan(Model model) {
        return "forward:/event-plan?month=" + currentMonth();
    }

    private Month currentMonth() {
        return LocalDate.now().getMonth();
    }

    @GetMapping(params = "month")
    public String getEventPlanByMonth(@RequestParam Month month, Model model) {
        addMonthNameToModel(month, model);
        addEventPlanToModel(month, model);
        return "event-plan";
    }

    private void addMonthNameToModel(Month month, Model model) {
        model.addAttribute("selectedMonth", getMonthName(month));
    }

    private void addEventPlanToModel(Month month, Model model) {
        model.addAttribute("eventPlan", getEventPlanForMonth(month));
    }

    private Map<EventModule, List<Event>> getEventPlanForMonth(Month month) {
        return moduleRepository.findAll().stream()
                .collect(toMap(module -> module, module -> module.getEventsByMonth(month)));
    }

}
