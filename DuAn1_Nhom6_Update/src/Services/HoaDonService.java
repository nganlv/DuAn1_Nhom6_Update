/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import DomainModels.HoaDon2;
import Repository.HoaDonRepo;
import Repository.Interface.IHoaDonRepo;
import Service.Interface.IHoaDonSer;
import ViewModels.QlHoaDon;
import ViewModels.QlHoaDon2;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class HoaDonService implements IHoaDonSer {

    private final IHoaDonRepo iHoaDonRepo = new HoaDonRepo();

    @Override
    public List<QlHoaDon2> getAllHds() {
        try {
            List<QlHoaDon2> listHd = new ArrayList<>();
            for (HoaDon2 hd : iHoaDonRepo.getAllHd()) {
                listHd.add(new QlHoaDon2(hd.getMaHd(), hd.getNgayTao(), hd.getNgayTT(), hd.getMaKh(), hd.getTenKh(),
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
    public List<QlHoaDon> getAllHd1s() {
        try {
            List<QlHoaDon> listHd = new ArrayList<>();
            for (HoaDon hd : iHoaDonRepo.getAllHd1()) {
                listHd.add(new QlHoaDon(hd.getIdHd(),hd.getIdCtsp(),hd.getMaHd(), hd.getMaSp(),hd.getNgayTao(), hd.getNgayTT(), hd.getMaKh(), hd.getTenKh(),hd.getTenNv(),hd.getDonGia(),
                        hd.getGiamGia(),hd.getTongTien(), hd.getTienKhachDua(), hd.getTienThua(), hd.getHinhThucBh(), hd.getHinhThucTT(),
                        hd.getTinhTrang(), hd.getGhiChu(), hd.getSoLuong()));
            }
            return listHd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<QlHoaDon> getAllHdcs(String ten) {
        try {
            List<QlHoaDon> listHd = new ArrayList<>();
            for (HoaDon hd : iHoaDonRepo.getAllHdc(ten)) {
                listHd.add(new QlHoaDon(hd.getIdHd(),hd.getIdCtsp(),hd.getMaHd(), hd.getMaSp(),hd.getNgayTao(), hd.getNgayTT(), hd.getMaKh(), hd.getTenKh(),hd.getTenNv(),hd.getDonGia(),
                       hd.getGiamGia(), hd.getTongTien(), hd.getTienKhachDua(), hd.getTienThua(), hd.getHinhThucBh(), hd.getHinhThucTT(),
                        hd.getTinhTrang(), hd.getGhiChu(), hd.getSoLuong()));
            }
            return listHd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<QlHoaDon2> timHds(Integer ma) {
        try {
            List<QlHoaDon2> listHd = new ArrayList<>();
            for (HoaDon2 hd : iHoaDonRepo.timHd(ma)) {
                listHd.add(new QlHoaDon2(hd.getMaHd(), hd.getNgayTao(), hd.getNgayTT(), hd.getMaKh(), hd.getTenKh(),
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
    public List<QlHoaDon2> locHdTheoTTs(String tt) {
        try {
            List<QlHoaDon2> listHd = new ArrayList<>();
            for (HoaDon2 hd : iHoaDonRepo.locHdTheoTT(tt)) {
                listHd.add(new QlHoaDon2(hd.getMaHd(), hd.getNgayTao(), hd.getNgayTT(), hd.getMaKh(), hd.getTenKh(),
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
    public List<QlHoaDon2> locHdTheoHTBHs(String htbh) {
        try {
            List<QlHoaDon2> listHd = new ArrayList<>();
            for (HoaDon2 hd : iHoaDonRepo.locHdTheoHTBH(htbh)) {
                listHd.add(new QlHoaDon2(hd.getMaHd(), hd.getNgayTao(), hd.getNgayTT(), hd.getMaKh(), hd.getTenKh(),
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
    public List<QlHoaDon2> locHdTheoHTTTs(String httt) {
        try {
            List<QlHoaDon2> listHd = new ArrayList<>();
            for (HoaDon2 hd : iHoaDonRepo.locHdTheoHTTT(httt)) {
                listHd.add(new QlHoaDon2(hd.getMaHd(), hd.getNgayTao(), hd.getNgayTT(), hd.getMaKh(), hd.getTenKh(),
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
    public Integer addHdcs(QlHoaDon hd){
        try {
            return iHoaDonRepo.addHdc(hd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Integer updateTTs(QlHoaDon hd){
        try {
            return iHoaDonRepo.updateTT(new HoaDon(hd.getIdHd(),hd.getIdCtsp(),hd.getMaHd(), hd.getMaSp(),hd.getNgayTao(), hd.getNgayTT(), hd.getMaKh(), hd.getTenKh(),hd.getTenNv(),hd.getDonGia(),
                       hd.getGiamGia(), hd.getTongTien(), hd.getTienKhachDua(), hd.getTienThua(), hd.getHinhThucBh(), hd.getHinhThucTT(),
                        hd.getTinhTrang(), hd.getGhiChu(), hd.getSoLuong()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Integer updateTT2s(QlHoaDon hd){
        try {
            return iHoaDonRepo.updateTT2(new HoaDon(hd.getIdHd(),hd.getIdCtsp(),hd.getMaHd(), hd.getMaSp(),hd.getNgayTao(), hd.getNgayTT(), hd.getMaKh(), hd.getTenKh(),hd.getTenNv(),hd.getDonGia(),
                       hd.getGiamGia(), hd.getTongTien(), hd.getTienKhachDua(), hd.getTienThua(), hd.getHinhThucBh(), hd.getHinhThucTT(),
                        hd.getTinhTrang(), hd.getGhiChu(), hd.getSoLuong()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Integer updateTKDs(QlHoaDon hd){
        try {
            return iHoaDonRepo.updateTKD(new HoaDon(hd.getIdHd(),hd.getIdCtsp(),hd.getMaHd(), hd.getMaSp(),hd.getNgayTao(), hd.getNgayTT(), hd.getMaKh(), hd.getTenKh(),hd.getTenNv(),hd.getDonGia(),
                       hd.getGiamGia(), hd.getTongTien(), hd.getTienKhachDua(), hd.getTienThua(), hd.getHinhThucBh(), hd.getHinhThucTT(),
                        hd.getTinhTrang(), hd.getGhiChu(), hd.getSoLuong()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Integer addHdcts(QlHoaDon hd){
        try {
            return iHoaDonRepo.addHdct(new HoaDon(hd.getIdHd(),hd.getIdCtsp(),hd.getMaHd(), hd.getMaSp(),hd.getNgayTao(), hd.getNgayTT(), hd.getMaKh(), hd.getTenKh(),hd.getTenNv(),hd.getDonGia(),
                       hd.getGiamGia(), hd.getTongTien(), hd.getTienKhachDua(), hd.getTienThua(), hd.getHinhThucBh(), hd.getHinhThucTT(),
                        hd.getTinhTrang(), hd.getGhiChu(), hd.getSoLuong()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
