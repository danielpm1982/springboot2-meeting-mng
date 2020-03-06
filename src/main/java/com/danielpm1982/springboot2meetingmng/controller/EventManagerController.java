package com.danielpm1982.springboot2meetingmng.controller;
import com.danielpm1982.springboot2meetingmng.domain.*;
import com.danielpm1982.springboot2meetingmng.modelAttribute.EventModelAttribute;
import com.danielpm1982.springboot2meetingmng.service.MeetingManagerServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class EventManagerController {
    private MeetingManagerServiceInterface meetingManagerServiceInterface;
    public EventManagerController(MeetingManagerServiceInterface meetingManagerServiceInterface) {
        this.meetingManagerServiceInterface = meetingManagerServiceInterface;
    }
    @RequestMapping("/events")
    public String showEvents(Model model){
        List<Event> eventList = meetingManagerServiceInterface.findAllEvents();
        model.addAttribute("events", eventList);
        return "events";
    }
    @RequestMapping("/add-event-form")
    public String addEventShowForm(Model model){
        model.addAttribute("error", null);
        model.addAttribute("eventModelAttribute", new EventModelAttribute());
        return "add-event-form";
    }
    @PostMapping("/add-event")
    public String addEvent(@ModelAttribute("eventModelAttribute") EventModelAttribute eventModelAttribute, Model model){
        if(meetingManagerServiceInterface.findEventByExactName(eventModelAttribute.getName())!=null){
            model.addAttribute("eventModelAttribute", eventModelAttribute);
            model.addAttribute("error", "Event already exists ! Enter a different event !");
            return "add-event-form";
        }
        Event event = new Event(eventModelAttribute.getName(), eventModelAttribute.getTheme(), eventModelAttribute.getOutfit(), eventModelAttribute.getHost(), Integer.parseInt(eventModelAttribute.getAttendance()));
        event.setDetails(eventModelAttribute.getDetails());
        meetingManagerServiceInterface.addEvent(event);
        return "redirect:/events";
    }
}
