package rc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sob1 on 03.08.2017.
 */
@Component
public class DbSeeder implements CommandLineRunner{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public void run(String... strings) throws Exception {
        Hotel mariot = new Hotel(
                "Marriot",
                130,
                new Address("Paris", "France"),
                Arrays.asList(
                        new Review("John", 8, false),
                        new Review("Mary", 7, true)
                ));
        Hotel ibis = new Hotel(
                "Ibis",
                90,
                new Address("Bucharest", "Romania"),
                Arrays.asList(
                        new Review("Teddy", 3, false)
                ));
        Hotel Mazurkas = new Hotel(
                "Mazurkas",
                200,
                new Address("Rome", "Italy"),
                new ArrayList<>());

        // drop all hotels
        hotelRepository.deleteAll();

        List<Hotel> hotels = Arrays.asList(mariot, ibis, Mazurkas);

        // add hotels to the database
        hotelRepository.save(hotels);

    }
}
