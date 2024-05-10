package articleManager.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String title;  //(max. 200 znaków),
    @ManyToOne
    private Author author; //- (powiązanie relacją do klasy Author) - artykuł może mieć tylko jednego autora
    @ManyToMany
    private List<Category> categories;// - (powiązanie relacją do klasy Category) - artykuł może należeć do wielu kategorii
    private String content;
    private LocalDateTime created;// (wartość ma być automatycznie dodawana podczas zapisu)
    private LocalDateTime updated; //(wartość ma być automatycznie zmieniana podczas edycji).

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + (author != null ? author.getId() : "null") + // Avoid calling author.toString()
                ", categories=" + categories + // Avoid calling categories.toString() directly
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
