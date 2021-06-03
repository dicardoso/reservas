package com.pweb.reserve.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@JoinColumn(nullable = false)
    private String name;

    //@JoinColumn(nullable = false)
    private String image;

    //@JoinColumn(nullable = false)
    private String description;

    /*@OneToMany(mappedBy = "area")
    private List<Reserve> reserves;*/


}
