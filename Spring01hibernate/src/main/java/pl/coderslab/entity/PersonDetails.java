package pl.coderslab.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="person_details")
@Data
public class PersonDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public PersonDetails(String firstName, String lastName, String streetNumber, String street, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetNumber = streetNumber;
        this.street = street;
        this.city = city;
    }

    private String firstName;
    private String lastName;
    private String streetNumber;
    private String street;
    private String city;
}
