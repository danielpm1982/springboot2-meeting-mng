package com.danielpm1982.springboot2meetingmng.controller;
import com.danielpm1982.springboot2meetingmng.domain.*;
import com.danielpm1982.springboot2meetingmng.modelAttribute.MeetingModelAttribute;
import com.danielpm1982.springboot2meetingmng.service.MeetingManagerServiceInterface;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Controller
public class MeetingManagerController {
    //constructor injection of the MeetingManagerServiceInterface (whose impl class uses all Repository interfaces, automatically implemented by Spring Data JPA
    private MeetingManagerServiceInterface meetingManagerServiceInterface;
    public MeetingManagerController(MeetingManagerServiceInterface meetingManagerServiceInterface) {
        this.meetingManagerServiceInterface = meetingManagerServiceInterface;
    }
    //returns a meeting list to the view, with current DB data, using the MeetingManagerServiceInterface findAllMeetings() method and corresponding Repository
    @GetMapping("/meetings")
    public String showMeetings(Model model){
        List<Meeting> meetingList = meetingManagerServiceInterface.findAllMeetings();
        model.addAttribute("meetings", meetingList);
        return "meetings";
    }
    //statically gets, and sets to the Model, a new MeetingModelAttribute instance, initialized with blank initial values. Besides setting the ModelAttribute to be filled, also updates the available Select values for the view
    @GetMapping("/add-meeting-form")
    public String addMeetingShowForm(Model model){
        MeetingModelAttribute meetingModelAttribute = MeetingModelAttribute.getBlankMeetingModelAttribute();
        model.addAttribute("meetingModelAttribute", meetingModelAttribute);
        updateSelectOptionsForAvailablePersonsEventsAndPlaces(model);
        return "add-meeting-form";
    }
    //receives the filled ModelAttribute from the view and gets a new Meeting object with the values set from it. Adds the Meeting object data to the DB, through the MeetingManagerServiceInterface addOrUpdateMeeting() method and corresponding Repository
    @PostMapping("/add-meeting")
    public String addMeeting(@ModelAttribute("meetingModelAttribute") MeetingModelAttribute meetingModelAttribute){
        Meeting meeting = getMeetingObjectFromMeetingModelAttribute(meetingModelAttribute);
        meetingManagerServiceInterface.addOrUpdateMeeting(meeting);
        return "redirect:/meetings";
    }
    //receives a request from the meetings page update button, with a meetingId as a request parameter; finds the correponding registered meetingToUpdate instance for that meetingId, using the MeetingManagerServiceInterface findMeetingById() method and corresponding Repository; statically gets, and sets to the Model, a MeetingModelAttribute instance, initialized with values from that existent meetingToUpdate object (not blank initial values). Besides setting the ModelAttribute to be filled, also updates the available Select values for the view
    @GetMapping("/update-meeting-form")
    public String updateMeetingShowForm(@RequestParam("meetingId") Long meetingId, Model model){
        Meeting meetingToUpdate = meetingManagerServiceInterface.findMeetingById(meetingId);
        MeetingModelAttribute meetingModelAttribute = MeetingModelAttribute.getMeetingModelAttributeFromMeetingObject(meetingToUpdate);
        model.addAttribute("meetingModelAttribute", meetingModelAttribute);
        updateSelectOptionsForAvailablePersonsEventsAndPlaces(model);
        return "update-meeting-form";
    }
    //receives the filled ModelAttribute from the view and gets a new Meeting object with the values set from it. Updates the Meeting object data to the DB, through the MeetingManagerServiceInterface addOrUpdateMeeting() method and corresponding Repository
    @PostMapping("/update-meeting")
    public String updateMeeting(@ModelAttribute("meetingModelAttribute") MeetingModelAttribute meetingModelAttribute){
        Meeting meeting = getMeetingObjectFromMeetingModelAttribute(meetingModelAttribute);
        meetingManagerServiceInterface.addOrUpdateMeeting(meeting);
        return "redirect:/meetings";
    }
    //receives a request from the meetings page delete button, with a meetingId as a request parameter, and deletes the corresponding instance and DB data using the MeetingManagerServiceInterface deleteMeetingById() method and corresponding Repository
    @GetMapping("delete-meeting")
    public String deleteMeeting(@RequestParam("meetingId") Long meetingId){
        meetingManagerServiceInterface.deleteMeetingById(meetingId);
        return "redirect:/meetings";
    }
    //receives a request from the meetings page unique meeting link, with a meetingId as a request parameter; finds the correponding registered meetingToShow instance for that meetingId, using the MeetingManagerServiceInterface findMeetingById() method and corresponding Repository; sends the instance data to the view, as the modelAttribute, for showing only that unique meeting data (not a list of meetings)
    @GetMapping("/show-meeting")
    public String showMeeting(@RequestParam("meetingId") Long meetingId, Model model) {
        Meeting meetingToShow = meetingManagerServiceInterface.findMeetingById(meetingId);
        model.addAttribute("meetingToShow", meetingToShow);
        model.addAttribute("localDateTimeStartFormatted", meetingToShow.getLocalDateTimeStart().atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
        model.addAttribute("localDateTimeEndFormatted", meetingToShow.getLocalDateTimeEnd().atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
        return "show-meeting";
    }
    //utilitary internal method, reused by the addMeeting and updateMeeting methods (refactoring for avoiding code duplicity)
    private Meeting getMeetingObjectFromMeetingModelAttribute(MeetingModelAttribute meetingModelAttribute){
        Meeting meeting = new Meeting(LocalDateTime.parse(meetingModelAttribute.getLocalDateStart()+"T"+meetingModelAttribute.getLocalTimeStart()), LocalDateTime.parse(meetingModelAttribute.getLocalDateEnd()+"T"+meetingModelAttribute.getLocalTimeEnd()));
        if(meetingModelAttribute.getId()!=null){
            meeting.setId(Long.parseLong(meetingModelAttribute.getId()));
        }
        meeting.setDetails(meetingModelAttribute.getDetails());
        Event event = meetingManagerServiceInterface.findEventById(Long.parseLong(meetingModelAttribute.getEventId()));
        meeting.setEvent(event);
        Place place = meetingManagerServiceInterface.findPlaceById(Long.parseLong(meetingModelAttribute.getPlaceId()));
        meeting.setPlace(place);
        List<String> selectedPersonIdList = meetingModelAttribute.getPersonIdList();
        List<Person> selectedPersonList = selectedPersonIdList.stream().map(x->meetingManagerServiceInterface.findPersonById(Long.parseLong(x))).collect(Collectors.toList());
        meeting.setPersonList(selectedPersonList);
        return meeting;
    }
    //utilitary internal method, reused by the addMeetingShowForm and updateMeetingShowForm methods (refactoring for avoiding code duplicity)
    private void updateSelectOptionsForAvailablePersonsEventsAndPlaces(Model model) {
        Map<String, String> availablePersonIdNameMap = new HashMap<>();
        meetingManagerServiceInterface.findAllPersons().forEach(x -> availablePersonIdNameMap.put(String.valueOf(x.getId()), x.getName()));
        Map<String, String> availableEventIdNameMap = new HashMap<>();
        meetingManagerServiceInterface.findAllEvents().forEach(x -> availableEventIdNameMap.put(String.valueOf(x.getId()), x.getName()));
        Map<String, String> availablePlaceIdAddressMap = new HashMap<>();
        meetingManagerServiceInterface.findAllPlaces().forEach(x -> availablePlaceIdAddressMap.put(String.valueOf(x.getId()), x.getStreet() + ", " + x.getNumber() + ", " + x.getCity() + " - " + x.getCountry()));
        model.addAttribute("availablePersonIdNameMap", availablePersonIdNameMap);
        model.addAttribute("availableEventIdNameMap", availableEventIdNameMap);
        model.addAttribute("availablePlaceIdAddressMap", availablePlaceIdAddressMap);
    }
}

//for other Controllers the comments would be pretty much similar to the ones at this class, regarding the respective implemented functionalities.
