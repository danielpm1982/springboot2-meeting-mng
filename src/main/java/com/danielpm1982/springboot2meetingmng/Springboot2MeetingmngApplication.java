package com.danielpm1982.springboot2meetingmng;
import com.danielpm1982.springboot2meetingmng.test.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Springboot2MeetingmngApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Springboot2MeetingmngApplication.class, args);
        ((Test)ctx.getBean("test")).test();
    }
}


/*
When running the test above, at the browser use the mapping path: localhost:8080/h2 to open an instance of the H2 DB.
Then run the following SQL, at the DBMS GUI for showing all joins, columns and tuples of Meeting registries:

CREATE VIEW MEETING_JOIN_PERSON
AS
select MEETING_ID, MEETING_START, MEETING_END, MEETING_DETAILS, MEETING_EVENT_ID_FK, MEETING_PLACE_ID_FK, MEETING_ID_FK, PERSON_ID_FK, PERSON_ID, PERSON_NAME, PERSON_GENDER, PERSON_BIRTH_DATE, PERSON_EMAIL, PERSON_POSITION, PERSON_COMPANY, PERSON_DETAILS from (SELECT * FROM MEETING m join MEETING_PERSON mp on m.MEETING_ID = mp.MEETING_ID_FK) j1 join PERSON p on j1.PERSON_ID_FK = p.PERSON_ID

CREATE VIEW MEETING_JOIN_PERSON_JOIN_EVENT_JOIN_PLACE
AS
select MEETING_ID, MEETING_START, MEETING_END, MEETING_DETAILS, MEETING_EVENT_ID_FK, MEETING_PLACE_ID_FK, MEETING_ID_FK, PERSON_ID_FK, PERSON_ID, PERSON_NAME, PERSON_GENDER, PERSON_BIRTH_DATE, PERSON_EMAIL, PERSON_POSITION, PERSON_COMPANY, PERSON_DETAILS, EVENT_ID, EVENT_NAME, EVENT_THEME, EVENT_OUTFIT, EVENT_HOST, EVENT_ATTENDANCE, EVENT_DETAILS, PLACE_ID, PLACE_STREET, PLACE_NUMBER, PLACE_CITY, PLACE_STATE, PLACE_COUNTRY, PLACE_ZIP_CODE, PLACE_DETAILS from (select * from MEETING_JOIN_PERSON mjp join EVENT e on mjp.MEETING_EVENT_ID_FK = e.event_id) mjpje join PLACE p on mjpje.MEETING_PLACE_ID_FK = p.PLACE_ID

select * from MEETING_JOIN_PERSON_JOIN_EVENT_JOIN_PLACE
*/
