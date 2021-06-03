package com.pweb.reserve.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_area;

    private Long apartment;

    /*@ManyToOne
    private Dweller dweller;

    @ManyToOne
    private Area area;*/

    //@JoinColumn(nullable = false)
    //@JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    //private LocalDate date;
    private String date;
    private String reason;

}
