package com.danielpm1982.springboot2meetingmng.modelAttribute;
import com.danielpm1982.springboot2meetingmng.domain.Meeting;
import com.danielpm1982.springboot2meetingmng.domain.Person;
import java.util.List;
import java.util.stream.Collectors;

public class MeetingModelAttribute {
    private String id;
    private String localDateStart;
    private String localDateEnd;
    private String localTimeStart;
    private String localTimeEnd;
    private String details;
    private String eventId;
    private String placeId;
    private List<String> personIdList;
    public MeetingModelAttribute() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getLocalDateStart() {
        return localDateStart;
    }
    public void setLocalDateStart(String localDateStart) {
        this.localDateStart = localDateStart;
    }
    public String getLocalDateEnd() {
        return localDateEnd;
    }
    public void setLocalDateEnd(String localDateEnd) {
        this.localDateEnd = localDateEnd;
    }
    public String getLocalTimeStart() {
        return localTimeStart;
    }
    public void setLocalTimeStart(String localTimeStart) {
        this.localTimeStart = localTimeStart;
    }
    public String getLocalTimeEnd() {
        return localTimeEnd;
    }
    public void setLocalTimeEnd(String localTimeEnd) {
        this.localTimeEnd = localTimeEnd;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public String getEventId() {
        return eventId;
    }
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
    public String getPlaceId() {
        return placeId;
    }
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }
    public List<String> getPersonIdList() {
        return personIdList;
    }
    public void setPersonIdList(List<String> personIdList) {
        this.personIdList = personIdList;
    }
    @Override
    public String toString() {
        return "MeetingModelAttribute{" +
                "id='" + id + '\'' +
                ", localDateStart='" + localDateStart + '\'' +
                ", localDateEnd='" + localDateEnd + '\'' +
                ", localTimeStart='" + localTimeStart + '\'' +
                ", localTimeEnd='" + localTimeEnd + '\'' +
                ", details='" + details + '\'' +
                ", eventId='" + eventId + '\'' +
                ", placeId='" + placeId + '\'' +
                ", personIdList=" + personIdList +
                '}';
    }
    public static MeetingModelAttribute getMeetingModelAttributeFromMeetingObject(Meeting meeting){
        MeetingModelAttribute meetingModelAttribute = new MeetingModelAttribute();
        if(meeting.getId()!=null) {
            meetingModelAttribute.setId(String.valueOf(meeting.getId()));
        }
        meetingModelAttribute.setLocalDateStart(meeting.getLocalDateTimeStart().toLocalDate().toString());
        meetingModelAttribute.setLocalTimeStart(meeting.getLocalDateTimeStart().toLocalTime().toString());
        meetingModelAttribute.setLocalDateEnd(meeting.getLocalDateTimeEnd().toLocalDate().toString());
        meetingModelAttribute.setLocalTimeEnd(meeting.getLocalDateTimeEnd().toLocalTime().toString());
        meetingModelAttribute.setDetails(meeting.getDetails());
        meetingModelAttribute.setEventId(String.valueOf(meeting.getEvent().getId()));
        meetingModelAttribute.setPlaceId(String.valueOf(meeting.getPlace().getId()));
        meetingModelAttribute.setPersonIdList(meeting.getPersonList().stream().map(Person::getId).map(String::valueOf).collect(Collectors.toList()));
        return meetingModelAttribute;
    }
    public static MeetingModelAttribute getBlankMeetingModelAttribute(){
        MeetingModelAttribute meetingModelAttribute = new MeetingModelAttribute();
        meetingModelAttribute.setEventId("0");
        meetingModelAttribute.setPlaceId("0");
        meetingModelAttribute.setPersonIdList(List.of("notSelected"));
        return meetingModelAttribute;
    }
}
