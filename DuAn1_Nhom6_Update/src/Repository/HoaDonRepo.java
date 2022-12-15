/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.HoaDon;
import DomainModels.HoaDon2;
import DomainModels.HoaDonChiTiet;
import Repository.Interface.IHoaDonRepo;
import Utilities.DBContext;
import ViewModels.QlHoaDon;
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
    public List<HoaDon2> getAllHd() {
        try {
            List<HoaDon2> listHd = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select HoaDon.Ma as MaHd, HoaDon.NgayTao, HoaDon.NgayThanhToan, KhachHang.Ma as MaKh, KhachHang.HoTen as TenKh, \n"
                    + "format(HoaDon.DonGia-HoaDon.GiamGia,'c', 'vi-VN') as TongTien, \n"
                    + "format(HoaDon.TienKhachDua, 'c', 'vi-VN') as TienKhachDua, format(HoaDon.TienKhachDua-(HoaDon.DonGia-HoaDon.GiamGia),'c','vi-VN') as TienThua, \n"
                    + "HoaDon.HinhThucBH, HoaDon.HinhThucTT, HoaDon.TinhTrang, HoaDon.GhiChu from HoaDon\n"
                    + "join KhachHang on HoaDon.IdKH=KhachHang.Id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon2 hd = new HoaDon2();
                hd.setMaHd(rs.getInt("MaHd"));
                hd.setNgayTao(rs.getString("NgayTao"));
                hd.setNgayTT(rs.getString("NgayThanhToan"));
                hd.setMaKh(rs.getString("MaKh"));
                hd.setTenKh(rs.getString("TenKh"));
                hd.setTongTien(rs.getString("TongTien"));
                hd.setTienKhachDua(rs.getString("TienKhachDua"));
                hd.setTienThua(rs.getString("TienThua"));
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
    public List<HoaDon> getAllHd1() {
        try {
            List<HoaDon> listHd = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select * from HoaDon";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHd(rs.getString("Id"));
                hd.setMaHd(rs.getInt("Ma"));
                hd.setNgayTao(rs.getString("NgayTao"));
                hd.setNgayTT(rs.getString("NgayThanhToan"));
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
    public List<HoaDon2> timHd(Integer ma) {
        try {
            List<HoaDon2> listHd = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select HoaDon.Ma as MaHd, HoaDon.NgayTao, HoaDon.NgayThanhToan, KhachHang.Ma as MaKh, KhachHang.HoTen as TenKh, \n"
                    + "format(HoaDon.DonGia-HoaDon.GiamGia,'c', 'vi-VN') as TongTien, \n"
                    + "format(HoaDon.TienKhachDua, 'c', 'vi-VN') as TienKhachDua, format(HoaDon.TienKhachDua-(HoaDon.DonGia-HoaDon.GiamGia),'c','vi-VN') as TienThua, \n"
                    + "HoaDon.HinhThucBH, HoaDon.HinhThucTT, HoaDon.TinhTrang, HoaDon.GhiChu from HoaDon\n"
                    + "join KhachHang on HoaDon.IdKH=KhachHang.Id "
                    + " where HoaDon.Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon2 hd = new HoaDon2();
                hd.setMaHd(rs.getInt("MaHd"));
                hd.setNgayTao(rs.getString("NgayTao"));
                hd.setNgayTT(rs.getString("NgayThanhToan"));
                hd.setMaKh(rs.getString("MaKh"));
                hd.setTenKh(rs.getString("TenKh"));
                hd.setTongTien(rs.getString("TongTien"));
                hd.setTienKhachDua(rs.getString("TienKhachDua"));
                hd.setTienThua(rs.getString("TienThua"));
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
    public List<HoaDon2> locHdTheoTT(String tt) {
        try {
            List<HoaDon2> listHd = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select HoaDon.Ma as MaHd, HoaDon.NgayTao, HoaDon.NgayThanhToan, KhachHang.Ma as MaKh, KhachHang.HoTen as TenKh, \n"
                    + "format(HoaDon.DonGia-HoaDon.GiamGia,'c', 'vi-VN') as TongTien, \n"
                    + "format(HoaDon.TienKhachDua, 'c', 'vi-VN') as TienKhachDua, format(HoaDon.TienKhachDua-(HoaDon.DonGia-HoaDon.GiamGia),'c','vi-VN') as TienThua, \n"
                    + "HoaDon.HinhThucBH, HoaDon.HinhThucTT, HoaDon.TinhTrang, HoaDon.GhiChu from HoaDon\n"
                    + "join KhachHang on HoaDon.IdKH=KhachHang.Id"
                    + " where HoaDon.TinhTrang=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon2 hd = new HoaDon2();
                hd.setMaHd(rs.getInt("MaHd"));
                hd.setNgayTao(rs.getString("NgayTao"));
                hd.setNgayTT(rs.getString("NgayThanhToan"));
                hd.setMaKh(rs.getString("MaKh"));
                hd.setTenKh(rs.getString("TenKh"));
                hd.setTongTien(rs.getString("TongTien"));
                hd.setTienKhachDua(rs.getString("TienKhachDua"));
                hd.setTienThua(rs.getString("TienThua"));
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
    public List<HoaDon2> locHdTheoHTBH(String htbh) {
        try {
            List<HoaDon2> listHd = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select HoaDon.Ma as MaHd, HoaDon.NgayTao, HoaDon.NgayThanhToan, KhachHang.Ma as MaKh, KhachHang.HoTen as TenKh, \n"
                    + "format(HoaDon.DonGia-HoaDon.GiamGia,'c', 'vi-VN') as TongTien, \n"
                    + "format(HoaDon.TienKhachDua, 'c', 'vi-VN') as TienKhachDua, format(HoaDon.TienKhachDua-(HoaDon.DonGia-HoaDon.GiamGia),'c','vi-VN') as TienThua, \n"
                    + "HoaDon.HinhThucBH, HoaDon.HinhThucTT, HoaDon.TinhTrang, HoaDon.GhiChu from HoaDon\n"
                    + "join KhachHang on HoaDon.IdKH=KhachHang.Id"
                    + " where HoaDon.HinhThucBH=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, htbh);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon2 hd = new HoaDon2();
                hd.setMaHd(rs.getInt("MaHd"));
                hd.setNgayTao(rs.getString("NgayTao"));
                hd.setNgayTT(rs.getString("NgayThanhToan"));
                hd.setMaKh(rs.getString("MaKh"));
                hd.setTenKh(rs.getString("TenKh"));
                hd.setTongTien(rs.getString("TongTien"));
                hd.setTienKhachDua(rs.getString("TienKhachDua"));
                hd.setTienThua(rs.getString("TienThua"));
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
    public List<HoaDon2> locHdTheoHTTT(String httt) {
        try {
            List<HoaDon2> listHd = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select HoaDon.Ma as MaHd, HoaDon.NgayTao, HoaDon.NgayThanhToan, KhachHang.Ma as MaKh, KhachHang.HoTen as TenKh, \n"
                    + "format(HoaDon.DonGia-HoaDon.GiamGia,'c', 'vi-VN') as TongTien, \n"
                    + "format(HoaDon.TienKhachDua, 'c', 'vi-VN') as TienKhachDua, format(HoaDon.TienKhachDua-(HoaDon.DonGia-HoaDon.GiamGia),'c','vi-VN') as TienThua, \n"
                    + "HoaDon.HinhThucBH, HoaDon.HinhThucTT, HoaDon.TinhTrang, HoaDon.GhiChu from HoaDon\n"
                    + "join KhachHang on HoaDon.IdKH=KhachHang.Id"
                    + " where HoaDon.HinhThucTT=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, httt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon2 hd = new HoaDon2();
                hd.setMaHd(rs.getInt("MaHd"));
                hd.setNgayTao(rs.getString("NgayTao"));
                hd.setNgayTT(rs.getString("NgayThanhToan"));
                hd.setMaKh(rs.getString("MaKh"));
                hd.setTenKh(rs.getString("TenKh"));
                hd.setTongTien(rs.getString("TongTien"));
                hd.setTienKhachDua(rs.getString("TienKhachDua"));
                hd.setTienThua(rs.getString("TienThua"));
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
    public List<HoaDon> getAllHdc(String ten) {
        try {
            List<HoaDon> listHd = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select top(1) HoaDon.Ma as MaHd ,HoaDon.Id, GETDATE() as NgayTao, NhanVien.HoTen as TenNv, "
                    + " KhachHang.HoTen as TenKh from HoaDon \n"
                    + " join NhanVien on HoaDon.IdNV=NhanVien.Id\n"
                    + " join KhachHang on KhachHang.Id=HoaDon.IdKH\n"
                    + " where KhachHang.HoTen=? "
                    + " order by HoaDon.Ma desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHd(rs.getString("Id"));
                hd.setMaHd(rs.getInt("MaHd"));
                hd.setNgayTao(rs.getString("NgayTao"));
                hd.setTenNv(rs.getString("TenNv"));
                hd.setTenKh(rs.getString("TenKh"));
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
    public Integer addHdc(QlHoaDon hd) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into HoaDon values( NEWID(),?,'88FAFC48-6A4C-4076-9DEE-682C445272B3',getdate(),null,null,null,null,null,null,null,null)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getTenKh());
            int addHdc = ps.executeUpdate();
            ps.close();
            conn.close();
            return addHdc;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updateTT(HoaDon hd) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update HoaDon set TinhTrang=N'Đã thanh toán', DonGia=?, GiamGia=?, TienKhachDua=?, NgayThanhToan=?, HinhThucBH=?, HinhThucTT=?, GhiChu=? where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, hd.getTongTien());
            ps.setDouble(2, hd.getGiamGia());
            ps.setDouble(3, hd.getTienKhachDua());
            ps.setString(4, hd.getNgayTT());
            ps.setString(5, hd.getHinhThucBh());
            ps.setString(6, hd.getHinhThucTT());
            ps.setString(7, hd.getGhiChu());
            ps.setInt(8, hd.getMaHd());
            int updateTT = ps.executeUpdate();
            ps.close();
            conn.close();
            return updateTT;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updateTT2(HoaDon hd) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update HoaDon set TinhTrang=N'Đã hủy', DonGia=?, GiamGia=?, TienKhachDua=?, NgayThanhToan=?, HinhThucBH=?, HinhThucTT=?, GhiChu=? where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, hd.getTongTien());
            ps.setDouble(2, hd.getGiamGia());
            ps.setDouble(3, hd.getTienKhachDua());
            ps.setString(4, hd.getNgayTT());
            ps.setString(5, hd.getHinhThucBh());
            ps.setString(6, hd.getHinhThucTT());
            ps.setString(7, hd.getGhiChu());
            ps.setInt(8, hd.getMaHd());
            int updateTT2 = ps.executeUpdate();
            ps.close();
            conn.close();
            return updateTT2;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updateTKD(HoaDon hd) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update HoaDonChiTiet set TienKhachDua=? set DonGia=?"
                    + " where SoLuong=1";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, hd.getTienKhachDua());
            ps.setDouble(2, hd.getDonGia());

            int updateTKD = ps.executeUpdate();
            ps.close();
            conn.close();
            return updateTKD;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addHdct(HoaDon hd) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into HoaDonChiTiet values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getIdHd());
            ps.setString(2, hd.getIdCtsp());
            ps.setInt(3, hd.getSoLuong());
            ps.setDouble(4, hd.getDonGia());

            int add = ps.executeUpdate();
            ps.close();
            conn.close();
            return add;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
