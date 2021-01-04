package ru.home.service;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;
import ru.home.dao.FactoryDAO;
import ru.home.entities.Author;
import ru.home.entities.Book;
import ru.home.service.categories.OneToManyMapping;

import java.util.HashSet;
import java.util.Set;

@Category({OneToManyMapping.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookAuthorTest {

    @Test
    public void addAuthorAndBookTest() {
        Author author = new Author();
        author.setAuthorName("Arthur Hailey");
        FactoryDAO.getAuthorDAO().add(author);

        Book book = new Book();
        book.setTitle("Airport");
        book.setYear(1968);
        book.setPages(521);
        book.setAuthor(author);
        FactoryDAO.getBookDAO().add(book);

        Assert.assertFalse(FactoryDAO.getAuthorDAO().getAllOrNull().isEmpty());
        Assert.assertFalse(FactoryDAO.getBookDAO().getAllOrNull().isEmpty());
    }

    @Test
    public void addAuthorAndBooksTest() {
        Author author = new Author();
        author.setAuthorName("Stephen King");
        FactoryDAO.getAuthorDAO().add(author);

        Book book1 = new Book();
        book1.setTitle("Carrie");
        book1.setPublisher("Doubleday");
        book1.setPages(199);
        book1.setYear(1974);
        book1.setAuthor(author);

        Book book2 = new Book();
        book2.setTitle("'Salem's Lot");
        book2.setPublisher("Doubleday");
        book2.setPages(439);
        book2.setNote("World Fantasy Award nominee for Best Novel, 1976");
        book2.setYear(1975);
        book2.setAuthor(author);

        Book book3 = new Book();
        book3.setTitle("The Shining");
        book3.setPublisher("Doubleday");
        book3.setPages(447);
        book3.setNote("Runner-up, Locus Award, 1978");
        book3.setYear(1977);
        book3.setAuthor(author);

        Book book4 = new Book();
        book4.setTitle("Cujo");
        book4.setPublisher("Viking Press");
        book4.setPages(319);
        book4.setNote("Winner, British Fantasy Award’s August Derleth Award, 1982");
        book4.setYear(1981);
        book4.setAuthor(author);

        Set<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        author.setBooks(books);
        FactoryDAO.getBookDAO().add(books);

        Assert.assertFalse(FactoryDAO.getAuthorDAO().getAllOrNull().isEmpty());
        Assert.assertFalse(FactoryDAO.getBookDAO().getAllOrNull().isEmpty());
    }

    @Test
    public void updateBookTest() {
        Book book = FactoryDAO.getBookDAO().getByIdOrNull("1");
        String expected = book.getTitle();
        book.setTitle("Hotel");
        book.setYear(1965);
        book.setPages(550);
        FactoryDAO.getBookDAO().update(book);
        String actual = book.getTitle();

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void updateAuthorTest() {
        Author author = FactoryDAO.getAuthorDAO().getByIdOrNull("1");
        String expected = author.getAuthorName();
        author.setAuthorName("Arthur Frederick Hailey");
        FactoryDAO.getAuthorDAO().update(author);
        String actual = author.getAuthorName();

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void deleteAuthorTest() {
        Author author = FactoryDAO.getAuthorDAO().getByIdOrNull("2");
        FactoryDAO.getAuthorDAO().delete(author);

        Assert.assertFalse(FactoryDAO.getAuthorDAO().getAllOrNull().isEmpty());
    }

    @Test
    public void getAllAuthorsTest() {
        Assert.assertNotNull(FactoryDAO.getAuthorDAO().getAllOrNull());
        Assert.assertTrue(FactoryDAO.getAuthorDAO().getAllOrNull().size() > 0);
        Assert.assertFalse(FactoryDAO.getAuthorDAO().getAllOrNull().isEmpty());
    }
}
