/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;
import ViewModels.QlKhuyenMai;
import java.util.*;
/**
 *
 * @author pc
 */
public interface IKhuyenMaiService {
       List<QlKhuyenMai> getAlls();
    void add(QlKhuyenMai sp);
    void update(QlKhuyenMai sp);
    void delete(String ma); 
}
