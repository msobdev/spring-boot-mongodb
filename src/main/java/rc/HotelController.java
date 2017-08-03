package rc;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sob1 on 03.08.2017.
 */
@RestController
@RequestMapping("/hotels")
public class HotelController {

    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/all")
    public List<Hotel> getAll(){
        List<Hotel> hotels = hotelRepository.findAll();

        return hotels;
    }

    // CREATE or UPDATE
    @PutMapping
    public void insert(@RequestBody Hotel hotel){
        // insert
        hotelRepository.insert(hotel);
    }

    // CREATE
    @PostMapping
    public void update(@RequestBody Hotel hotel){
        // insert or save
        hotelRepository.save(hotel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        hotelRepository.delete(id);
    }

    @GetMapping("/{id}")
    public Hotel getById(@PathVariable("id") String id){
        return hotelRepository.findById(id);
    }

    @GetMapping("/price/{maxPrice}")
    public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice){
        return hotelRepository.findByPricePerNightLessThan(maxPrice);
    }

    @GetMapping("/city/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city){
        return hotelRepository.findByCity(city);
    }

    @GetMapping("/country/{country}")
    public List<Hotel> getByCountry(@PathVariable("country") String country){
        // create a query class (QHotel)
        QHotel qHotel = new QHotel("hotel");
        // using the query class we can create the filters
        BooleanExpression filterByCountry = qHotel.address.country.eq(country);
        // pass the filters to the findAll method
        return (List<Hotel>) hotelRepository.findAll(filterByCountry);
    }

    @GetMapping("/recommended")
    public List<Hotel> getRecommended(){
        final int maxPrice = 140;
        final int minRating = 7;
        // create a query class (QHotel)
        QHotel qHotel = new QHotel("hotel");
        // using the query class we can create the filters
        BooleanExpression filterByPrice = qHotel.pricePerNight.lt(maxPrice);
        BooleanExpression filterByRating = qHotel.reviews.any().rating.gt(minRating);
        // pass the filters to the findAll method
        return (List<Hotel>) hotelRepository.findAll(filterByPrice.and(filterByRating));
    }
}
