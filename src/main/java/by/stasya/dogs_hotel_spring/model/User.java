package by.stasya.dogs_hotel_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")

public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @NotEmpty(message = "Поле обязательно для заполнения!")
//    @Size(min = 2, max = 50, message = "Поле должно содержать от 2 до 50 символов")
//    @Pattern(regexp = "[A-Za-z\\s]+", message = "Разрешены только латинские буквы")
    @Column(name = "full_name")
    private String full_name;

    @Column(name = "gender" )
    private String gender;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Booking> booking;


    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Rating> ratings;

}

