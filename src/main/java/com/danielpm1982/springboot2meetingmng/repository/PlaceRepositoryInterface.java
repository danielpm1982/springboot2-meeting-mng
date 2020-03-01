package com.danielpm1982.springboot2meetingmng.repository;
import com.danielpm1982.springboot2meetingmng.domain.Place;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlaceRepositoryInterface extends CrudRepository<Place, Long> {
    @Query("from Place p where p.street=:street and p.number=:number")
    Place findByStreetAndNumber(String street, Integer number);
    @Query("from Place p where p.city like %?1% order by p.city asc")
    List<Place> findByCity(String city);
    @Query("from Place p where p.state like %?1% order by p.state asc")
    List<Place> findByState(String state);
    @Query("from Place p where p.country like %?1% order by p.country asc")
    List<Place> findByCountry(String country);
}
