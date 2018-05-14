package pl.sda.poznan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Program {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsersDB");
        EntityManager entityManager = factory.createEntityManager();
        //na tym etapie sa utworzone wszytskie tabele


        Message hello = new Message();
        hello.setText("Hello hibernate");
        hello.setDate(new Date());

        Message witam = new Message();
        witam.setText("witam");

        Adress homeAdress = new Adress();
        homeAdress.setCountry("Poland");
        homeAdress.setStreet("Jadwigi");

        ZipCode zipCode = new ZipCode();
        zipCode.setCity("Poznan");
        zipCode.setCode("62-000");

        //ustawienie referencji zagniezdzenia
        homeAdress.setZipCode(zipCode);

        //relacja one to one ze wspoldzielonym kluczem
        User appUser = new User();
        appUser.setEmail("witam@witam.com");
        appUser.setAdress(homeAdress);

        entityManager.getTransaction().begin();
        //persist na apuser aby uzyskac id
        entityManager.persist(appUser);
        //ustawiamy id na homeadress
        homeAdress.setId(appUser.getId());
        //utrwalamy homeadress
        entityManager.persist(homeAdress);


        //stareprzyklady
        //entityManager.persist(hello);
        //entityManager.persist(witam);
        //persist tylko na adrsie, bez zipcode
        //entityManager.persist(homeAdress);

        entityManager.getTransaction().commit();
    }
}
