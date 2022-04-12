package ru.tisbi.college.eventplan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import ru.tisbi.utils.jpa.AbstractEntity;

@Getter
@Setter
@Entity
@Table(name = "modules")
public class EventModule extends AbstractEntity implements Comparable<EventModule> {

    @Column(name = "num", nullable = false, unique = true)
    private String number;

    @Column(name = "description", nullable = false, unique = true)
    private String description;

    @Override
    public int compareTo(EventModule o) {
        return number.compareTo(o.number);
    }

}
