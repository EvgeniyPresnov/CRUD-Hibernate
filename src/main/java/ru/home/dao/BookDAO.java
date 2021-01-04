package ru.home.dao;

import ru.home.entities.Book;

import java.util.List;
import java.util.Set;

public interface BookDAO {
    void add(Book book);
    void add(Set<Book> books);
    List<Book> getAllOrNull();
    Book getByIdOrNull(String id);
    void deleteById(String id);
    void delete(Book book);
    void update(Book book);
}
