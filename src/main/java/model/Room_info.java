package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "room_info")
public class Room_info {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "room_number")
    private int room_number;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Room_type room_type;


    @OneToMany(mappedBy = "room_info")
    @JsonIgnore
    private List<Rating> ratings;

    @OneToMany(mappedBy = "room_info")
    @JsonIgnore
    private List<Booking> bookings;
}
