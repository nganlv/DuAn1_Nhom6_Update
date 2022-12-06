/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModels.SanPham;
import ViewModels.QlSanPham;
import java.util.List;

/**
 *
 * @author levan
 */
public interface ISanPhamSer {
    public List<QlSanPham> getAllSps();
    public List<SanPham> getAllSp();
    public Integer addSps(QlSanPham sp);
    public Integer updateSps(QlSanPham sp);
    public Integer deleteSps(String ma);
}
