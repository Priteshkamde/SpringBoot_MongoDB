package pk;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/all")
    public List<Hotel> getALl(){
        List<Hotel> hotels = this.hotelRepository.findAll();

        return hotels;
    }

    @PutMapping
    public void insert(@RequestBody Hotel hotel){
        // Goes for new record insert
        this.hotelRepository.insert(hotel);
    }

    @PostMapping
    public void update(@RequestBody Hotel hotel){
        // save acts as UPSERT
        // if not present (id) then create a new hotel
        // if yes then it will update the existing one
        this.hotelRepository.save(hotel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        this.hotelRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Hotel> getById(@PathVariable("id") String id){
        Optional<Hotel> hotel = this.hotelRepository.findById(id);

        return hotel;
    }

    @GetMapping("/lprice/{price}")
    public List<Hotel> getbyPrice(@PathVariable("price") int price){
        List<Hotel> hotels = this.hotelRepository.findByDailyPriceLessThan(price);

        return hotels;
    }

    @GetMapping("/gprice/{price}")
    public List<Hotel> getbyMinPrice(@PathVariable("price") int price){
        List<Hotel> hotels = this.hotelRepository.findByDailyPriceGreaterThan(price);

        return hotels;
    }

    @GetMapping("/address/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city){
        List<Hotel> hotels = this.hotelRepository.findByCityAllIgnoreCase(city);

        return hotels;
    }


}
