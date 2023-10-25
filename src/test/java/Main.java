import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.ConnectionDB.ConnectionDB;
import vn.edu.iuh.fit.DAO.QuanLyLoaiXe_DAO;

public class Main {
    public static void main(String[] args) {
        QuanLyLoaiXe_DAO quanLyLoaiXeDao = new QuanLyLoaiXe_DAO();
        System.out.println(quanLyLoaiXeDao.getAllXe(1));
    }
}
