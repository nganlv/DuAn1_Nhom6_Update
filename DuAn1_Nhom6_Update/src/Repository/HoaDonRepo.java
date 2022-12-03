/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import Repository.Interface.IHoaDonRepo;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class HoaDonRepo implements IHoaDonRepo {

    @Override
    public List<HoaDon> getAllHd() {
        try {
            List<HoaDon> listHd = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select HoaDon.Ma as MaHd, HoaDon.NgayTao, HoaDon.NgayThanhToan, KhachHang.Ma as MaKh, KhachHang.HoTen as TenKh, \n"
                    + " (HoaDonChiTiet.DonGia-KhuyenMai.GiamGia)*HoaDonChiTiet.SoLuong as TongTien, \n"
                    + " HoaDonChiTiet.TienKhachDua, HoaDonChiTiet.TienKhachDua-((HoaDonChiTiet.DonGia-KhuyenMai.GiamGia)*HoaDonChiTiet.SoLuong) as TienThua, \n"
                    + " HoaDon.HinhThucBH, HoaDon.HinhThucTT, HoaDon.TinhTrang, HoaDon.GhiChu from HoaDon\n"
                    + " join HoaDonChiTiet on HoaDon.Id=HoaDonChiTiet.IdHoaDon\n"
                    + " join ChiTietSP on HoaDonChiTiet.IdChiTietSP=ChiTietSP.Id\n"
                    + " join KhuyenMai on ChiTietSP.IdKm=KhuyenMai.Id\n"
                    + " join KhachHang on HoaDon.IdKH=KhachHang.Id";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                HoaDon hd=new HoaDon();
                hd.setMaHd(rs.getString("MaHd"));
                hd.setNgayTao(rs.getString("NgayTao"));
                hd.setNgayTT(rs.getString("NgayThanhToan"));
                hd.setMaKh(rs.getString("MaKh"));
                hd.setTenKh(rs.getString("TenKh"));
                hd.setTongTien(rs.getDouble("TongTien"));
                hd.setTienKhachDua(rs.getDouble("TienKhachDua"));
                hd.setTienThua(rs.getDouble("TienThua"));
                hd.setHinhThucBh(rs.getString("HinhThucBH"));
                hd.setHinhThucTT(rs.getString("HinhThucTT"));
                hd.setTinhTrang(rs.getString("TinhTrang"));
                hd.setGhiChu(rs.getString("GhiChu"));
                listHd.add(hd);
            }
            rs.close();
            ps.close();
            conn.close();
            return listHd;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<HoaDon> timHd(String ma) {
        try {
            List<HoaDon> listHd = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select HoaDon.Ma as MaHd, HoaDon.NgayTao, HoaDon.NgayThanhToan, KhachHang.Ma as MaKh, KhachHang.HoTen as TenKh, \n"
                    + " (HoaDonChiTiet.DonGia-KhuyenMai.GiamGia)*HoaDonChiTiet.SoLuong as TongTien, \n"
                    + " HoaDonChiTiet.TienKhachDua, HoaDonChiTiet.TienKhachDua-((HoaDonChiTiet.DonGia-KhuyenMai.GiamGia)*HoaDonChiTiet.SoLuong) as TienThua, \n"
                    + " HoaDon.HinhThucBH, HoaDon.HinhThucTT, HoaDon.TinhTrang, HoaDon.GhiChu from HoaDon\n"
                    + " join HoaDonChiTiet on HoaDon.Id=HoaDonChiTiet.IdHoaDon\n"
                    + " join ChiTietSP on HoaDonChiTiet.IdChiTietSP=ChiTietSP.Id\n"
                    + " join KhuyenMai on ChiTietSP.IdKm=KhuyenMai.Id\n"
                    + " join KhachHang on HoaDon.IdKH=KhachHang.Id "
                    + " where HoaDon.Ma=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                HoaDon hd=new HoaDon();
                hd.setMaHd(rs.getString("MaHd"));
                hd.setNgayTao(rs.getString("NgayTao"));
                hd.setNgayTT(rs.getString("NgayThanhToan"));
                hd.setMaKh(rs.getString("MaKh"));
                hd.setTenKh(rs.getString("TenKh"));
                hd.setTongTien(rs.getDouble("TongTien"));
                hd.setTienKhachDua(rs.getDouble("TienKhachDua"));
                hd.setTienThua(rs.getDouble("TienThua"));
                hd.setHinhThucBh(rs.getString("HinhThucBH"));
                hd.setHinhThucTT(rs.getString("HinhThucTT"));
                hd.setTinhTrang(rs.getString("TinhTrang"));
                hd.setGhiChu(rs.getString("GhiChu"));
                listHd.add(hd);
            }
            rs.close();
            ps.close();
            conn.close();
            return listHd;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<HoaDon> locHdTheoTT(String tt) {
        try {
            List<HoaDon> listHd = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select HoaDon.Ma as MaHd, HoaDon.NgayTao, HoaDon.NgayThanhToan, KhachHang.Ma as MaKh, KhachHang.HoTen as TenKh, \n"
                    + " (HoaDonChiTiet.DonGia-KhuyenMai.GiamGia)*HoaDonChiTiet.SoLuong as TongTien, \n"
                    + " HoaDonChiTiet.TienKhachDua, HoaDonChiTiet.TienKhachDua-((HoaDonChiTiet.DonGia-KhuyenMai.GiamGia)*HoaDonChiTiet.SoLuong) as TienThua, \n"
                    + " HoaDon.HinhThucBH, HoaDon.HinhThucTT, HoaDon.TinhTrang, HoaDon.GhiChu from HoaDon\n"
                    + " join HoaDonChiTiet on HoaDon.Id=HoaDonChiTiet.IdHoaDon\n"
                    + " join ChiTietSP on HoaDonChiTiet.IdChiTietSP=ChiTietSP.Id\n"
                    + " join KhuyenMai on ChiTietSP.IdKm=KhuyenMai.Id\n"
                    + " join KhachHang on HoaDon.IdKH=KhachHang.Id"
                    + " where HoaDon.TinhTrang=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, tt);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                HoaDon hd=new HoaDon();
                hd.setMaHd(rs.getString("MaHd"));
                hd.setNgayTao(rs.getString("NgayTao"));
                hd.setNgayTT(rs.getString("NgayThanhToan"));
                hd.setMaKh(rs.getString("MaKh"));
                hd.setTenKh(rs.getString("TenKh"));
                hd.setTongTien(rs.getDouble("TongTien"));
                hd.setTienKhachDua(rs.getDouble("TienKhachDua"));
                hd.setTienThua(rs.getDouble("TienThua"));
                hd.setHinhThucBh(rs.getString("HinhThucBH"));
                hd.setHinhThucTT(rs.getString("HinhThucTT"));
                hd.setTinhTrang(rs.getString("TinhTrang"));
                hd.setGhiChu(rs.getString("GhiChu"));
                listHd.add(hd);
            }
            rs.close();
            ps.close();
            conn.close();
            return listHd;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<HoaDon> locHdTheoHTBH(String htbh) {
        try {
            List<HoaDon> listHd = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select HoaDon.Ma as MaHd, HoaDon.NgayTao, HoaDon.NgayThanhToan, KhachHang.Ma as MaKh, KhachHang.HoTen as TenKh, \n"
                    + " (HoaDonChiTiet.DonGia-KhuyenMai.GiamGia)*HoaDonChiTiet.SoLuong as TongTien, \n"
                    + " HoaDonChiTiet.TienKhachDua, HoaDonChiTiet.TienKhachDua-((HoaDonChiTiet.DonGia-KhuyenMai.GiamGia)*HoaDonChiTiet.SoLuong) as TienThua, \n"
                    + " HoaDon.HinhThucBH, HoaDon.HinhThucTT, HoaDon.TinhTrang, HoaDon.GhiChu from HoaDon\n"
                    + " join HoaDonChiTiet on HoaDon.Id=HoaDonChiTiet.IdHoaDon\n"
                    + " join ChiTietSP on HoaDonChiTiet.IdChiTietSP=ChiTietSP.Id\n"
                    + " join KhuyenMai on ChiTietSP.IdKm=KhuyenMai.Id\n"
                    + " join KhachHang on HoaDon.IdKH=KhachHang.Id"
                    + " where HoaDon.HinhThucBH=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, htbh);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                HoaDon hd=new HoaDon();
                hd.setMaHd(rs.getString("MaHd"));
                hd.setNgayTao(rs.getString("NgayTao"));
                hd.setNgayTT(rs.getString("NgayThanhToan"));
                hd.setMaKh(rs.getString("MaKh"));
                hd.setTenKh(rs.getString("TenKh"));
                hd.setTongTien(rs.getDouble("TongTien"));
                hd.setTienKhachDua(rs.getDouble("TienKhachDua"));
                hd.setTienThua(rs.getDouble("TienThua"));
                hd.setHinhThucBh(rs.getString("HinhThucBH"));
                hd.setHinhThucTT(rs.getString("HinhThucTT"));
                hd.setTinhTrang(rs.getString("TinhTrang"));
                hd.setGhiChu(rs.getString("GhiChu"));
                listHd.add(hd);
            }
            rs.close();
            ps.close();
            conn.close();
            return listHd;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<HoaDon> locHdTheoHTTT(String httt) {
        try {
            List<HoaDon> listHd = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select HoaDon.Ma as MaHd, HoaDon.NgayTao, HoaDon.NgayThanhToan, KhachHang.Ma as MaKh, KhachHang.HoTen as TenKh, \n"
                    + " (HoaDonChiTiet.DonGia-KhuyenMai.GiamGia)*HoaDonChiTiet.SoLuong as TongTien, \n"
                    + " HoaDonChiTiet.TienKhachDua, HoaDonChiTiet.TienKhachDua-((HoaDonChiTiet.DonGia-KhuyenMai.GiamGia)*HoaDonChiTiet.SoLuong) as TienThua, \n"
                    + " HoaDon.HinhThucBH, HoaDon.HinhThucTT, HoaDon.TinhTrang, HoaDon.GhiChu from HoaDon\n"
                    + " join HoaDonChiTiet on HoaDon.Id=HoaDonChiTiet.IdHoaDon\n"
                    + " join ChiTietSP on HoaDonChiTiet.IdChiTietSP=ChiTietSP.Id\n"
                    + " join KhuyenMai on ChiTietSP.IdKm=KhuyenMai.Id\n"
                    + " join KhachHang on HoaDon.IdKH=KhachHang.Id"
                    + " where HoaDon.HinhThucTT=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, httt);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                HoaDon hd=new HoaDon();
                hd.setMaHd(rs.getString("MaHd"));
                hd.setNgayTao(rs.getString("NgayTao"));
                hd.setNgayTT(rs.getString("NgayThanhToan"));
                hd.setMaKh(rs.getString("MaKh"));
                hd.setTenKh(rs.getString("TenKh"));
                hd.setTongTien(rs.getDouble("TongTien"));
                hd.setTienKhachDua(rs.getDouble("TienKhachDua"));
                hd.setTienThua(rs.getDouble("TienThua"));
                hd.setHinhThucBh(rs.getString("HinhThucBH"));
                hd.setHinhThucTT(rs.getString("HinhThucTT"));
                hd.setTinhTrang(rs.getString("TinhTrang"));
                hd.setGhiChu(rs.getString("GhiChu"));
                listHd.add(hd);
            }
            rs.close();
            ps.close();
            conn.close();
            return listHd;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Integer updateTT(HoaDon hd){
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update HoaDon set TinhTrang=N'Đã thanh toán',NgayTao=getdate(), NgayThanhToan=?,HinhThucBH=?, HinhThucTT=?, GhiChu=? where Ma=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, hd.getNgayTT());
            ps.setString(2, hd.getHinhThucBh());
            ps.setString(3, hd.getHinhThucTT());
            ps.setString(4, hd.getGhiChu());
            ps.setString(5, hd.getMaHd());
            int updateTT=ps.executeUpdate();
            ps.close();
            conn.close();
            return updateTT;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Integer updateTT2(HoaDon hd){
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update HoaDon set TinhTrang=N'Đã hủy',NgayTao=getdate(), NgayThanhToan=?,HinhThucBH=?, HinhThucTT=?, GhiChu=? where Ma=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, hd.getNgayTT());
            ps.setString(2, hd.getHinhThucBh());
            ps.setString(3, hd.getHinhThucTT());
            ps.setString(4, hd.getGhiChu());
            ps.setString(5, hd.getMaHd());
            int updateTT=ps.executeUpdate();
            ps.close();
            conn.close();
            return updateTT;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Integer updateTKD(HoaDon hd){
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update HoaDonChiTiet set TienKhachDua=? where DonGia=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setDouble(1, hd.getTienKhachDua());
            ps.setDouble(2, hd.getDonGia());
            int updateTKD=ps.executeUpdate();
            ps.close();
            conn.close();
            return updateTKD;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
