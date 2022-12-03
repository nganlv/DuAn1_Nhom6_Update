/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IHoaDonRepo {
    public List<HoaDon> getAllHd();
    public List<HoaDon> timHd(String ma);
    public List<HoaDon> locHdTheoTT(String tt);
    public List<HoaDon> locHdTheoHTBH(String htbh);
    public List<HoaDon> locHdTheoHTTT(String httt);
    public Integer updateTT(HoaDon hd);
    public Integer updateTT2(HoaDon hd);
    public Integer updateTKD(HoaDon hd);
}
