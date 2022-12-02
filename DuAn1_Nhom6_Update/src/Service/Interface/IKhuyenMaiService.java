/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;
import ViewModels.QLKhuyenMai;
import java.util.*;
/**
 *
 * @author pc
 */
public interface IKhuyenMaiService {
       List<QLKhuyenMai> getAlls();
    void add(QLKhuyenMai sp);
    void update(QLKhuyenMai sp);
    void delete(String ma); 
}
