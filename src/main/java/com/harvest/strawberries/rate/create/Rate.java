package com.harvest.strawberries.rate.create;

import com.harvest.strawberries.weekday.Weekday;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

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
    @Enumerated(EnumType.STRING)
    private Weekday weekday;
    private int basketSorted;
    private int basketUnsorted;
    private int basketCropped;
    private int kg;

}
