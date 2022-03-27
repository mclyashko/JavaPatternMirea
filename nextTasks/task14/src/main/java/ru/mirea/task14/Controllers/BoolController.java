package ru.mirea.task14.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.task14.Entities.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class BoolController {
    private ArrayList<Book> listOfBooks = new ArrayList<>();

    public static <T> ArrayList<T>
    getArrayListFromStream(Stream<T> stream)
    {

        List<T> list = stream.collect(Collectors.toList());

        ArrayList<T> arrayList = new ArrayList<T>(list);

        return arrayList;
    }

    @GetMapping(value = "/get_books")
    @ResponseBody
    public Object[] getBooks() {
        return listOfBooks.toArray();
    }

    @PostMapping(value = "/add_book")
    @ResponseBody
    public String addBook(@RequestParam("name") String name, @RequestParam("creationDate") String creationDate) {
        Book book = new Book(name, creationDate);
        System.out.println(book);
        listOfBooks.add(book);
        return book.toString();
    }

    @DeleteMapping(value = "/delete_book")
    @ResponseBody
    public boolean deleteBook(@RequestParam("name") String name, @RequestParam("creationDate") String creationDate) {
        listOfBooks = getArrayListFromStream(listOfBooks.stream()
                .filter(book -> !(book.getName().equals(name) &&
                        book.getCreationDate().equals(creationDate))));
        return listOfBooks.size() != 0;
    }
}
