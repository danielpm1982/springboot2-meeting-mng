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
When running the test above, at the browser use the mapping path: http://localhost:8080/h2 to open an instance of the H2 DB.
Then run the following SQL, at the DBMS GUI for showing all joins, columns and tuples of Meeting registries:

CREATE VIEW MEETING_JOIN_PERSON
AS
select MEETING_ID, MEETING_START, MEETING_END, MEETING_DETAILS, MEETING_EVENT_ID_FK, MEETING_PLACE_ID_FK, MEETING_ID_FK, PERSON_ID_FK, PERSON_ID, PERSON_NAME, PERSON_GENDER, PERSON_BIRTH_DATE, PERSON_EMAIL, PERSON_POSITION, PERSON_COMPANY, PERSON_DETAILS from (SELECT * FROM MEETING m join MEETING_PERSON mp on m.MEETING_ID = mp.MEETING_ID_FK) j1 join PERSON p on j1.PERSON_ID_FK = p.PERSON_ID;

CREATE VIEW MEETING_JOIN_PERSON_JOIN_EVENT_JOIN_PLACE
AS
select MEETING_ID, MEETING_START, MEETING_END, MEETING_DETAILS, MEETING_EVENT_ID_FK, MEETING_PLACE_ID_FK, MEETING_ID_FK, PERSON_ID_FK, PERSON_ID, PERSON_NAME, PERSON_GENDER, PERSON_BIRTH_DATE, PERSON_EMAIL, PERSON_POSITION, PERSON_COMPANY, PERSON_DETAILS, EVENT_ID, EVENT_NAME, EVENT_THEME, EVENT_OUTFIT, EVENT_HOST, EVENT_ATTENDANCE, EVENT_DETAILS, PLACE_ID, PLACE_STREET, PLACE_NUMBER, PLACE_CITY, PLACE_STATE, PLACE_COUNTRY, PLACE_ZIP_CODE, PLACE_DETAILS from (select * from MEETING_JOIN_PERSON mjp join EVENT e on mjp.MEETING_EVENT_ID_FK = e.event_id) mjpje join PLACE p on mjpje.MEETING_PLACE_ID_FK = p.PLACE_ID;

select * from MEETING_JOIN_PERSON_JOIN_EVENT_JOIN_PLACE;
*/

/*
See the png files at the test folder with the DB state after running the test above.
*/

/*
For testing at the browser, start up the server and try http://localhost:8080 at the browser, and test all links and functionalities from the web view.
Check at the DB view as well - http://localhost:8080/h2.
*/

/*
For comments about the Controllers, view the MeetingManagerController comments. Other Controllers work similarly.
*/

/*
The domain JPA entities, the repository interfaces (implemented automatically by Spring Data JPA), the service interface/class (which includes all repositories
injected and facades all services for the Controllers) and, lastly, the modelAttribute classes (which basically transfer String data from the HTML forms to the
Controller) are self-explicative.
*/

/*
Regarding the HTML templates, managed by Thymeleaf engine to produce the HTML view pages, for any doubt consult the reference:
https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html
*/

/*
© 2020 Daniel Pinheiro Maia All Rights Reserved
Daniel Pinheiro Maia
danielpm1982.com
danielpm1982@gmail.com
linkedin.com/in/danielpm1982
Brazil
*/

