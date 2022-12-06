/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModels.TheLoai;
import ViewModels.QlSanPham;
import ViewModels.QlTheLoai;
import java.util.List;

/**
 *
 * @author levan
 */
public interface ITheLoaiSer {
    public List<QlTheLoai> getAllTls();
    public List<TheLoai> getAllTl();
    public Integer addTls(QlTheLoai tl);
    public Integer updateTls(QlTheLoai tl);
    public Integer deleteTls(String ma);
}
