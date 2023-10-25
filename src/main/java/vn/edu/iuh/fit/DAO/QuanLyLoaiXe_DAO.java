package vn.edu.iuh.fit.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.ConnectionDB.ConnectionDB;
import vn.edu.iuh.fit.entities.LoaiXe;
import vn.edu.iuh.fit.entities.Xe;

import java.util.List;

public class QuanLyLoaiXe_DAO {
    private final EntityManager entityManager ;

    public QuanLyLoaiXe_DAO() {
        this.entityManager = ConnectionDB.getConnectionDB().getManagerFactory().createEntityManager();
    }

    public boolean insertXe(LoaiXe loaiXe){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(loaiXe);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public List<LoaiXe> getLoaiXe(){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            List<LoaiXe> DS=entityManager.createQuery("select lx from LoaiXe lx", LoaiXe.class).getResultList();
            transaction.commit();
            return DS;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return null;
    }

    public List<Xe> getAllXe(long maLoai){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
             List<Xe> ds= entityManager.createQuery("select xe from  Xe xe where xe.loaiXe.maLoai = "+maLoai, Xe.class).getResultList();
             transaction.commit();
             return ds;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
    public List<LoaiXe> getAll(){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
             List<LoaiXe> ds= entityManager.createQuery("select xe from  LoaiXe xe", LoaiXe.class).getResultList();
             transaction.commit();
             return ds;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
    public LoaiXe findOne(long id){
        return entityManager.find(LoaiXe.class,id);
    }

}
