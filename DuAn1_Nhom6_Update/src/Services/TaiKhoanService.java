/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.TaiKhoan1;
import Repository.TaiKhoanRepo1;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class TaiKhoanService {
    private final TaiKhoanRepo1 taiKhoanRepo=new TaiKhoanRepo1();
   
    public TaiKhoan1 getAllTks(String ten, String matKhau){
        try {
            return taiKhoanRepo.getAllTk(ten, matKhau);
        } catch (Exception e) {
            e.printStackTrace();          
        }   
        return null;
    }
}
