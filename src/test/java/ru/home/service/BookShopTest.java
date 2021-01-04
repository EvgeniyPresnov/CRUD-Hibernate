package ru.home.service;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;
import ru.home.dao.FactoryDAO;
import ru.home.entities.Book;
import ru.home.entities.Shop;
import ru.home.service.categories.ManyToManyMapping;

import java.util.HashSet;
import java.util.Set;

@Category({ManyToManyMapping.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookShopTest {

    @Test
    public void addBooksAndShopsFirstTest() {
        Book book1 = new Book();
        book1.setTitle("Dune");
        book1.setPages(1031);

        Book book2 = new Book();
        book2.setTitle("Dune Messiah");
        book2.setPages(1045);

        Book book3 = new Book();
        book3.setTitle("Children of Dune");
        book3.setPages(1066);

        Shop shop1 = new Shop();
        shop1.setCity("Venice");
        shop1.setCountry("Italy");
        shop1.setName("Libreria Acqua Alta");
        shop1.setPrice(13.12);
        FactoryDAO.getShopDAO().add(shop1);

        Shop shop2 = new Shop();
        shop2.setCity("London");
        shop2.setCountry("UK");
        shop2.setName("Hatchard’s");
        shop2.setPrice(15.02);
        FactoryDAO.getShopDAO().add(shop2);

        Set<Shop> shops = new HashSet<>();
        shops.add(shop1);
        shops.add(shop2);

        book1.setShops(shops);
        FactoryDAO.getBookDAO().add(book1);

        Assert.assertFalse(FactoryDAO.getBookDAO().getAllOrNull().isEmpty());
        Assert.assertFalse(FactoryDAO.getShopDAO().getAllOrNull().isEmpty());
    }

    @Test
    public void addBooksAndShopsSecondTest() {
        Book book1 = new Book();
        book1.setTitle("The Da Vinci Code");
        book1.setPages(654);

        Book book2 = new Book();
        book2.setTitle("Angels and Demons");
        book2.setPages(731);

        Shop shop1 = new Shop();
        shop1.setName("City Lights");
        shop1.setCity("San Francisco");
        shop1.setCountry("USA");
        shop1.setPrice(10.12);
        FactoryDAO.getShopDAO().add(shop1);

        Shop shop2 = new Shop();
        shop2.setName("Livraria Lello");
        shop2.setCity("Porto");
        shop2.setCountry("Portugal");
        shop2.setPrice(13.02);
        FactoryDAO.getShopDAO().add(shop2);

        Shop shop3 = new Shop();
        shop3.setName("Book and Bed");
        shop3.setCity("Tokyo");
        shop3.setCountry("Japan");
        shop3.setPrice(12.43);
        FactoryDAO.getShopDAO().add(shop3);

        Set<Shop> shops = new HashSet<>();
        shops.add(shop1);
        shops.add(shop2);
        shops.add(shop3);

        book1.setShops(shops);
        book2.setShops(shops);
        FactoryDAO.getBookDAO().add(book1);
        FactoryDAO.getBookDAO().add(book2);

        Assert.assertFalse(FactoryDAO.getBookDAO().getAllOrNull().isEmpty());
        Assert.assertFalse(FactoryDAO.getShopDAO().getAllOrNull().isEmpty());
    }

    @Test
    public void updateShopTest() {
        Shop expectedShop = FactoryDAO.getShopDAO().getByIdOrNull("1");
        Shop actualShop =  FactoryDAO.getShopDAO().getByIdOrNull("1");
        actualShop.setCity("Buenos Aires");
        actualShop.setCountry("Argentina");
        actualShop.setName("El Ateneo Grand Splendid");
        FactoryDAO.getShopDAO().update(actualShop);

        Assert.assertNotEquals(expectedShop, actualShop);
    }

    @Test
    public void getAllShopsTest() {
        Assert.assertNotNull(FactoryDAO.getShopDAO().getAllOrNull());
        Assert.assertTrue(FactoryDAO.getShopDAO().getAllOrNull().size() > 0);
        Assert.assertFalse(FactoryDAO.getShopDAO().getAllOrNull().isEmpty());
    }

    @Test
    public void deleteShopsTest() {
        Shop shop = FactoryDAO.getShopDAO().getByIdOrNull("5");
        FactoryDAO.getShopDAO().delete(shop);

        Assert.assertFalse(FactoryDAO.getShopDAO().getAllOrNull().isEmpty());
    }
}
