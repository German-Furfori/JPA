package org.example.configurations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtilDB {
    // Acá vamos a configurar la Factory, la llamamos en el arranque del programa y listo

    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory(); // Contruye un administrador de factorys ("fábricas de bases de datos")

    private static EntityManagerFactory buildEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("cursoAyiJPA"); // Acá puse lo que puse en el "name" de la etiqueta persistence-unit en el archivo persistence.xml
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}