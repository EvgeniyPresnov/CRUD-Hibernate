package ru.home.service;

import ru.home.dao.ShopDAO;
import ru.home.entities.Shop;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.home.utils.HibernateUtil;

import java.util.List;

public class ShopService implements ShopDAO {
    @Override
    public void add(Shop shop) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(shop);
        session.getTransaction().commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Shop> getAllOrNull() {
        String hql = "FROM Shop";
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery(hql);
        List<Shop> list = query.list();

        session.getTransaction().commit();
        session.close();

        return list;
    }

    @Override
    public Shop getByIdOrNull(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Shop shop = session.get(Shop.class, Integer.parseInt(id));

        session.getTransaction().commit();
        session.close();

        return shop;
    }

    @Override
    public void deleteById(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Shop shop = session.get(Shop.class, Integer.parseInt(id));
        session.delete(shop);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Shop shop) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(shop);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Shop shop) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(shop);
        session.getTransaction().commit();
        session.close();
    }
}
