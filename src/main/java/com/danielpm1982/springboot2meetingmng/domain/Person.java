package com.danielpm1982.springboot2meetingmng.domain;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

@Entity
@Table(name="PERSON")
public class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PERSON_ID")
    private Long id;
    @Column(name="PERSON_NAME")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name="PERSON_GENDER")
    private Gender gender;
    @Column(name="PERSON_POSITION")
    private String position;
    @Column(name="PERSON_COMPANY")
    private String company;
    @Column(name="PERSON_BIRTH_DATE")
    private LocalDate birthDate;
    @Column(name="PERSON_EMAIL")
    private String email;
    @Column(name="PERSON_DETAILS", length = 65535, columnDefinition = "text")
    private String details;
    @ManyToMany(mappedBy="personList", fetch=FetchType.EAGER)
    private List<Meeting> meetingList;
    public Person() {
    }
    public Person(String name, Gender gender, LocalDate birthDate, String email) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.email=email;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public List<Meeting> getMeetingList() {
        return meetingList;
    }
    public void setMeetingList(List<Meeting> meetingList) {
        this.meetingList = meetingList;
    }
    public String toString() {
        return "id: "+id+" name: "+name+" gender: "+String.valueOf(gender).toLowerCase()+" position: "+position+" company: "+company+" birthDate: "+birthDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))+" email: "+email+" details: "+details;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id);
    }
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
