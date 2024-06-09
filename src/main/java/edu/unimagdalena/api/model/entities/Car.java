package edu.unimagdalena.api.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Integer year;

    @Column(name = "location")
    private String location;

    @Column(name = "price_per_day")
    private Float pricePerDay;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date_available")
    private LocalDate endDateAvailable;

    //@OneToMany(mappedBy = "car")
    //private List<Rent> rents;
}

