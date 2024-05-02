package articleManager.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
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

}
