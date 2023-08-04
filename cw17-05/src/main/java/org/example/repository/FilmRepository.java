package org.example.repository;

import org.example.connection.SessionFactorySingleton;
import org.example.entity.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.List;

public class FilmRepository {
    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public void save(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(film);
        session.getTransaction().commit();
        session.close();
    }

    public Film findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Film.class, id);
    }

    public List<Film> findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String findAllQuery = "select f from Film f";
        Query<Film> query = session.createQuery(findAllQuery, Film.class);
        List<Film> films = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return films;
    }

    public void update(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(film);
        session.getTransaction().commit();
        session.close();
    }

    public void remove(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.remove(film);
        session.getTransaction().commit();
        session.close();
    }

    public List<Film> findByDirector(String directorName) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String findByDirectorQuery = "from Film as f where f.directorName=:Director";
        Query<Film> filmQuery = session.createQuery(findByDirectorQuery, Film.class);
        filmQuery.setParameter("Director", directorName);
        List<Film> films = filmQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return films;
    }

    public List<Film> highRanked() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String highRankedFilms = "from Film as f where f.rating>=9";
        Query<Film> filmQuery = session.createQuery(highRankedFilms, Film.class);
        List<Film> films = filmQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return films;
    }

    public Film longestMovie(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "from Film f order by  f.length desc ";
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        Film longestFilm = (Film) query.getResultList();
        session.getTransaction().commit();
        session.close();
        return longestFilm;
    }

    public String DirectorNameOfLongestMovie(){
       Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "from Film f order by  f.length desc ";
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        List<Film> longestFilm = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return longestFilm.get(0).getDirectorName();
    }




}
