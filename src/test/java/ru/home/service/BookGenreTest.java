package ru.home.service;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;
import ru.home.dao.FactoryDAO;
import ru.home.entities.Book;
import ru.home.entities.Genre;
import ru.home.service.categories.OneToOneMapping;

@Category({OneToOneMapping.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookGenreTest {

    @Test
    public void addGenreAddBookFirstTest() {
        Genre genre = new Genre();
        genre.setGenreName("Fantasy");
        FactoryDAO.getGenreDAO().add(genre);

        Book book = new Book();
        book.setTitle("A Game of Thrones");
        book.setGenre(genre);
        book.setPages(100500);
        FactoryDAO.getBookDAO().add(book);

        Assert.assertFalse(FactoryDAO.getBookDAO().getAllOrNull().isEmpty());
        Assert.assertFalse(FactoryDAO.getGenreDAO().getAllOrNull().isEmpty());
    }

    @Test
    public void addGenreAndBookSecondTest() {
        Genre genre = new Genre();
        genre.setGenreName("Essay");
        FactoryDAO.getGenreDAO().add(genre);

        Book book = new Book();
        book.setTitle("A Modest Proposal");
        book.setGenre(genre);
        book.setPages(151);
        FactoryDAO.getBookDAO().add(book);

        Assert.assertFalse(FactoryDAO.getGenreDAO().getAllOrNull().isEmpty());
        Assert.assertFalse(FactoryDAO.getBookDAO().getAllOrNull().isEmpty());
    }

    @Test
    public void addGenreAndBookThirdTest() {
        Genre genre = new Genre();
        genre.setGenreName("Memoir");
        FactoryDAO.getGenreDAO().add(genre);

        Book book = new Book();
        book.setTitle("The Glass Castle");
        book.setGenre(genre);
        book.setPages(151);
        FactoryDAO.getBookDAO().add(book);

        Assert.assertFalse(FactoryDAO.getGenreDAO().getAllOrNull().isEmpty());
        Assert.assertFalse(FactoryDAO.getBookDAO().getAllOrNull().isEmpty());
    }


    @Test
    public void getAllGenresTest() {
        Assert.assertNotNull(FactoryDAO.getGenreDAO().getAllOrNull());
        Assert.assertTrue(FactoryDAO.getGenreDAO().getAllOrNull().size() > 0);
        Assert.assertFalse(FactoryDAO.getGenreDAO().getAllOrNull().isEmpty());
    }

    @Test
    public void getAllBooksTest() {
        Assert.assertNotNull(FactoryDAO.getBookDAO().getAllOrNull());
        Assert.assertTrue(FactoryDAO.getBookDAO().getAllOrNull().size() > 0);
        Assert.assertFalse(FactoryDAO.getBookDAO().getAllOrNull().isEmpty());
    }

    @Test
    public void updateGenreTest() {
        Genre genre = new Genre();
        genre.setGenreName("Suspense");
        FactoryDAO.getGenreDAO().add(genre);

        Book book = new Book();
        book.setGenre(genre);
        book.setTitle("Gone Girl");
        FactoryDAO.getBookDAO().add(book);

        String expected = FactoryDAO.getGenreDAO().getByIdOrNull("4").getGenreName();
        Genre genreModified = FactoryDAO.getGenreDAO().getByIdOrNull("4");
        genreModified.setGenreName("Thriller");
        FactoryDAO.getGenreDAO().update(genreModified);
        String actual = FactoryDAO.getGenreDAO().getByIdOrNull("4").getGenreName();

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void deleteBookByIdTest() {
        FactoryDAO.getBookDAO().deleteById("1");

        Assert.assertFalse(FactoryDAO.getBookDAO().getAllOrNull().isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void getGenreByIdThrowExceptionTest() {
        String expectedGenreName = "Fantasy";
        String actualGenreName = FactoryDAO.getGenreDAO().getByIdOrNull("100").getGenreName();

        Assert.assertEquals(expectedGenreName, actualGenreName);
    }
}
