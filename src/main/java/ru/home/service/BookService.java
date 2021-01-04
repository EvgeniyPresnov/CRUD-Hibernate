package ru.home.service;

import ru.home.dao.BookDAO;
import ru.home.entities.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.home.utils.HibernateUtil;

import java.util.List;
import java.util.Set;

public class BookService implements BookDAO {
    @Override
    public void add(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(Set<Book> books) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        for (Book book : books) {
            session.save(book);
        }

        session.getTransaction().commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> getAllOrNull() {
        String hql = "FROM Book";
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery(hql);
        List<Book> list = query.list();

        session.getTransaction().commit();
        session.close();

        return list;
    }

    @Override
    public Book getByIdOrNull(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Book book = session.get(Book.class, Integer.parseInt(id));

        session.getTransaction().commit();
        session.close();

        return book;
    }

    @Override
    public void deleteById(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Book book = session.get(Book.class, Integer.parseInt(id));
        session.delete(book);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(book);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(book);
        session.getTransaction().commit();
        session.close();
    }
}
