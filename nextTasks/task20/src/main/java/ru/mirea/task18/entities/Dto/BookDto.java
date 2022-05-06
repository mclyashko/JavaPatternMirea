package ru.mirea.task18.entities.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class BookDto {
    private Long id;
    private String name;
    private String creationDate;
    private Long authorId;
}
