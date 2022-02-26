package com.danielpm1982.springboot2meetingmng.test;
import com.danielpm1982.springboot2meetingmng.domain.*;
import com.danielpm1982.springboot2meetingmng.service.MeetingManagerServiceInterface;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class Test {
    final private MeetingManagerServiceInterface meetingManagerServiceInterface;
    public Test(MeetingManagerServiceInterface meetingManagerServiceInterface) {
        this.meetingManagerServiceInterface=meetingManagerServiceInterface;
    }
    public void test(){
        System.out.println("###########################################################");
        System.out.println("POPULATING IF DATA DOES NOT EXIST YET...");
        System.out.println("###########################################################");
        if(meetingManagerServiceInterface.findAllPersons().isEmpty()){
            Person person1 = new Person("person1", Gender.MALE, LocalDate.of(1980,1,15), "person1@person.com");
            person1.setPosition("CIO");
            person1.setCompany("danielpm1982.com");
            person1.setDetails("Will go with 3 more family companions: wife and 2 children. Wife love ice-creams, kids love pizza.");
            Person person2 = new Person("person2", Gender.MALE, LocalDate.of(1970,10,10), "person2@person.com");
            person2.setPosition("Chief Software Engineer");
            person2.setCompany("danielpm1982.com");
            person2.setDetails("Will go with 1 more family companion: 1 child. Both love chocolates.");
            Person person3 = new Person("person3", Gender.FEMALE, LocalDate.of(1985,1,10), "person3@person.com");
            person3.setPosition("Senior Software Engineer");
            person3.setCompany("danielpm1982.com");
            person3.setDetails("Will go with all his development staff team: 250 people in total.");
            meetingManagerServiceInterface.addPersonList(Arrays.asList(person1, person2, person3));
            Place place1 = new Place("streetA", 1000, "cityA", "stateA", "countryA");
            place1.setZipCode("60000000");
            place1.setDetails("Building name: Hotel A Plaza, Event Center 2nd floor. Tickets needed. Multimedia center with a 100-inch screen available. 1tbps internet available for all customers, lecturers, panel members, etc. 500 people total capacity. Allowed a max of 10% more.");
            meetingManagerServiceInterface.addPlace(place1);
            Event event1 = new Event("Strategic planning for 2020 year: Mars project", "Futurist, Interestellar, Spaceship Travel", "Social, Office Suits, Gala dresses", "danielpm1982.com", 150);
            event1.setDetails("The space has been completely reserved for the host guests. No unrelated customers allowed at this particular event.");
            meetingManagerServiceInterface.addEvent(event1);
            Meeting meeting1 = new Meeting(LocalDateTime.of(2020,7,1,18,0,0), LocalDateTime.of(2020,7,2,2,30,0));
            meeting1.setEvent(event1);
            meeting1.setPlace(place1);
            meeting1.setDetails("First day is reserved since 10:00 am. Second day until 06:00 am.");
            meeting1.setPersonList(Arrays.asList(person1, person2, person3));
            meetingManagerServiceInterface.addOrUpdateMeeting(meeting1);
        }
        System.out.println("###########################################################");
        System.out.println("COMPLETE !");
        System.out.println("###########################################################");
        System.out.println("###########################################################");
        System.out.println("GETTING AND SHOWING MEETINGS...");
        System.out.println("###########################################################");
        System.out.println("All Added Meetings:");
        meetingManagerServiceInterface.findAllMeetings().forEach(System.out::println);
        System.out.println("Finding and showing first Meeting:");
        Meeting m1 = meetingManagerServiceInterface.findAllMeetings().get(0);
        System.out.println("Id: "+m1.getId());
        System.out.println("Start: "+m1.getLocalDateTimeStart());
        System.out.println("End: "+m1.getLocalDateTimeEnd());
        System.out.println("Details: "+m1.getDetails());
        System.out.println("Event: "+m1.getEvent());
        System.out.println("Place: "+m1.getPlace());
        System.out.println("Person List:");
        m1.getPersonList().forEach(System.out::println);
        System.out.println("###########################################################");
        System.out.println("COMPLETE !");
        System.out.println("###########################################################");
        System.out.println("###########################################################");
        System.out.println("TESTING 'MAPPED_BY' RELATIONS...");
        System.out.println("###########################################################");
        System.out.println("Getting Meeting from first Event:");
        System.out.println(meetingManagerServiceInterface.findAllEvents().get(0).getMeeting());
        System.out.println("Getting Meeting List from first Place:");
        System.out.println(meetingManagerServiceInterface.findAllPlaces().get(0).getMeetingList());
        System.out.println("Getting Meeting List from first Person:");
        System.out.println(meetingManagerServiceInterface.findAllPersons().get(0).getMeetingList());
        System.out.println("###########################################################");
        System.out.println("COMPLETE !");
        System.out.println("###########################################################");
        System.out.println("###########################################################");
        System.out.println("TEST COMPLETE !");
        System.out.println("###########################################################");
    }
}

//improvised testing class to be called from the ApplicationContext using the "test" bean name.
//substitute for JUnit5 testing class later.
//see png files with the H2 DB state after this testing class runs.
