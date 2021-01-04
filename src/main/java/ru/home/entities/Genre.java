package ru.home.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "genre")
public class Genre implements Serializable {
    private static final long serialVersionUID = 1L;
    private int genreId;
    private String genreName;
    private Book book;

    public Genre() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Column(name = "name"/*"genre_name"*/)
    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @OneToOne(cascade = CascadeType.ALL
                ,fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Genre)) {
            return false;
        }

        Genre other = (Genre) obj;

        return Objects.equals(genreId, other.genreId)
                && Objects.equals(genreName, other.genreName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreId, genreName);
    }

    @Override
    public String toString() {
        return "Genre {" +
                "id = " + genreId +
                ", name = " + genreName +
                "}";
    }
}