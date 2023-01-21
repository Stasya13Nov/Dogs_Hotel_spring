package by.stasya.dogs_hotel_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "dog")
public class Dog {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Поле обязательно для заполнения!")
    @Size(min = 2, max = 50, message = "Поле должно содержать от 2 до 50 символов")
    @Pattern(regexp = "[A-Za-z\\s]+", message = "Разрешены только латинские буквы")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Поле обязательно для заполнения!")
    @Size(min = 2, max = 50, message = "Поле должно содержать от 2 до 50 символов")
    @Pattern(regexp = "[A-Za-z\\s]+", message = "Разрешены только латинские буквы")
    @Column(name = "breed")
    private String breed;

    @NotEmpty(message = "Поле обязательно для заполнения!")
    @Min(value = 1, message = "Допускаются только числа от 1 до 25")
    @Max(value = 25, message = "Допускаются только числа от 1 до 25")
    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "dog")
    @JsonIgnore
    private List<Booking> booking;}
