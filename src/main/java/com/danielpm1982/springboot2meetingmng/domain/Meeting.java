package com.danielpm1982.springboot2meetingmng.domain;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="MEETING")
public class Meeting {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="MEETING_ID")
    private Long id;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "MEETING_PERSON",joinColumns=@JoinColumn(name="MEETING_ID_FK"),inverseJoinColumns=@JoinColumn(name="PERSON_ID_FK"))
    private List<Person> personList;
    @ManyToOne
    @JoinColumn(name="MEETING_PLACE_ID_FK")
    private Place place;
    @OneToOne
    @JoinColumn(name="MEETING_EVENT_ID_FK")
    private Event event;
    @Column(name="MEETING_START")
    private LocalDateTime localDateTimeStart;
    @Column(name="MEETING_END")
    private LocalDateTime localDateTimeEnd;
    @Column(name="MEETING_DETAILS", length = 65535, columnDefinition = "text")
    private String details;
    public Meeting() {
    }
    public Meeting(LocalDateTime localDateTimeStart, LocalDateTime localDateTimeEnd) {
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
        return "id: "+id+" personList: "+personList+" place: "+place+" event: "+event+" localDateTimeStart: "+localDateTimeStart+" localDateTimeEnd: "+localDateTimeEnd+" details: "+details;
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
