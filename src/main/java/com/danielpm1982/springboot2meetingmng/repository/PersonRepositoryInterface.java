package com.danielpm1982.springboot2meetingmng.repository;
import com.danielpm1982.springboot2meetingmng.domain.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonRepositoryInterface extends CrudRepository<Person, Long> {
    @Query("from Person p where p.name like %:name% order by p.name asc")
    List<Person> findByName(String name);
}
