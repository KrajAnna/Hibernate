package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    public Book findOneByTitle(String title);
    public Book findFerrariByTitle(String title);
    public List<Book> getAllByTitle(String title);
    public List<Book> readAllByAuthors(Author author);
    public List<Book> queryByPagesIsGreaterThanEqual(Integer pages);
    //  public List<Book> findFirst33OrderByPagesDesc();
    @Query("select b from Book b order by b.pages") //customowa metoda, poprzez definicje query
    public List<Book> fundFirs8ByCos();

}
