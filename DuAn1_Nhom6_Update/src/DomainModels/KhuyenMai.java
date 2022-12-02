/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author pc
 */
public class KhuyenMai {
  String Ma,ten,NgayBD,NgayKT,Giagia;

    public KhuyenMai() {
    }

    public KhuyenMai(String Ma, String ten, String NgayBD, String NgayKT, String Giagia) {
        this.Ma = Ma;
        this.ten = ten;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.Giagia = Giagia;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(String NgayBD) {
        this.NgayBD = NgayBD;
    }

    public String getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(String NgayKT) {
        this.NgayKT = NgayKT;
    }

    public String getGiagia() {
        return Giagia;
    }

    public void setGiagia(String Giagia) {
        this.Giagia = Giagia;
    }
  
}
