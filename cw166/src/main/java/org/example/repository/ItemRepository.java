package org.example.repository;


import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.connection.SessionFactorySingleton;
import org.example.entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ItemRepository {

    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public void save (Item item) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(item);
        session.getTransaction().commit();
        session.close();
    }

    public List<Item> findAll () {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Item> cr = cb.createQuery(Item.class);
        Root<Item> root = cr.from(Item.class);
        cr.select(root);
        Query query = session.createQuery(cr);
        List<Item> results = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return results;
    }

    public List<Item> greaterThan (Integer price) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Item> cr = cb.createQuery(Item.class);
        Root<Item> root = cr.from(Item.class);
        cr.select(root).where(cb.gt(root.<Number>get("itemPrice"), price));
        Query query = session.createQuery(cr);
        List<Item> results = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return results;
    }

    public List<Item> lessThan (Integer price) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Item> cr = cb.createQuery(Item.class);
        Root<Item> root = cr.from(Item.class);
        cr.select(root).where(cb.lt(root.<Integer>get("itemPrice"), price));
        Query query = session.createQuery(cr);
        List<Item> results = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return results;
    }

    public List<Item> findItemType (String itemType) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Item> cr = cb.createQuery(Item.class);
        Root<Item> root = cr.from(Item.class);
        cr.select(root).where(cb.like(root.<String>get("itemName"), itemType));
        Query query = session.createQuery(cr);
        List<Item> results = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return results;
    }

    public List<Item> between (Integer lPrice, Integer hPrice) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Item> cr = cb.createQuery(Item.class);
        Root<Item> root = cr.from(Item.class);
        cr.select(root).where(cb.between(root.<Integer>get("itemPrice"), lPrice, hPrice));
        Query query = session.createQuery(cr);
        List<Item> results = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return results;
    }

    public List<Item> specificItems (List<String> names) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Item> cr = cb.createQuery(Item.class);
        Root<Item> root = cr.from(Item.class);
        cr.select(root).where(root.get("itemName").in(names));
        Query query = session.createQuery(cr);
        List<Item> results = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return results;
    }

    public List<Item> isNotNull () {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Item> cr = cb.createQuery(Item.class);
        Root<Item> root = cr.from(Item.class);
//        cr.select(root).where(cb.isNull(root.get("itemDescription")));
        cr.select(root).where(cb.isNotNull(root.get("itemDescription")));
        Query query = session.createQuery(cr);
        List<Item> results = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return results;
    }

}
