package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "room_type")
public class Room_type {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "room_type")
    @JsonIgnore
    private List<Room_info> room_info;

    @OneToMany(mappedBy = "room_type")
    @JsonIgnore
    private List<Booking> booking;

}
