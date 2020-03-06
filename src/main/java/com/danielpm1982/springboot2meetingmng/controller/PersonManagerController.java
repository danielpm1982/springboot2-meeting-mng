package com.danielpm1982.springboot2meetingmng.controller;
import com.danielpm1982.springboot2meetingmng.domain.*;
import com.danielpm1982.springboot2meetingmng.modelAttribute.PersonModelAttribute;
import com.danielpm1982.springboot2meetingmng.service.MeetingManagerServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PersonManagerController {
    private MeetingManagerServiceInterface meetingManagerServiceInterface;
    public PersonManagerController(MeetingManagerServiceInterface meetingManagerServiceInterface) {
        this.meetingManagerServiceInterface = meetingManagerServiceInterface;
    }
    @RequestMapping("/persons")
    public String showPersons(Model model){
        List<Person> personList = meetingManagerServiceInterface.findAllPersons();
        model.addAttribute("persons", personList);
        return "persons";
    }
    @RequestMapping("/add-person-form")
    public String addPersonShowForm(Model model){
        model.addAttribute("personModelAttribute", new PersonModelAttribute());
        Map<String, Gender> genderOptionsMap = new HashMap<>();
        genderOptionsMap.put("Male", Gender.MALE);
        genderOptionsMap.put("Female", Gender.FEMALE);
        model.addAttribute("genderOptions", genderOptionsMap);
        return "add-person-form";
    }
    @PostMapping("/add-person")
    public String addPerson(@ModelAttribute("personModelAttribute") PersonModelAttribute personModelAttribute){
        Person person = new Person(personModelAttribute.getName(), Gender.valueOf(personModelAttribute.getGender()), LocalDate.parse(personModelAttribute.getBirthDate()), personModelAttribute.getEmail());
        person.setPosition(personModelAttribute.getPosition());
        person.setCompany(personModelAttribute.getCompany());
        person.setDetails(personModelAttribute.getDetails());
        meetingManagerServiceInterface.addPerson(person);
        return "redirect:/persons";
    }
}
