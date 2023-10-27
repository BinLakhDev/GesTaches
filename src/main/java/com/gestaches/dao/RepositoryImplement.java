package com.gestaches.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RepositoryImplement <T> implements Repository <T>{
    protected EntityManager em;

    public  RepositoryImplement() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gesTachesPU");
        em = emf.createEntityManager();
    }
    @Override
    public int add(T t) {
        int result=1;
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();

        return result;
    }
    @Override
    public int delete(int id,T t) {
        int result=1;

        String table=t.getClass().getSimpleName();
        t=(T) em.createQuery("SELECT t FROM " + table + " t WHERE t.id=:id").setParameter("id", id).getSingleResult();
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
        return result;
    }
    @Override
    public int update(T t) {
        int result=1;
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        return result;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll(T t) {
        String table=t.getClass().getSimpleName();
        return (List<T>) em.createQuery("SELECT t FROM " + table + " t").getResultList();


    }
    @SuppressWarnings("unchecked")
    @Override
    public T findById (int id,T t) {
        String table=t.getClass().getSimpleName();
        t=(T) em.createQuery("SELECT t FROM " + table + " t WHERE t.id=:id").setParameter("id", id).getSingleResult();
        return t;

    }
}
