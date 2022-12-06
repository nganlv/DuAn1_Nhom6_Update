/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModels.ThuongHieu;
import ViewModels.QlThuongHieu;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IThuongHieuSer {
    public List<QlThuongHieu> getAllThs();
    public List<ThuongHieu> getAllTh();
    public Integer addThs(QlThuongHieu th);
    public Integer updateThs(QlThuongHieu th);
    public Integer deleteThs(String ma);
}
