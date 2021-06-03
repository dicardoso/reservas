package com.pweb.reserve.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Dweller {

    //@JoinColumn(nullable = false)
    private String name;

    //@JoinColumn(nullable = false)
    private String login;

    //@JoinColumn(nullable = false)
    private String pass;

    @Id
    private Long apartment;

    //@JoinColumn(nullable = false)
    private boolean is_adm;

    /*@OneToMany(mappedBy = "dweller")
    private List<Reserve> reserves;*/
}
