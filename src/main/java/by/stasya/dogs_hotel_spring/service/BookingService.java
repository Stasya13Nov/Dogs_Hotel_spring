package by.stasya.dogs_hotel_spring.service;

import by.stasya.dogs_hotel_spring.model.Booking;
import by.stasya.dogs_hotel_spring.repository.BookingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BookingService {

    private final BookingRepository bookingRepository;

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Booking findById(int id) {
        return bookingRepository.findById(id).orElseThrow();
    }

    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void delete(int id) {
        bookingRepository.deleteById(id);
    }

//@Transactional
//    public Booking update(int id, Booking booking) { //put
//    return bookingRepository.findById(id)
//            .map(ans -> {
//                ans.setDate_in(booking.getDate_in());
//                ans.setDate_out(booking.getDate_out());
//                ans.setClient(booking.getClient());
//                ans.setDog(booking.getDog());
//                ans.setRoom_type(booking.getRoom_type());
//                return ans;
//            }).orElseThrow();
//    }

    @Transactional
    public Booking partialUpdate(int id, Booking booking) { //patch
        return bookingRepository.findById(id)
                .map(ans -> {
                    log.info(ans.toString());
                    if(booking.getDate_in() != null)
                        ans.setDate_in(booking.getDate_in());

                    if(booking.getDate_out() != null) {
                        ans.setDate_out(booking.getDate_out());
                    }

                    if(booking.getClient() != null)
                        ans.setClient(booking.getClient());

                    if(booking.getDog() != null)
                        ans.setDog(booking.getDog());

                    if(booking.getRoom_type() != null)
                        ans.setRoom_type(booking.getRoom_type());

                    return ans;
                }).orElseThrow();

    }

//    public List<Booking> findByPrefix(String prefix) {
//        return bookingRepository.findByNameStartingWithIgnoreCase(prefix);
//    }
}
