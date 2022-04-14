package ru.tisbi.college.eventplan;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/event-plan")
public class EventPlanController {

    private final EventPlanService eventPlanService;

    @GetMapping
    public String getEventPlan(Model model) {
        var month = LocalDate.now().getMonth();
        return getEventPlanByMonth(month, model);
    }

    @GetMapping(params = "month")
    public String getEventPlanByMonth(@RequestParam Month month, Model model) {
        var eventPlan = eventPlanService.getEventPlanByMonth(month);
        model.addAttribute("eventPlan", eventPlan);
        return "event-plan";
    }

}
