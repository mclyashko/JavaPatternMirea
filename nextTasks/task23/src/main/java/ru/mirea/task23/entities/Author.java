package ru.mirea.task23.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mirea.task23.entities.dto.AuthorDto;
import ru.mirea.task23.entities.dto.BookDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Authors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @SequenceGenerator(name = "authors_sequence", sequenceName = "authors_sequence", allocationSize = 1)
    @GeneratedValue(generator = "authors_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "date")
    private String birthDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    public AuthorDto makeDto() {
        List<BookDto> bookDtoList = books.stream().map(Book::makeDto).toList();
        return new AuthorDto(id, firstName, lastName, middleName, birthDate, bookDtoList);
    }

}
