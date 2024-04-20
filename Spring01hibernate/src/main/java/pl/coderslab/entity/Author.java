package pl.coderslab.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "authors")
@Data
@RequiredArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
}
