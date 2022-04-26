package ru.tisbi.college;

import java.time.LocalDate;
import java.time.Year;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ru.tisbi.college.eventplan.Event;
import ru.tisbi.college.eventplan.EventModule;
import ru.tisbi.college.eventplan.EventModuleRepository;
import ru.tisbi.college.eventplan.EventPlanRepository;
import ru.tisbi.college.eventplan.EventType;

@SpringBootApplication
public class CollegeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeBackendApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(EventPlanRepository eRepository, EventModuleRepository eModule) {
        return (args) -> {
            var m1 = new EventModule();
            m1.setNumber("1.1");
            m1.setDescription("Модуль А");
            eModule.save(m1);

            var m2 = new EventModule();
            m2.setNumber("2");
            m2.setDescription("Модуль Б");
            eModule.save(m2);

            var e1 = new Event();
            e1.setEventType(EventType.LOCAL);
            e1.setModule(m1);
            e1.setMonth(LocalDate.now().getMonth());
            e1.setTitle("Мероприятие А");
            eRepository.save(e1);

            var e2 = new Event();
            e2.setEventType(EventType.REPUBLICAN);
            e2.setModule(m1);
            e2.setMonth(LocalDate.now().getMonth());
            e2.setTitle("Мероприятие Б");
            eRepository.save(e2);


            var e3 = new Event();
            e3.setEventType(EventType.COUNTRYWIDE);
            e3.setModule(m2);
            e3.setMonth(LocalDate.now().getMonth());
            e3.setTitle("Мероприятие Б");
            eRepository.save(e3);
        };
    }
}
