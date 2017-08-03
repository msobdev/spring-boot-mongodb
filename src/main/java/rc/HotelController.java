package rc;

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
}
