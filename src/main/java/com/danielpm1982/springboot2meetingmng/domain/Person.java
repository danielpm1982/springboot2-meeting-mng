package com.danielpm1982.springboot2meetingmng.domain;
import java.time.LocalDate;

public class Person {
    private Long id;
    private String name;
    private Gender gender;
    private String position;
    private String company;
    private LocalDate birthDate;
    private String email;
    private String details;
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
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", position='" + position + '\'' +
                ", company='" + company + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", details='" + details + '\'' +
                '}';
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
