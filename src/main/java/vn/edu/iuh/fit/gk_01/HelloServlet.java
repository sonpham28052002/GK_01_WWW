package vn.edu.iuh.fit.gk_01;

import java.io.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.iuh.fit.ConnectionDB.ConnectionDB;
import vn.edu.iuh.fit.DAO.QuanLyLoaiXe_DAO;
import vn.edu.iuh.fit.DAO.QuanLyXe_Dao;
import vn.edu.iuh.fit.entities.Xe;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private QuanLyLoaiXe_DAO quanLyLoaiXeDao = new QuanLyLoaiXe_DAO();

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String action = request.getParameter("action");
         if (request.getParameter("themxe")!=null) {
            themXeMoi(request,response);
         } else if (request.getParameter("danhsachxetheoloai")!=null) {
            long maLoai = Long.parseLong(request.getParameter("maLoai"));
            request.setAttribute("dsxe", quanLyLoaiXeDao.getAllXe(maLoai));
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request,response);
         }

    }

    public void themSanPham(HttpServletRequest request, HttpServletResponse response){

    }
    public void danhSachLoaiXe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsLoaiXe", quanLyLoaiXeDao.getLoaiXe());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dsLoai.jsp");
        dispatcher.forward(request,response);
    }
    public void themXeMoi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        double gia = Double.parseDouble(request.getParameter("gia"));
        int nam = Integer.parseInt(request.getParameter("nam"));
        long loai = Long.parseLong(request.getParameter("loai"));
        Xe xe = new Xe();
        xe.setTenXe(ten);
        xe.setGia(gia);
        xe.setNamSX(nam);
        xe.setLoaiXe(quanLyLoaiXeDao.findOne(loai));
        QuanLyXe_Dao quanLyXeDao = new QuanLyXe_Dao();
        quanLyXeDao.insertXe(xe);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request,response);

    }

}