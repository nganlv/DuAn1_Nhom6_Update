/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.ChiTietSanPham;
import DomainModels.NhanVien;
import ViewModels.QlChiTietSanPham;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IChiTietSanPhamRepo {
    public List<ChiTietSanPham> getAllCtsp();
    public List<QlChiTietSanPham> getAllCtsps();
    public List<ChiTietSanPham> timSp(String ma);
    public List<QlChiTietSanPham> timSps(String ma);
    public List<ChiTietSanPham> locSpTheoTH(String th);
    public List<ChiTietSanPham> locSpTheoGT(String gt);
    public List<ChiTietSanPham> locSpTheoTT(String tt);
     public List<ChiTietSanPham> addsp(ChiTietSanPham sp);
     public List<QlChiTietSanPham> addsps(QlChiTietSanPham sp);
      public String updates(ChiTietSanPham sp);
      public String updatess(QlChiTietSanPham sp);
      String delete(String masp);
}
