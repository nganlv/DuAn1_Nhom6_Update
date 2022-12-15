/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModels.HoaDon;
import ViewModels.QlHoaDon;
import ViewModels.QlHoaDon2;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IHoaDonSer {
  public  List<QlHoaDon2> getAllHds();
  public  List<QlHoaDon> getAllHd1s();
  public  List<QlHoaDon> getAllHdcs(String ten);
  public  List<QlHoaDon2> timHds(Integer ma);
  public  List<QlHoaDon2> locHdTheoTTs(String tt);
  public  List<QlHoaDon2> locHdTheoHTBHs(String htbh);
  public  List<QlHoaDon2> locHdTheoHTTTs(String httt);
  public Integer addHdcs(QlHoaDon hd);
    public Integer updateTTs(QlHoaDon hd);
    public Integer updateTT2s(QlHoaDon hd);
    public Integer updateTKDs(QlHoaDon hd);
    public Integer addHdcts(QlHoaDon hd);
}
