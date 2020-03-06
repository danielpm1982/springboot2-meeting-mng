package com.danielpm1982.springboot2meetingmng.service;
import com.danielpm1982.springboot2meetingmng.domain.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public interface MeetingManagerServiceInterface {
    Event addEvent(Event event);
    Event findEventById(Long id);
    List<Event> findAllEvents();
    List<Event> findEventByName(String nameOfEvent);
    Event findEventByExactName(String nameOfEvent);
    Meeting addOrUpdateMeeting(Meeting meeting);
    Meeting findMeetingById(Long id);
    List<Meeting> findAllMeetings();
    void deleteMeetingById(Long meetingId);
    Meeting findMeetingByLocalDateTimeStart(LocalDateTime localDateTimeStart);
    Person addPerson(Person person);
    List<Person> addPersonList(List<Person> personList);
    Person findPersonById(Long id);
    List<Person> findAllPersons();
    List<Person> findPersonByName(String nameOfPerson);
    Place addPlace(Place place);
    Place findPlaceById(Long id);
    List<Place> findAllPlaces();
    Place findPlaceByStreetAndNumber(String streetOfPlace, Integer numberOfPlace);
    List<Place> findPlaceByCity(String cityOfPlace);
    List<Place> findPlaceByState(String stateOfPlace);
    List<Place> findPlaceByCountry(String countryOfPlace);
}
