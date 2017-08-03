package rc;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by sob1 on 03.08.2017.
 */
@Repository
public interface HotelRepository extends MongoRepository<Hotel, String>, QueryDslPredicateExecutor<Hotel>{
    Hotel findById(String id);
    List<Hotel> findByPricePerNightLessThan(int maxPrice);

    @Query(value = "{address.city:?0}")
    List<Hotel> findByCity(String city);


}
