package ru.home.service;

import ru.home.dao.GenreDAO;
import ru.home.entities.Genre;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.home.utils.HibernateUtil;

import java.util.List;

public class GenreService implements GenreDAO {
    @Override
    public void add(Genre genre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(genre);
        session.getTransaction().commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Genre> getAllOrNull() {
        String hql = "FROM Genre";
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery(hql);
        List<Genre> list = query.list();

        session.getTransaction().commit();
        session.close();

        return list;
    }

    @Override
    public Genre getByIdOrNull(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Genre genre = session.get(Genre.class, Integer.parseInt(id));

        session.getTransaction().commit();
        session.close();

        return genre;
    }

    @Override
    public void deleteById(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Genre genre = session.get(Genre.class, Integer.parseInt(id));
        session.delete(genre);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Genre genre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(genre);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Genre genre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(genre);
        session.getTransaction().commit();
        session.close();
    }
}
