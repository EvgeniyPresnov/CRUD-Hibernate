package ru.home.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author implements Serializable {
    private static final long serialVersionUID = 1L;
    private int authorId;
    private String authorName;
    private Set<Book> books;

    public Author() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Column(name = "author_name")
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Author)) {
            return false;
        }

        Author other = (Author) obj;

        return Objects.equals(authorId, other.authorId)
                && Objects.equals(authorName, other.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, authorName);
    }

    @Override
    public String toString() {
        return "Author {" +
                "id = " + authorId +
                ", name = " + authorName +
                "}";
    }
}
