package ru.home.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "shop")
public class Shop implements Serializable {
    private static final long serialVersionUID = 1L;
    private int shopId;
    private String name;
    private String country;
    private String city;
    private double price;
    private Set<Book> books = new HashSet<>();

    public Shop() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @ManyToMany(mappedBy = "shops", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
        if (!(obj instanceof Shop)) {
            return false;
        }

        Shop other = (Shop) obj;

        return Objects.equals(shopId, other.shopId)
                && Objects.equals(name, other.name)
                && Objects.equals(country, other.country)
                && Objects.equals(city, other.city)
                && Objects.equals(price, other.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopId, name, country, city, price);
    }

    @Override
    public String toString() {
        return "Shop {" +
                "id = " + shopId +
                ", name = " + name +
                ", country = " + country +
                ", city = " + city +
                ", book's price = " + price +
                "}";
    }
}
