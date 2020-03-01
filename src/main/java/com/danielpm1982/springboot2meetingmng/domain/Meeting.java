package com.danielpm1982.springboot2meetingmng.domain;
import java.time.LocalDateTime;
import java.util.List;

public class Meeting {
    private Long id;
    private List<Person> personList;
    private Place place;
    private Event event;
    private LocalDateTime localDateTimeStart;
    private LocalDateTime localDateTimeEnd;
    private String details;
    public Meeting() {
    }
    public Meeting(List<Person> personList, Place place, Event event, LocalDateTime localDateTimeStart, LocalDateTime localDateTimeEnd) {
        this.personList = personList;
        this.place = place;
        this.event = event;
        this.localDateTimeStart = localDateTimeStart;
        this.localDateTimeEnd = localDateTimeEnd;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<Person> getPersonList() {
        return personList;
    }
    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
    public Place getPlace() {
        return place;
    }
    public void setPlace(Place place) {
        this.place = place;
    }
    public Event getEvent() {
        return event;
    }
    public void setEvent(Event event) {
        this.event = event;
    }
    public LocalDateTime getLocalDateTimeStart() {
        return localDateTimeStart;
    }
    public void setLocalDateTimeStart(LocalDateTime localDateTimeStart) {
        this.localDateTimeStart = localDateTimeStart;
    }
    public LocalDateTime getLocalDateTimeEnd() {
        return localDateTimeEnd;
    }
    public void setLocalDateTimeEnd(LocalDateTime localDateTimeEnd) {
        this.localDateTimeEnd = localDateTimeEnd;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", personList=" + personList +
                ", place=" + place +
                ", event=" + event +
                ", localDateTimeStart=" + localDateTimeStart +
                ", localDateTimeEnd=" + localDateTimeEnd +
                ", details='" + details + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return id.equals(meeting.id);
    }
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
