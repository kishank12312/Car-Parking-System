package com.example.demo.module2;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false, length = 255)
    private String location;

    @Column(nullable = false)
    private Boolean Availability;

    @Column(nullable = false)
    private int PricePerHr;

    @Column(nullable = false, unique = false, length = 255)
    private String Worker;

    @Column(nullable = true, unique = false, length = 255)
    private String Customer;

    @Column(nullable = true, unique = false, length = 255)
    private String Date;

    @Column(nullable = true, unique = false, length = 255)
    private String Rating;

    public ParkingSlot(
            String Location,
            Boolean Availability,
            String Worker,
            String Customer,
            String Date,
            String Rating
    ){
         this.location = Location;
         this.Availability = Availability;
         this.PricePerHr = 25;
         this.Worker = Worker;
         this.Customer = Customer;
         this.Date = Date;
         this.Rating = Rating;
    }

}
