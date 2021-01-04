package ru.home.service;

import ru.home.dao.AuthorDAO;
import ru.home.entities.Author;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.home.utils.HibernateUtil;

import java.util.List;

public class AuthorService implements AuthorDAO {
    @Override
    public void add(Author author) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Author> getAllOrNull() {
        String hql = "FROM Author";
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery(hql);
        List<Author> list = query.list();

        session.getTransaction().commit();
        session.close();

        return  list;
    }

    @Override
    public Author getByIdOrNull(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Author author = session.get(Author.class, Integer.parseInt(id));

        session.getTransaction().commit();
        session.close();

        return author;
    }

    @Override
    public void deleteById(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Author author = session.get(Author.class, Integer.parseInt(id));
        session.delete(author);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Author author) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(author);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Author author) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(author);
        session.getTransaction().commit();
        session.close();
    }
}
