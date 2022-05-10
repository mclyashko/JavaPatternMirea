package ru.mirea.task23.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mirea.task23.entities.dto.BookDto;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @SequenceGenerator(name = "books_sequence", sequenceName = "books_sequence", allocationSize = 1)
    @GeneratedValue(generator = "books_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private String creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    @JsonIgnore
    private Author author;

    @Column(name = "author_id")
    private Long authorId;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", authorId=" + authorId +
                '}';
    }

    public BookDto makeDto() {
        return new BookDto(id, name, creationDate, authorId);
    }

}
