package rc;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sob1 on 03.08.2017.
 */
@Repository
public interface HotelRepository extends MongoRepository<Hotel, String>{
    Hotel findById(String id);
    List<Hotel> findByPricePerNightLessThan(int maxPrice);
}
