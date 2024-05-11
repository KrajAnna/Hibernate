package pl.coderslab.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@Data
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String email;

    @OneToOne
    private PersonDetails personDetails;
    public Person(String login, String password, String email, PersonDetails personDetails) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.personDetails = personDetails;
    }
    public Person(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

}
