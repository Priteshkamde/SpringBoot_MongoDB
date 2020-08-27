package pk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {
    private HotelRepository hotelRepository;

    public DBSeeder(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Hotel marriot = new Hotel(
                "JW Marriot",
                150,
                new Address("Bombay", "India"),
                Arrays.asList(
                        new Review("Pritesh", 9, true),
                        new Review("Shivani", 9, true)
                )
        );
        Hotel oberoi = new Hotel(
                "Oberoi",
                200,
                new Address("Paris", "France"),
                Arrays.asList(
                        new Review("Pritesh", 10, true),
                        new Review("Shivani", 10, true)
                        )
        );
        Hotel taj = new Hotel(
                "Taj",
                400,
                new Address("Bombay", "India"),
                Arrays.asList(
                        new Review("Pritesh", 10, true),
                        new Review("Shivani", 10, true)
                        )
        );
        Hotel sands = new Hotel(
                "Golden sands",
                400,
                new Address("Bombay", "India"),
                Arrays.asList(

                )
        );

        this.hotelRepository.deleteAll();

        this.hotelRepository.save(marriot);
        this.hotelRepository.save(oberoi);
        this.hotelRepository.save(taj);
        this.hotelRepository.save(sands);

//         ALTERNATIVE using SAVE ALL => add our hotels to the database
//         List<Hotel> hotels = Arrays.asList(marriot, oberoi, taj);
//         this.hotelRepository.saveAll(hotels);



    }
}
