/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModels.HoaDon;
import ViewModels.QlHoaDon;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IHoaDonSer {
  public  List<QlHoaDon> getAllHds();
    public Integer updateTTs(QlHoaDon hd);
    public Integer updateTT2s(QlHoaDon hd);
    public Integer updateTKDs(QlHoaDon hd);
}
