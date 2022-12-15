/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.HoaDonChiTiet;
import DomainModels.HoaDonChiTiet2;
import Repository.Interface.IHoaDonChiTietRepo;
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
public class HoaDonChiTietRepo implements IHoaDonChiTietRepo {

    @Override
    public List<HoaDonChiTiet> getAllHdct(String ten) {
        try {
            List<HoaDonChiTiet> listHdct = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select ChiTietSP.Ma, SanPham.Ten, HoaDonChiTiet.DonGia, HoaDonChiTiet.SoLuong, KhuyenMai.GiamGia, (HoaDonChiTiet.DonGia-KhuyenMai.GiamGia)*HoaDonChiTiet.SoLuong as ThanhTien from ChiTietSP\n"
                    + " join SanPham on ChiTietSP.IdSp=SanPham.Id\n"
                    + " join HoaDonChiTiet on ChiTietSP.Id=HoaDonChiTiet.IdChiTietSP\n"
                    + " join KhuyenMai on ChiTietSP.IdKm=KhuyenMai.Id\n"
                    + " where SanPham.Ten=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setMaSp(rs.getString("Ma"));
                hdct.setTenSp(rs.getString("Ten"));
                hdct.setDonGia(rs.getDouble("DonGia"));
                hdct.setGiamGia(rs.getDouble("GiamGia"));
                hdct.setSoLuong(rs.getInt("SoLuong"));
                hdct.setThanhTien(rs.getDouble("ThanhTien"));
                listHdct.add(hdct);

            }
            rs.close();
            ps.close();
            conn.close();
            return listHdct;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HoaDonChiTiet2> getAllHdct2(Integer maHd) {
        try {
            List<HoaDonChiTiet2> listHdct = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select HoaDon.Ma as MaHd, ChiTietSP.Ma as MaSp, SanPham.Ten, format(HoaDonChiTiet.DonGia,'c','vi-VN')as DonGia, HoaDonChiTiet.SoLuong, format(KhuyenMai.GiamGia,'c','vi-VN') as GiamGia, format((HoaDonChiTiet.DonGia-KhuyenMai.GiamGia)*HoaDonChiTiet.SoLuong,'c','vi-VN') as ThanhTien from ChiTietSP\n"
                    + "join SanPham on ChiTietSP.IdSp=SanPham.Id\n"
                    + "join HoaDonChiTiet on ChiTietSP.Id=HoaDonChiTiet.IdChiTietSP\n"
                    + "join KhuyenMai on ChiTietSP.IdKm=KhuyenMai.Id\n"
                    + "join HoaDon on HoaDonChiTiet.IdHoaDon=HoaDon.Id\n"
                    + "where  HoaDon.Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maHd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet2 hdct = new HoaDonChiTiet2();
                hdct.setMaHd(rs.getInt("MaHd"));
                hdct.setMaSp(rs.getString("MaSp"));
                hdct.setTenSp(rs.getString("Ten"));
                hdct.setDonGia(rs.getString("DonGia"));
                hdct.setGiamGia(rs.getString("GiamGia"));
                hdct.setSoLuong(rs.getInt("SoLuong"));
                hdct.setThanhTien(rs.getString("ThanhTien"));
                listHdct.add(hdct);
            }
            rs.close();
            ps.close();
            conn.close();
            return listHdct;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updateSl(HoaDonChiTiet hdct) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update HoaDonChiTiet set SoLuong=? where DonGia=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, hdct.getSoLuong());
            ps.setDouble(2, hdct.getDonGia());
            int update = ps.executeUpdate();
            ps.close();
            conn.close();
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HoaDonChiTiet> delete() {
        try {
            List<HoaDonChiTiet> listHdct = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select SanPham.Ma, SanPham.Ten, HoaDonChiTiet.DonGia, HoaDonChiTiet.SoLuong, KhuyenMai.GiamGia, (HoaDonChiTiet.DonGia-KhuyenMai.GiamGia)*HoaDonChiTiet.SoLuong as ThanhTien from ChiTietSP\n"
                    + " join SanPham on ChiTietSP.IdSp=SanPham.Id\n"
                    + " join HoaDonChiTiet on ChiTietSP.Id=HoaDonChiTiet.IdChiTietSP\n"
                    + " join KhuyenMai on ChiTietSP.IdKm=KhuyenMai.Id\n"
                    + " where SanPham.Ma='sp000'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setMaSp(rs.getString("Ma"));
                hdct.setTenSp(rs.getString("Ten"));
                hdct.setDonGia(rs.getDouble("DonGia"));
                hdct.setGiamGia(rs.getDouble("GiamGia"));
                hdct.setSoLuong(rs.getInt("SoLuong"));
                hdct.setThanhTien(rs.getDouble("ThanhTien"));
                listHdct.add(hdct);
            }
            rs.close();
            ps.close();
            conn.close();
            return listHdct;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
