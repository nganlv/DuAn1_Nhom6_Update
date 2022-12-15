/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import DomainModels.*;

/**
 *
 * @author pc
 */
public class QlKhuyenMai {
  String id,ma,ten,NgayBD,NgayKT,Giagia;

    public QlKhuyenMai() {
    }

    public QlKhuyenMai(String id, String ma, String ten, String NgayBD, String NgayKT, String Giagia) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.Giagia = Giagia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
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

  @Override
  public String toString(){
      return Giagia;
  }
}
