/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Repository.Interface.ISanPham_BanHangRepo;
import DomainModels.SanPham_BanHang;
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
public class SanPham_BanHangRepo implements ISanPham_BanHangRepo {

    @Override
    public List<SanPham_BanHang> getAllSp() {
        try {
            List<SanPham_BanHang> listSp = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = " select  ChiTietSP.Id, ChiTietSP.Ma, SanPham.Ten,  DonGia, GiamGia,  HinhDangMat.Ten as HinhDangMat, ChatLieuMat.Ten as ChatLieuMat, KichThuoc, MauVo.Ten as MauVo, TheLoai.Ten as TheLoai,GioiTinh, KieuMay.Ten as KieuMay, SoLuongTon from ChiTietSP\n"
                    + " join SanPham on SanPham.Id=ChiTietSP.IdSP\n"
                    + " join MauVo on MauVo.Id=ChiTietSP.IdMauVo\n"
                    + " join TheLoai on TheLoai.Id=ChiTietSP.IdTheLoai\n"
                    + "join KhuyenMai on ChiTietSP.IdKm=KhuyenMai.Id\n"
                    + "join HinhDangMat on ChiTietSP.IdHinhDangMat=HinhDangMat.Id\n"
                    + "join ChatLieuMat on ChiTietSP.IdChatLieuMat=ChatLieuMat.Id\n"
                    + "join KieuMay on ChiTietSP.IdKieuMay=KieuMay.Id\n"
                    + "where TinhTrang=N'Còn kinh doanh'";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham_BanHang sp = new SanPham_BanHang();
                sp.setId(rs.getString("Id"));
                sp.setMa(rs.getString("Ma"));
                sp.setTen(rs.getString("Ten"));
                sp.setDonGia(rs.getDouble("DonGia"));
                sp.setGiamGia(rs.getDouble("GiamGia"));
                sp.setHinhDangMat(rs.getString("HinhDangMat"));
                sp.setChatLieuMat(rs.getString("ChatLieuMat"));
                sp.setKichThuoc(rs.getString("KichThuoc"));
                sp.setMauVo(rs.getString("MauVo"));
                sp.setTheLoai(rs.getString("TheLoai"));
                sp.setGioiTinh(rs.getString("GioiTinh"));
                sp.setKieuMay(rs.getString("KieuMay"));
                sp.setSoLuong(rs.getInt("SoLuongTon"));
                listSp.add(sp);
            }
            rs.close();
            ps.close();
            conn.close();
            return listSp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SanPham_BanHang> timSpTheoMa(String ma) {
        try {
            List<SanPham_BanHang> listSp = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select  ChiTietSP.Ma, SanPham.Ten,  DonGia, GiamGia,  HinhDangMat.Ten as HinhDangMat, ChatLieuMat.Ten as ChatLieuMat, KichThuoc, MauVo.Ten as MauVo, TheLoai.Ten as TheLoai,GioiTinh, KieuMay.Ten as KieuMay, SoLuongTon from ChiTietSP\n"
                    + " join SanPham on SanPham.Id=ChiTietSP.IdSP\n"
                    + " join MauVo on MauVo.Id=ChiTietSP.IdMauVo\n"
                    + " join TheLoai on TheLoai.Id=ChiTietSP.IdTheLoai\n"
                    + "join KhuyenMai on ChiTietSP.IdKm=KhuyenMai.Id\n"
                    + "join HinhDangMat on ChiTietSP.IdHinhDangMat=HinhDangMat.Id\n"
                    + "join ChatLieuMat on ChiTietSP.IdChatLieuMat=ChatLieuMat.Id\n"
                    + "join KieuMay on ChiTietSP.IdKieuMay=KieuMay.Id\n"
                    + "where TinhTrang=N'Còn kinh doanh' and SanPham.Ma =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham_BanHang sp = new SanPham_BanHang();
                sp.setMa(rs.getString("Ma"));
                sp.setTen(rs.getString("Ten"));
                sp.setDonGia(rs.getDouble("DonGia"));
                sp.setGiamGia(rs.getDouble("GiamGia"));
                sp.setHinhDangMat(rs.getString("HinhDangMat"));
                sp.setChatLieuMat(rs.getString("ChatLieuMat"));
                sp.setKichThuoc(rs.getString("KichThuoc"));
                sp.setMauVo(rs.getString("MauVo"));
                sp.setTheLoai(rs.getString("TheLoai"));
                sp.setGioiTinh(rs.getString("GioiTinh"));
                sp.setKieuMay(rs.getString("KieuMay"));
                sp.setSoLuong(rs.getInt("SoLuongTon"));
                listSp.add(sp);
            }
            rs.close();
            ps.close();
            conn.close();
            return listSp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
