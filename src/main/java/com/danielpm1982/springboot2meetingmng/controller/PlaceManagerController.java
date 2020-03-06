package com.danielpm1982.springboot2meetingmng.controller;
import com.danielpm1982.springboot2meetingmng.domain.*;
import com.danielpm1982.springboot2meetingmng.modelAttribute.PlaceModelAttribute;
import com.danielpm1982.springboot2meetingmng.service.MeetingManagerServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class PlaceManagerController {
    private MeetingManagerServiceInterface meetingManagerServiceInterface;
    public PlaceManagerController(MeetingManagerServiceInterface meetingManagerServiceInterface) {
        this.meetingManagerServiceInterface = meetingManagerServiceInterface;
    }
    @RequestMapping("/places")
    public String showPlaces(Model model){
        List<Place> placeList = meetingManagerServiceInterface.findAllPlaces();
        model.addAttribute("places", placeList);
        return "places";
    }
    @RequestMapping("/add-place-form")
    public String addPlaceShowForm(Model model){
        model.addAttribute("error", null);
        model.addAttribute("placeModelAttribute", new PlaceModelAttribute());
        return "add-place-form";
    }
    @PostMapping("/add-place")
    public String addPlace(@ModelAttribute("placeModelAttribute") PlaceModelAttribute placeModelAttribute, Model model){
        if(meetingManagerServiceInterface.findPlaceByStreetAndNumber(placeModelAttribute.getStreet(), Integer.parseInt(placeModelAttribute.getNumber()))!=null){
            model.addAttribute("placeModelAttribute", placeModelAttribute);
            model.addAttribute("error", "Place already exists ! Enter a different address !");
            return "add-place-form";
        }
        Place place = new Place(placeModelAttribute.getStreet(), Integer.parseInt(placeModelAttribute.getNumber()), placeModelAttribute.getCity(), placeModelAttribute.getState(), placeModelAttribute.getCountry());
        place.setZipCode(placeModelAttribute.getZipCode());
        place.setDetails(placeModelAttribute.getDetails());
        meetingManagerServiceInterface.addPlace(place);
        return "redirect:/places";
    }
}
