package ru.home.dao;

import ru.home.entities.Author;

import java.util.List;

public interface AuthorDAO {
    void add(Author author);
    List<Author> getAllOrNull();
    Author getByIdOrNull(String id);
    void deleteById(String id);
    void delete(Author author);
    void update(Author author);
}
