package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Xe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maXe;
    private String tenXe;
    private double gia;
    private int namSX;
    @ManyToOne
    @JoinColumn(name = "maLoai")
    private LoaiXe loaiXe;

    public Xe() {
    }

    public Xe(long maXe, String tenXe, double gia, int namSX, LoaiXe loaiXe) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.gia = gia;
        this.namSX = namSX;
        this.loaiXe = loaiXe;
    }

    public long getMaXe() {
        return maXe;
    }

    public void setMaXe(long maXe) {
        this.maXe = maXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public LoaiXe getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(LoaiXe loaiXe) {
        this.loaiXe = loaiXe;
    }

    @Override
    public String toString() {
        return "Xe{" +
                "maXe=" + maXe +
                ", tenXe='" + tenXe + '\'' +
                ", gia=" + gia +
                ", namSX=" + namSX +
                ", loaiXe=" + loaiXe +
                '}';
    }
}
