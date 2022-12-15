/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.HoaDon;
import DomainModels.HoaDon2;
import DomainModels.HoaDonChiTiet;
import ViewModels.QlHoaDon;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IHoaDonRepo {
    public List<HoaDon2> getAllHd();
    public List<HoaDon> getAllHd1();
    public List<HoaDon> getAllHdc(String ten);
    public Integer addHdc(QlHoaDon hd);
    public List<HoaDon2> timHd(Integer ma);
    public List<HoaDon2> locHdTheoTT(String tt);
    public List<HoaDon2> locHdTheoHTBH(String htbh);
    public List<HoaDon2> locHdTheoHTTT(String httt);
    public Integer updateTT(HoaDon hd);
    public Integer updateTT2(HoaDon hd);
    public Integer updateTKD(HoaDon hd);
    public Integer addHdct(HoaDon hd);
}
