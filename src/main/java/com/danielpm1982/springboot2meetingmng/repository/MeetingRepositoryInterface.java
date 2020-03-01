package com.danielpm1982.springboot2meetingmng.repository;
import com.danielpm1982.springboot2meetingmng.domain.Meeting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;

@Repository
public interface MeetingRepositoryInterface extends CrudRepository<Meeting, Long> {
    @Query("from Meeting m where m.localDateTimeStart=?1")
    Meeting findByLocalDateTimeStart(LocalDateTime localDateTime);
}
