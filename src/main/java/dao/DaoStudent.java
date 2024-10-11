package dao;

import interfaces.IStudent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import models.Student;

import java.util.List;

public class DaoStudent implements IStudent {
    private EntityManager entityManager;

    public DaoStudent(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createNamedQuery("Student.findAll", Student.class);
        return query.getResultList();
    }

    @Override
    public Student findByEmail(String email) {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.email = :email", Student.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    @Override
    public void save(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Student student) {
        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Student student) {
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }
}

