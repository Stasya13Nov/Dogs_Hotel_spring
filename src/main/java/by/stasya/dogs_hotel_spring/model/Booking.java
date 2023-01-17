package by.stasya.dogs_hotel_spring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "reservation_date_time")
    private Date reservation_date_time;

    @Column(name = "date_in")
    private Date date_in;

    @Column(name = "date_out")
    private Date date_out;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private Room_type room_type;

    @ManyToOne
    @JoinTable(name = "room_info_id")
    private Room_info room_info;

}
