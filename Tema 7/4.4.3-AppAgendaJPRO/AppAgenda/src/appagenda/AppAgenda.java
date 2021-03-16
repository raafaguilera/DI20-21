/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appagenda;

import static entidades.Persona_.provincia;
import entidades.Provincia;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Rafa
 */
public class AppAgenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Map<String, String> emfProperties = new HashMap<String, String>();
        emfProperties.put("javax.persistence.schemageneration.database.action", "create");
        emfProperties.put("javax.persistence.jdbc.url", "jdbc:derby:BDAgenda;create=true");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppAgendaPU", emfProperties);
        EntityManager em = emf.createEntityManager();

        Query queryProvinciaCadiz = em.createNamedQuery("Provincia.findByNombre");
        queryProvinciaCadiz.setParameter("nombre", "Cádiz");
        List<Provincia> listProvinciasCadiz = queryProvinciaCadiz.getResultList();
        em.getTransaction().begin();
        for (Provincia provinciaCadiz : listProvinciasCadiz) {
            provinciaCadiz.setCodigo("CC");
            em.merge(provinciaCadiz);
        }
        
        em.getTransaction().commit();
        em.close();
        emf.close();
        try {
            DriverManager.getConnection("jdbc:derby:BDAgenda;shutdown=true");
        } catch (SQLException ex) {
        }

    }

}
