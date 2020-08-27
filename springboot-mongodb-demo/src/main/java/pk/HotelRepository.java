package pk;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface HotelRepository extends MongoRepository<Hotel, String>, QuerydslPredicateExecutor<Hotel> {
    // <name, data-type of ID>

    Optional<Hotel> findById(String id);
    List<Hotel> findByDailyPrice(int maxPrice);

    List<Hotel> findByDailyPriceLessThan(int maxPrice);

//    @Query("{ 'address.city' :?0}")
//    List<Hotel> findByCity(String city);

    @Query("{ 'address.city' :?0}")
    List<Hotel> findByCityAllIgnoreCase(String city);
}
