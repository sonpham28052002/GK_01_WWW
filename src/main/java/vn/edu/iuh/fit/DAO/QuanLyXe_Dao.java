package vn.edu.iuh.fit.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.ConnectionDB.ConnectionDB;
import vn.edu.iuh.fit.entities.Xe;

import java.util.List;

public class QuanLyXe_Dao {
    private EntityManager entityManager ;

    public QuanLyXe_Dao() {
        entityManager = ConnectionDB.getConnectionDB().getManagerFactory().createEntityManager();
    }

    public boolean insertXe(Xe xe){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            entityManager.persist(xe);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public List<Xe> getAllXe(){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            List<Xe> ds= entityManager.createQuery("select xe from  Xe xe", Xe.class).getResultList();
            transaction.commit();
            return ds;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
}
