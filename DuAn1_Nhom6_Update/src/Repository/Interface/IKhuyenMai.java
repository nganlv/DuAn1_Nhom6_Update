/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;
import java.util.*;
import DomainModels.KhuyenMai;

/**
 *
 * @author pc
 */
public interface IKhuyenMai {
    List<KhuyenMai> getAll();
    boolean addDongSp(KhuyenMai sp);
    boolean updateSp(KhuyenMai sp);
    boolean deleteSp(String ma);
    
}
