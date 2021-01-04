package ru.home.dao;

import ru.home.service.AuthorService;
import ru.home.service.BookService;
import ru.home.service.GenreService;
import ru.home.service.ShopService;

public class FactoryDAO {
    private static AuthorDAO authorDAO;
    private static GenreDAO genreDAO;
    private static BookDAO bookDAO;
    private static ShopDAO shopDAO;

    public static AuthorDAO getAuthorDAO() {
        if (authorDAO == null) {
            authorDAO = new AuthorService();
        }
        return authorDAO;
    }

    public static GenreDAO getGenreDAO() {
        if (genreDAO == null) {
            genreDAO = new GenreService();
        }
        return genreDAO;
    }

    public static BookDAO getBookDAO() {
        if (bookDAO == null) {
            bookDAO = new BookService();
        }
        return bookDAO;
    }

    public static ShopDAO getShopDAO() {
        if (shopDAO == null) {
            shopDAO = new ShopService();
        }
        return shopDAO;
    }
}
