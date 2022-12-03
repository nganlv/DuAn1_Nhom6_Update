/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModels.ChiTietSanPham;
import ViewModels.QlChiTietSanPham;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IChiTietSanPhamService {
    public List<QlChiTietSanPham> getAllCtsps();
    public List<ChiTietSanPham> timSps(String ma);
    public List<QlChiTietSanPham> locSpTheoTHs(String th);
    public List<QlChiTietSanPham> locSpTheoGTs(String gt);
    public List<QlChiTietSanPham> locSpTheoTTs(String tt);
    public List<QlChiTietSanPham> add(QlChiTietSanPham sp);
}
