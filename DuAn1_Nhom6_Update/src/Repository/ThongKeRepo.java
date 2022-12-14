/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ThongKe;

import Utilities.DBContext;
import ViewModels.QuanLyThongKe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Repository.Interface.IThongKeRepo;

/**
 *
 * @author levan
 */
public class ThongKeRepo implements IThongKeRepo {

    @Override
    public List<ThongKe> getAll() {
        try {
            List<ThongKe> listKh = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "SELECT SanPham.Ma, SanPham.Ten, HoaDon.NgayThanhToan, HoaDonChiTiet.DonGia,HoaDonChiTiet.SoLuong,  HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong as 'Tong' \n"
                    + "                  FROM     HoaDon INNER JOIN\n"
                    + "                                     KhachHang ON HoaDon.IdKH = KhachHang.Id INNER JOIN\n"
                    + "                                     NhanVien ON HoaDon.IdNV = NhanVien.Id INNER JOIN\n"
                    + "                                  HoaDonChiTiet ON HoaDon.Id = HoaDonChiTiet.IdHoaDon INNER JOIN\n"
                    + "                                      ChiTietSP ON HoaDonChiTiet.IdChiTietSP = ChiTietSP.Id INNER JOIN\n"
                    + "                                     SanPham ON ChiTietSP.IdSP = SanPham.Id\n"
                    + "								where NgayThanhToan is not null ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe kh = new ThongKe();

                kh.setMaSP(rs.getString("Ma"));
                kh.setTenSP(rs.getString("Ten"));
                kh.setNgay(rs.getString("NgayThanhToan"));
                kh.setSoLuong(rs.getInt("SoLuong"));
                kh.setDongia(rs.getDouble("DonGia"));
                kh.setThanhTien(rs.getDouble("Tong"));
                listKh.add(kh);

            }
            rs.close();
            ps.close();
            conn.close();
            return listKh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ThongKe> tim(String ma) {
        try {
            List<ThongKe> listKh = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "SELECT SanPham.Ma, SanPham.Ten, HoaDon.NgayThanhToan, HoaDonChiTiet.DonGia,HoaDonChiTiet.SoLuong,  HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong as 'Tong' \n"
                    + "                  FROM     HoaDon INNER JOIN\n"
                    + "                                     KhachHang ON HoaDon.IdKH = KhachHang.Id INNER JOIN\n"
                    + "                                     NhanVien ON HoaDon.IdNV = NhanVien.Id INNER JOIN\n"
                    + "                                  HoaDonChiTiet ON HoaDon.Id = HoaDonChiTiet.IdHoaDon INNER JOIN\n"
                    + "                                      ChiTietSP ON HoaDonChiTiet.IdChiTietSP = ChiTietSP.Id INNER JOIN\n"
                    + "                                     SanPham ON ChiTietSP.IdSP = SanPham.Id\n"
                    + "									 where SanPham.Ma=?\n"
                    + "									 and  NgayThanhToan is not null ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ThongKe kh = new ThongKe();

                kh.setMaSP(rs.getString("Ma"));
                kh.setTenSP(rs.getString("Ten"));
                kh.setNgay(rs.getString("NgayThanhToan"));
                kh.setSoLuong(rs.getInt("SoLuong"));
                kh.setDongia(rs.getDouble("DonGia"));
                kh.setThanhTien(rs.getDouble("Tong"));
                listKh.add(kh);

            }

            return listKh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<ThongKe> thang(String month) {
        try {
            List<ThongKe> listKh = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "SELECT SanPham.Ma, SanPham.Ten, HoaDon.NgayThanhToan, HoaDonChiTiet.DonGia,HoaDonChiTiet.SoLuong,  HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong as 'Tong' \n"
                    + "                  FROM     HoaDon INNER JOIN\n"
                    + "                                     KhachHang ON HoaDon.IdKH = KhachHang.Id INNER JOIN\n"
                    + "                                     NhanVien ON HoaDon.IdNV = NhanVien.Id INNER JOIN\n"
                    + "                                  HoaDonChiTiet ON HoaDon.Id = HoaDonChiTiet.IdHoaDon INNER JOIN\n"
                    + "                                      ChiTietSP ON HoaDonChiTiet.IdChiTietSP = ChiTietSP.Id INNER JOIN\n"
                    + "                                     SanPham ON ChiTietSP.IdSP = SanPham.Id\n"
                    + "									 where month(NgayThanhToan)=?\n"
                    + "									 and  NgayThanhToan is not null ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, month);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ThongKe kh = new ThongKe();

                kh.setMaSP(rs.getString("Ma"));
                kh.setTenSP(rs.getString("Ten"));
                kh.setNgay(rs.getString("NgayThanhToan"));
                kh.setSoLuong(rs.getInt("SoLuong"));
                kh.setDongia(rs.getDouble("DonGia"));
                kh.setThanhTien(rs.getDouble("Tong"));
                listKh.add(kh);

            }

            return listKh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<ThongKe> nam(String year) {
        try {
            List<ThongKe> listKh = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "SELECT SanPham.Ma, SanPham.Ten, HoaDon.NgayThanhToan, HoaDonChiTiet.DonGia,HoaDonChiTiet.SoLuong,  HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong as 'Tong' \n"
                    + "                  FROM     HoaDon INNER JOIN\n"
                    + "                                     KhachHang ON HoaDon.IdKH = KhachHang.Id INNER JOIN\n"
                    + "                                     NhanVien ON HoaDon.IdNV = NhanVien.Id INNER JOIN\n"
                    + "                                  HoaDonChiTiet ON HoaDon.Id = HoaDonChiTiet.IdHoaDon INNER JOIN\n"
                    + "                                      ChiTietSP ON HoaDonChiTiet.IdChiTietSP = ChiTietSP.Id INNER JOIN\n"
                    + "                                     SanPham ON ChiTietSP.IdSP = SanPham.Id\n"
                    + "									 where Year(NgayThanhToan)= ?\n"
                    + "									 and  NgayThanhToan is not null ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, year);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe kh = new ThongKe();

                kh.setMaSP(rs.getString("Ma"));
                kh.setTenSP(rs.getString("Ten"));
                kh.setNgay(rs.getString("NgayThanhToan"));
                kh.setSoLuong(rs.getInt("SoLuong"));
                kh.setDongia(rs.getDouble("DonGia"));
                kh.setThanhTien(rs.getDouble("Tong"));
                listKh.add(kh);

            }

            return listKh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
