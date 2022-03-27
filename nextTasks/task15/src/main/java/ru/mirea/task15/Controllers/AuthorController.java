package ru.mirea.task15.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.task15.Entities.Author;
import ru.mirea.task15.Entities.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class AuthorController {
    private ArrayList<Author> listOfAuthors = new ArrayList<>();

    public static <T> ArrayList<T>
    getArrayListFromStream(Stream<T> stream)
    {

        List<T> list = stream.collect(Collectors.toList());

        ArrayList<T> arrayList = new ArrayList<T>(list);

        return arrayList;
    }

    @GetMapping(value = "/get_authors")
    @ResponseBody
    public Object[] getAuthors() {
        return listOfAuthors.toArray();
    }

    @PostMapping(value = "/add_author")
    @ResponseBody
    public String addAuthor(@RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName,
                            @RequestParam("middleName") String middleName,
                            @RequestParam("birthDate") String birthDate) {
        Author author = new Author(firstName, lastName, middleName, birthDate);
        System.out.println(author);
        listOfAuthors.add(author);
        return author.toString();
    }

    @DeleteMapping(value = "/delete_author")
    @ResponseBody
    public boolean deleteAuthor(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("middleName") String middleName,
                                @RequestParam("birthDate") String birthDate) {
        listOfAuthors = getArrayListFromStream(listOfAuthors.stream()
                .filter(author -> !(author.getFirstName().equals(firstName) &&
                        author.getLastName().equals(lastName) &&
                        author.getMiddleName().equals(middleName) &&
                        author.getBirthDate().equals(birthDate))));
        return listOfAuthors.size() != 0;
    }
}
