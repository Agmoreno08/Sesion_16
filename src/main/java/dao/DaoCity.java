package dao;

import interfaces.ICity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import models.City;

import java.util.List;

public class DaoCity implements ICity {
    private EntityManager entityManager;

    public DaoCity(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<City> findAll() {
        TypedQuery<City> query = entityManager.createNamedQuery("City.findAll", City.class);
        return query.getResultList();
    }

    @Override
    public City findByName(String name) {
        TypedQuery<City> query = entityManager.createQuery("SELECT c FROM City c WHERE c.name = :name", City.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public void save(City city) {
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(City city) {
        entityManager.getTransaction().begin();
        entityManager.merge(city);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(City city) {
        entityManager.getTransaction().begin();
        entityManager.remove(city);
        entityManager.getTransaction().commit();
    }
}

