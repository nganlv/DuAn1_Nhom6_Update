/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import Service.Interface.*;
import java.util.*;
import DomainModels.ThongKe;


/**
 *
 * @author pc
 */
public interface IThongKeRepo {
      List<ThongKe> getAll();
   
     List<ThongKe> tim(String ma);
      List<ThongKe> thang(String month); 
      List<ThongKe> nam(String year);
}
