package com.danielpm1982.springboot2meetingmng.repository;
import com.danielpm1982.springboot2meetingmng.domain.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EventRepositoryInterface extends CrudRepository<Event, Long> {
    @Query("from Event e where e.name like %?1% order by e.name asc")
    List<Event> findByName(String name);
    @Query("from Event e where e.name like ?1")
    Event findByExactName(String name);
}
