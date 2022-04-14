package ru.tisbi.college.eventplan;

import java.time.Month;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import ru.tisbi.utils.jpa.AbstractEntity;

@Getter
@Setter
@Entity
@Table(name = "event_plan")
public class Event extends AbstractEntity {

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "module_id", nullable = false)
    private EventModule module;

    @Column(name = "title", nullable = false, length = 1024)
    private String title;

    @Enumerated
    @Column(name = "month", nullable = false)
    private Month month;

    @Enumerated
    @Column(name = "event_type", nullable = false)
    private EventType eventType;
}
