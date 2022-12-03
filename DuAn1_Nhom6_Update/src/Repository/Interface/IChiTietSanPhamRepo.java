/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.ChiTietSanPham;
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
     public List<QlChiTietSanPham> addsp(QlChiTietSanPham sp);
}
