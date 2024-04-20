package pl.coderslab.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "publishers")
@Data

public class Publisher {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
}
