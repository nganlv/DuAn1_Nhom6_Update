/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import java.util.*;
import ViewModels.QuanLyThongKe;


/**
 *
 * @author pc
 */
public interface IThongKeSV {
      List<QuanLyThongKe> getAll();
   
     List<QuanLyThongKe> tim(String ma);
      List<QuanLyThongKe> thang(String month); 
      List<QuanLyThongKe> nam(String year);
}
