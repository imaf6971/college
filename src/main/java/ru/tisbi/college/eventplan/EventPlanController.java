package ru.tisbi.college.eventplan;

import static java.time.format.TextStyle.FULL_STANDALONE;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Controller
@RequiredArgsConstructor
@RequestMapping("/event-plan")
public class EventPlanController {

    private final EventPlanService eventPlanService;

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
        var month = LocalDate.now().getMonth();
        return getEventPlanByMonth(month, model);
    }

    @GetMapping(params = "month")
    public String getEventPlanByMonth(@RequestParam Month month, Model model) {
        addMonthNameToModel(month, model);
        addEventPlanToModel(month, model);
        return "event-plan";
    }

    private void addEventPlanToModel(Month month, Model model) {
        var eventPlan = eventPlanService.getEventPlanByMonth(month);
        model.addAttribute("eventPlan", eventPlan);
    }

    private void addMonthNameToModel(Month month, Model model) {
        model.addAttribute("selectedMonth", getMonthName(month));
    }

}
