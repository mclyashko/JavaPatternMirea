package ru.mirea.task15.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private String creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    @JsonIgnore
    private Author author;

    @Column(name = "author_id")
    private Integer authorId;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", author=" + author +
                ", authorId=" + authorId +
                '}';
    }
}
