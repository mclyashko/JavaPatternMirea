package ru.mirea.task24.entities.dto;


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
