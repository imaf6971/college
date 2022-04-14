package ru.tisbi.college.eventplan;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ru.tisbi.college.model.TitledEntity;

@Entity
@Table(name = "modules")
public class EventModule extends TitledEntity {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "module_id")
    private List<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        if (event.isNew()) {
            events.add(event);
        }
    }

    public List<Event> getEventsByMonth(Month month) {
        return events.stream()
                .filter(event -> event.getMonth().equals(month))
                .toList();
    }
}
