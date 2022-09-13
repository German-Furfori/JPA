package org.example;

import jakarta.persistence.EntityManager;
import org.example.configurations.JpaUtilDB;
import org.example.entities.Cliente;
import org.example.entities.Direccion;

import java.util.List;

public class HibernateAsociacionesOneToMany {
    public static void main(String[] args) {
        EntityManager em = JpaUtilDB.getEntityManager();

        try {
            em.getTransaction().begin();

            Cliente cliente = new Cliente("Germán", "Furfori");
            cliente.setFormaPago("Tarjeta");

            Direccion direccion1 = new Direccion("Buenos Aires", 938);
            Direccion direccion2 = new Direccion("Olivos", 123);

            cliente.setDirecciones(List.of(direccion1, direccion2));

            em.persist(cliente);

            em.getTransaction().commit();

            System.out.println(cliente);

            cliente = em.find(Cliente.class, cliente.getId());

            System.out.println("Cliente desde DB: " + cliente);
        } catch(Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
