package com.danielpm1982.springboot2meetingmng.domain;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="PLACE")
public class Place {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PLACE_ID")
    private Long id;
    @Column(name="PLACE_STREET")
    private String street;
    @Column(name="PLACE_NUMBER")
    private Integer number;
    @Column(name="PLACE_ZIP_CODE")
    private String zipCode;
    @Column(name="PLACE_CITY")
    private String city;
    @Column(name="PLACE_STATE")
    private String state;
    @Column(name="PLACE_COUNTRY")
    private String country;
    @Column(name="PLACE_DETAILS", length = 65535, columnDefinition = "text")
    private String details;
    @OneToMany(mappedBy="place", fetch=FetchType.EAGER)
    private List<Meeting> meetingList;
    public Place() {
    }
    public Place(String street, Integer number, String city, String state, String country) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.country = country;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
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
    @Override
    public String toString() {
        return "id: "+id+" street: "+street+" number: "+number+" zipCode: "+zipCode+" city: "+city+" state: "+state+" country: "+country+" details: "+details;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return id.equals(place.id);
    }
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
