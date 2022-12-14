/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModels.NhanVien;
import ViewModels.QuanLyNhanVien;
import java.util.List;

/**
 *
 * @author nguye
 */
public interface QLNhanVien {

    List<QuanLyNhanVien> getAll();
     String add(NhanVien nv);
     String update(NhanVien nv);
      String delete(String maNV);
       Boolean checkMa(String maNV);
       List<QuanLyNhanVien> getTims(String ma);

//       List<QuanLyNhanVien> getTimTens(String ten);
       List<QuanLyNhanVien> getLOCs(String cv);
       List<QuanLyNhanVien> getLOCGTs(String GT);
       List<QuanLyNhanVien> getLOCTT(String TT);


       List<QuanLyNhanVien> getTimTens(String ten);
}

