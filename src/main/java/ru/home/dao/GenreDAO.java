package ru.home.dao;

import ru.home.entities.Genre;

import java.util.List;

public interface GenreDAO {
    void add(Genre genre);
    List<Genre> getAllOrNull();
    Genre getByIdOrNull(String id);
    void deleteById(String id);
    void delete(Genre genre);
    void update(Genre genre);
}
