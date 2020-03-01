package com.danielpm1982.springboot2meetingmng.service;
import com.danielpm1982.springboot2meetingmng.domain.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public interface MeetingManagerServiceInterface {
    Event findEventById(Long id);
    List<Event> findAllEvents();
    List<Event> findEventByName(String nameOfEvent);
    Meeting findMeetingById(Long id);
    List<Meeting> findAllMeetings();
    Meeting findMeetingByLocalDateTimeStart(LocalDateTime localDateTimeStart);
    Person findPersonById(Long id);
    List<Person> findAllPersons();
    Person findPersonByName(String nameOfPerson);
    Place findPlaceById(Long id);
    List<Place> findAllPlaces();
    Place findPlaceByStreetAndNumber(String streetOfPlace, Integer numberOfPlace);
    List<Place> findPlaceByCity(String cityOfPlace);
    List<Place> findPlaceByState(String stateOfPlace);
    List<Place> findPlaceByCountry(String countryOfPlace);
}
