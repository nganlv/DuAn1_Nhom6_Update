/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDonChiTiet;
import DomainModels.HoaDonChiTiet2;
import Repository.HoaDonChiTietRepo;
import Repository.Interface.IHoaDonChiTietRepo;
import Repository.Interface.IHoaDonChoRepo;
import Service.Interface.IHoaDonChiTietSer;
import ViewModels.QlHoaDonChiTiet;
import ViewModels.QlHoaDonChiTiet2;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class HoaDonChiTietService implements IHoaDonChiTietSer{
    private final IHoaDonChiTietRepo iHoaDonChiTietRepo=(IHoaDonChiTietRepo) new HoaDonChiTietRepo();
    @Override
    public List<QlHoaDonChiTiet> getAllHdcts(String ten){
        try {
            List<QlHoaDonChiTiet> listHdct=new ArrayList<>();
            for(HoaDonChiTiet hdct:iHoaDonChiTietRepo.getAllHdct(ten)){
                listHdct.add(new QlHoaDonChiTiet(hdct.getMaSp(), hdct.getTenSp(), hdct.getDonGia(),hdct.getGiamGia(), hdct.getSoLuong(), hdct.getThanhTien()));
            }
            return listHdct;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<QlHoaDonChiTiet2> getAllHdct2s(Integer maHd){
        try {
            List<QlHoaDonChiTiet2> listHdct=new ArrayList<>();
            for(HoaDonChiTiet2 hdct:iHoaDonChiTietRepo.getAllHdct2(maHd)){
                listHdct.add(new QlHoaDonChiTiet2(hdct.getMaHd(),hdct.getMaSp(), hdct.getTenSp(), hdct.getDonGia(), hdct.getSoLuong(), hdct.getGiamGia(), hdct.getThanhTien()));
            }
            return listHdct;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Integer updateSls(QlHoaDonChiTiet hdct){
        try {
           return iHoaDonChiTietRepo.updateSl(new HoaDonChiTiet(hdct.getMaSp(), hdct.getTenSp(), hdct.getDonGia(),hdct.getGiamGia(), hdct.getSoLuong(), hdct.getThanhTien()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<QlHoaDonChiTiet> deletes(){
         try {
            List<QlHoaDonChiTiet> listHdct=new ArrayList<>();
            for(HoaDonChiTiet hdct:iHoaDonChiTietRepo.delete()){
                listHdct.add(new QlHoaDonChiTiet(hdct.getMaSp(), hdct.getTenSp(), hdct.getDonGia(),hdct.getGiamGia(), hdct.getSoLuong(), hdct.getThanhTien()));
            }
            return listHdct;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
