package ru.tisbi.college.eventplan;

import java.time.Month;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import ru.tisbi.college.model.NamedEntity;

@Entity
@Table(name = "event_plan")
public class Event extends NamedEntity {

    @Enumerated
    @Column(name = "month", nullable = false)
    private Month month;

    @Enumerated
    @Column(name = "event_type", nullable = false)
    private EventType eventType;

    public Event() {
    }

    public Event(Month month) {
        this.month = month;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

}
