
import dao.DaoCity;
import dao.DaoStudent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import models.City;
import models.Student;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Configura el EntityManagerFactory y el EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sesion16");
        EntityManager em = emf.createEntityManager();

        // Instancia los DAO
        DaoStudent studentDao = new DaoStudent(em);
        DaoCity cityDao = new DaoCity(em);

        // Crear y guardar un nuevo Student
        Student student = new Student();
        student.setName("jdoe");
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("jdoe@example.com");

        studentDao.save(student);

        // Buscar y mostrar todos los estudiantes
        List<Student> students = studentDao.findAll();
        students.forEach(System.out::println);

        // Actualizar un Student
        student.setFirstName("Johnny");
        studentDao.update(student);

        // Eliminar un Student
        studentDao.delete(student);

        // Crear y guardar una nueva City
        City city = new City();
        city.setName("New York");
        city.setActive(true);

        cityDao.save(city);

        // Buscar y mostrar todas las ciudades
        List<City> cities = cityDao.findAll();
        cities.forEach(System.out::println);

        // Actualizar una City
        city.setName("New York City");
        cityDao.update(city);

        // Eliminar una City
        cityDao.delete(city);

        // Cerrar EntityManager y EntityManagerFactory
        em.close();
        emf.close();
    }
}

