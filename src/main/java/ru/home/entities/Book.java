package ru.home.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private int bookId;
    private String title;
    private String publisher;
    private int pages;
    private String note;
    private int year;
    private Genre genre;
    private Author author;
    private Set<Shop> shops = new HashSet<>();

    public Book() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "publisher")
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Column(name = "pages")
    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @OneToOne(cascade = CascadeType.ALL
                , fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id")
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "shop_book"
            , joinColumns = @JoinColumn(name = "book_id")
            , inverseJoinColumns = @JoinColumn(name = "shop_id"))
    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Book)) {
            return false;
        }

        Book other = (Book) obj;

        return Objects.equals(bookId, other.bookId)
                && Objects.equals(title, other.title)
                && Objects.equals(publisher, other.publisher)
                && Objects.equals(pages, other.pages)
                && Objects.equals(note, other.note)
                && Objects.equals(year, other.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, publisher, pages, note, year);
    }

    @Override
    public String toString() {
        return "Book {" +
                "id = " + bookId +
                ", title = " + title +
                ", publisher = " + publisher +
                ", pages = " + pages +
                ", note = " + note +
                ", year = " + year +
                ", genre = " + genre +
                ", author" + author +
                ", shops = " + shops +
                "}";
    }
}