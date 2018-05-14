package pl.sda.poznan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program2 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsersDB");
        EntityManager entityManager = factory.createEntityManager();

        //encja 1
        User user = new User();
        user.setEmail("kowalski@wp.pl");

        //encja 2
        Adress adress = new Adress();
        adress.setCountry("poland");
        Adress anotherAdress = new Adress();
        anotherAdress.setStreet("witam");

        //powiazania
        user.setAdress(anotherAdress);
        adress.setUser(user);

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.persist(adress);
        entityManager.persist(anotherAdress);

        entityManager.getTransaction().commit();
    }
}
