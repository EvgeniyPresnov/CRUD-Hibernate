package ru.home.dao;

import ru.home.entities.Shop;

import java.util.List;

public interface ShopDAO {
    void add(Shop shop);
    List<Shop> getAllOrNull();
    Shop getByIdOrNull(String id);
    void deleteById(String id);
    void delete(Shop shop);
    void update(Shop shop);
}
