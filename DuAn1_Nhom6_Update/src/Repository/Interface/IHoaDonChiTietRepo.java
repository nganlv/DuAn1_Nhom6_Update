/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.HoaDonChiTiet;
import DomainModels.HoaDonChiTiet2;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IHoaDonChiTietRepo {
    public List<HoaDonChiTiet> getAllHdct(String ten);
    public List<HoaDonChiTiet2> getAllHdct2(Integer maHd );
    public Integer updateSl(HoaDonChiTiet hdct);
    public List<HoaDonChiTiet> delete();
}
