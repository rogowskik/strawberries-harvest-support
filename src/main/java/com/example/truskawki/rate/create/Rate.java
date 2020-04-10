package com.example.truskawki.rate.create;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Rate {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private LocalDate date;
    private int basketSorted;
    private int unsorted;
    private int unsorted;
    private int kg;
    {
        sortType: kg,
        kilogram: 150,
        basketQ: 2,
        paletteQ: 3,
            paleta-tr: "0.5kg"
    }



}
