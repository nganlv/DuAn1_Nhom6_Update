/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Service.Interface.IHoaDonChoService;
import DomainModels.HoaDonCho;
import Repository.HoaDonChoRepo;
import Repository.Interface.IHoaDonChoRepo;
import ViewModels.QlHoaDonCho;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class HoaDonChoService implements IHoaDonChoService{
    private final IHoaDonChoRepo iHoaDonChoRepo=new HoaDonChoRepo();
   
    @Override
    public List<QlHoaDonCho> getHd2s(String tenKh){
        try {
            List<QlHoaDonCho> listQlHd=new ArrayList<>();
            for(HoaDonCho hdc: iHoaDonChoRepo.getHd2(tenKh)){
                listQlHd.add(new QlHoaDonCho(hdc.getMaHd(), hdc.getNgayTao(), hdc.getTenNv(), hdc.getTenKh()));
            }
            return listQlHd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
