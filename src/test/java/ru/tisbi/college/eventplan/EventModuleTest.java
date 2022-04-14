package ru.tisbi.college.eventplan;

import static java.time.Month.JULY;
import static java.time.Month.SEPTEMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EventModuleTest {

    private EventModule underTest;

    @BeforeEach
    void arrangeSubject() {
        underTest = new EventModule();
    }

    @Test
    void testAddEvent() {
        // Arrange
        var event = new Event();

        // Act
        underTest.addEvent(event);

        // Assert
        assertThat(underTest.getEvents()).contains(event);
    }

    @Test
    void testGetEventsByMonth() {
        // Arrange
        var septemberEvent0 = new Event(SEPTEMBER);
        var septemberEvent1 = new Event(SEPTEMBER);
        var julyEvent = new Event(JULY);
        underTest.addEvent(septemberEvent0);
        underTest.addEvent(septemberEvent1);
        underTest.addEvent(julyEvent);

        // Act
        var septemberEvents = underTest.getEventsByMonth(SEPTEMBER);

        // Assert
        assertThat(septemberEvents).contains(septemberEvent0, septemberEvent1);
        assertThat(septemberEvents).doesNotContain(julyEvent);
        assertThat(septemberEvents).allMatch(event -> event.getMonth().equals(SEPTEMBER));
    }

    @Test
    void testGetEvents() {
        // Assert
        assertThrows(UnsupportedOperationException.class, () -> {
            underTest.getEvents().add(new Event());
        });
    }
}
