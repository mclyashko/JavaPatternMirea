package ru.mirea.task23.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class AuthorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String birthDate;
    private List<BookDto> books;
}
