package articleManager.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Article> articles;

}
