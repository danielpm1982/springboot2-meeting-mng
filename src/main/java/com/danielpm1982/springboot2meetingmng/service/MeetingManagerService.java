package com.danielpm1982.springboot2meetingmng.service;
import com.danielpm1982.springboot2meetingmng.domain.Event;
import com.danielpm1982.springboot2meetingmng.domain.Meeting;
import com.danielpm1982.springboot2meetingmng.domain.Person;
import com.danielpm1982.springboot2meetingmng.domain.Place;
import com.danielpm1982.springboot2meetingmng.repository.EventRepositoryInterface;
import com.danielpm1982.springboot2meetingmng.repository.MeetingRepositoryInterface;
import com.danielpm1982.springboot2meetingmng.repository.PersonRepositoryInterface;
import com.danielpm1982.springboot2meetingmng.repository.PlaceRepositoryInterface;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MeetingManagerService implements MeetingManagerServiceInterface{
    private EventRepositoryInterface eventRepository;
    private MeetingRepositoryInterface meetingRepository;
    private PersonRepositoryInterface personRepository;
    private PlaceRepositoryInterface placeRepository;
    public MeetingManagerService(EventRepositoryInterface eventRepository, MeetingRepositoryInterface meetingRepository, PersonRepositoryInterface personRepository, PlaceRepositoryInterface placeRepository) {
        this.eventRepository = eventRepository;
        this.meetingRepository = meetingRepository;
        this.personRepository = personRepository;
        this.placeRepository = placeRepository;
    }
    @Override
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }
    @Override
    public Event findEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }
    @Override
    public List<Event> findAllEvents() {
        List<Event> resultList = new ArrayList<>();
        eventRepository.findAll().forEach(resultList::add);
        return resultList;
    }
    @Override
    public List<Event> findEventByName(String nameOfEvent) {
        return eventRepository.findByName(nameOfEvent);
    }
    @Override
    public Event findEventByExactName(String nameOfEvent) {
        return eventRepository.findByExactName(nameOfEvent);
    }
    @Override
    public Meeting addOrUpdateMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }
    @Override
    public Meeting findMeetingById(Long id) {
        return meetingRepository.findById(id).orElse(null);
    }
    @Override
    public List<Meeting> findAllMeetings() {
        List<Meeting> resultList = new ArrayList<>();
        meetingRepository.findAll().forEach(resultList::add);
        return resultList;
    }
    @Override
    public Meeting findMeetingByLocalDateTimeStart(LocalDateTime localDateTimeStart) {
        return meetingRepository.findByLocalDateTimeStart(localDateTimeStart);
    }
    @Override
    public void deleteMeetingById(Long meetingId) {
        meetingRepository.deleteById(meetingId);
    }
    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }
    @Override
    public List<Person> addPersonList(List<Person> personList) {
        List<Person> result = new ArrayList<>();
        personRepository.saveAll(personList).forEach(result::add);
        return result;
    }
    @Override
    public Person findPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }
    @Override
    public List<Person> findAllPersons() {
        List<Person> resultList = new ArrayList<>();
        personRepository.findAll().forEach(resultList::add);
        return resultList;
    }
    @Override
    public List<Person> findPersonByName(String nameOfPerson) {
        return personRepository.findByName(nameOfPerson);
    }
    @Override
    public Place findPlaceById(Long id) {
        return placeRepository.findById(id).orElse(null);
    }
    @Override
    public Place addPlace(Place place) {
        return placeRepository.save(place);
    }
    @Override
    public List<Place> findAllPlaces() {
        List<Place> resultList = new ArrayList<>();
        placeRepository.findAll().forEach(resultList::add);
        return resultList;
    }
    @Override
    public Place findPlaceByStreetAndNumber(String streetOfPlace, Integer numberOfPlace) {
        return placeRepository.findByStreetAndNumber(streetOfPlace, numberOfPlace);
    }
    @Override
    public List<Place> findPlaceByCity(String cityOfPlace) {
        return placeRepository.findByCity(cityOfPlace);
    }
    @Override
    public List<Place> findPlaceByState(String stateOfPlace) {
        return placeRepository.findByState(stateOfPlace);
    }
    @Override
    public List<Place> findPlaceByCountry(String countryOfPlace) {
        return placeRepository.findByCountry(countryOfPlace);
    }
}
