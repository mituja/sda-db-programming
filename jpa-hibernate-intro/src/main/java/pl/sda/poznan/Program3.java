package pl.sda.poznan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program3 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsersDB");
        EntityManager entityManager = factory.createEntityManager();

        Category category = new Category();
        category.setName("Laptops");

        Product sony = new Product();
        sony.setName("Sony");

        Product hp = new Product();
        hp.setName("HP");

        Product dell = new Product();
        dell.setName("DELL");

        sony.setCategory(category);
        hp.setCategory(category);
        dell.setCategory(category);

        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.persist(sony);
        entityManager.persist(hp);
        entityManager.persist(dell);

        entityManager.getTransaction().commit();
    }
}
