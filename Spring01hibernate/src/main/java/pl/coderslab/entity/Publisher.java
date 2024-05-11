package pl.coderslab.entity;

import lombok.Data;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "publishers")
@Data

public class Publisher {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NIP
    private String nip;
    @REGON
    private String regon;
}
