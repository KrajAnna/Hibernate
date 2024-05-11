package pl.coderslab.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5)
    private String title;

    @Range(min =1, max =10)
    private int rating;

    @Size(max=600)
    private String description;

    @ManyToOne
    @NotEmpty
    private Publisher publisher;

    @Min(2)
    private Integer pages;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="books_author")
    private List<Author> authors = new ArrayList<>();

    public void addAuthor(Author author) {
        authors.add(author);
    }


}
