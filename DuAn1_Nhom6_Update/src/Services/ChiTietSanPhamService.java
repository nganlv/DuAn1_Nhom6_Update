/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Service.Interface.IChiTietSanPhamService;
import DomainModels.ChiTietSanPham;
import Repository.ChiTietSanPhamRepo;
import Repository.Interface.IChiTietSanPhamRepo;
import ViewModels.QlChiTietSanPham;
import ViewModels.QuanLyNhanVien;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author levan
 */
public class ChiTietSanPhamService implements IChiTietSanPhamService {

    private final IChiTietSanPhamRepo iChiTietSanPhamRepo = (IChiTietSanPhamRepo) new ChiTietSanPhamRepo();

    @Override
    public List<QlChiTietSanPham> getAllCtsps() {
        try {
            List<QlChiTietSanPham> listCtsp = new ArrayList<>();
            for (QlChiTietSanPham ctsp : iChiTietSanPhamRepo.getAllCtsps()) {
                listCtsp.add(new QlChiTietSanPham(ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                        ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
                        ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                        ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.getTinhTrang()));
            }
            return listCtsp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ChiTietSanPham> timSps(String ma) {
        try {
            List<ChiTietSanPham> timSp = new ArrayList<>();
            for (QlChiTietSanPham ctsp : iChiTietSanPhamRepo.timSps(ma)) {
                timSp.add(new ChiTietSanPham(ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                        ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
                        ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                        ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.getTinhTrang()));
            }
            return timSp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<QlChiTietSanPham> locSpTheoTHs(String th) {
        try {
            List<QlChiTietSanPham> listSp = new ArrayList<>();
            for (ChiTietSanPham ctsp : iChiTietSanPhamRepo.locSpTheoTH(th)) {
                listSp.add(new QlChiTietSanPham(ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                        ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
                        ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                        ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.getTinhTrang()));
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<QlChiTietSanPham> locSpTheoGTs(String gt) {
        try {
            List<QlChiTietSanPham> listSp = new ArrayList<>();
            for (ChiTietSanPham ctsp : iChiTietSanPhamRepo.locSpTheoGT(gt)) {
                listSp.add(new QlChiTietSanPham(ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                        ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
                        ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                        ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.getTinhTrang()));
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<QlChiTietSanPham> locSpTheoTTs(String tt) {
        try {
            List<QlChiTietSanPham> listSp = new ArrayList<>();
            for (ChiTietSanPham ctsp : iChiTietSanPhamRepo.locSpTheoTT(tt)) {
                listSp.add(new QlChiTietSanPham(ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                        ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
                        ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                        ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.getTinhTrang()));
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ChiTietSanPham> add(ChiTietSanPham sp) {
        return iChiTietSanPhamRepo.addsp(sp);
    }
     @Override
    public List<QlChiTietSanPham> adds(QlChiTietSanPham sp) {
        return iChiTietSanPhamRepo.addsps(sp);
    }

    @Override
     public String update(ChiTietSanPham sp) {
return  iChiTietSanPhamRepo.updates(sp);
    } 
     
    @Override
     public String updates(QlChiTietSanPham sp) {
return  iChiTietSanPhamRepo.updatess(sp);
    } 

    @Override
    public String deleteThs(String maNV) {
       return  iChiTietSanPhamRepo.delete(maNV);
    }     

    @Override
    public Boolean checkMa(String maSp) {
List<QlChiTietSanPham> listNV = iChiTietSanPhamRepo.getAllCtsps();
        for (QlChiTietSanPham nv : listNV) {
            if(nv.getMa().equalsIgnoreCase(maSp)){
                return true;
            }
        } 
        return false;
    }
     @Override
    public Boolean checkMas(String maSp) {
List<ChiTietSanPham> listNV = iChiTietSanPhamRepo.getAllCtsp();
        for (ChiTietSanPham nv : listNV) {
            if(nv.getMa().equalsIgnoreCase(maSp)){
                return true;
            }
        } 
        return false;
    }
}
