/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import Repository.HoaDonRepo;
import Repository.Interface.IHoaDonRepo;
import Service.Interface.IHoaDonSer;
import ViewModels.QlHoaDon;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class HoaDonService implements IHoaDonSer {

    private final IHoaDonRepo iHoaDonRepo = new HoaDonRepo();

    @Override
    public List<QlHoaDon> getAllHds() {
        try {
            List<QlHoaDon> listHd = new ArrayList<>();
            for (HoaDon hd : iHoaDonRepo.getAllHd()) {
                listHd.add(new QlHoaDon(hd.getMaHd(), hd.getNgayTao(), hd.getNgayTT(), hd.getMaKh(), hd.getTenKh(),hd.getDonGia(),
                        hd.getTongTien(), hd.getTienKhachDua(), hd.getTienThua(), hd.getHinhThucBh(), hd.getHinhThucTT(),
                        hd.getTinhTrang(), hd.getGhiChu()));
            }
            return listHd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Integer updateTTs(QlHoaDon hd){
        try {
            return iHoaDonRepo.updateTT(new HoaDon(hd.getMaHd(), hd.getNgayTao(), hd.getNgayTT(), hd.getMaKh(), hd.getTenKh(),hd.getDonGia(),
                        hd.getTongTien(), hd.getTienKhachDua(), hd.getTienThua(), hd.getHinhThucBh(), hd.getHinhThucTT(),
                        hd.getTinhTrang(), hd.getGhiChu()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Integer updateTT2s(QlHoaDon hd){
        try {
            return iHoaDonRepo.updateTT2(new HoaDon(hd.getMaHd(), hd.getNgayTao(), hd.getNgayTT(), hd.getMaKh(), hd.getTenKh(),hd.getDonGia(),
                        hd.getTongTien(), hd.getTienKhachDua(), hd.getTienThua(), hd.getHinhThucBh(), hd.getHinhThucTT(),
                        hd.getTinhTrang(), hd.getGhiChu()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Integer updateTKDs(QlHoaDon hd){
        try {
            return iHoaDonRepo.updateTKD(new HoaDon(hd.getMaHd(), hd.getNgayTao(), hd.getNgayTT(), hd.getMaKh(), hd.getTenKh(),hd.getDonGia(),
                        hd.getTongTien(), hd.getTienKhachDua(), hd.getTienThua(), hd.getHinhThucBh(), hd.getHinhThucTT(),
                        hd.getTinhTrang(), hd.getGhiChu()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
