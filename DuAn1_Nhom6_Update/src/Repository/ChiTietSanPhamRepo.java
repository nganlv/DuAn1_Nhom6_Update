/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Repository.Interface.IChiTietSanPhamRepo;
import DomainModels.ChiTietSanPham;
import DomainModels.NhanVien;
import Utilities.DBContext;
import ViewModels.QlChiTietSanPham;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author levan
 */
public class ChiTietSanPhamRepo implements IChiTietSanPhamRepo {

    
    @Override
    public List<QlChiTietSanPham> getAllCtsps() {
        try {
            List<QlChiTietSanPham> listCtsp = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = 
                              " select ChiTietSP.Ma, SanPham.Ten, ThuongHieu.Ten as ThuongHieu, XuatXu.Ten as XuatXu, TheLoai.Ten as TheLoai,ChatLieuDay.Ten as ChatLieuDay,MauMatSo.Ten as MauMatSo,MauVo.Ten as MauVo,PhuKien.Ten as PhuKien, TinhNang.Ten as TinhNang, HinhDangMatSo, ChatLieuMatKinh,GioiTinh,KieuMay,NamBH,KichThuoc,SoLuongTon,FORMAT(DonGia, 'c', 'vi-VN') as DonGia,   TinhTrang from ChiTietSP\n" +
"                      join SanPham on ChiTietSP.IdSp=SanPham.Id \n" +
"                      join ThuongHieu on ChiTietSP.IdThuongHieu=ThuongHieu.Id\n" +
"                      join XuatXu on ChiTietSP.IdXuatxu=XuatXu.Id\n" +
"                      join TheLoai on ChiTietSP.IdTheLoai=TheLoai.Id\n" +
"                      join ChatLieuDay on ChiTietSP.IdChatLieuDay=ChatLieuDay.Id\n" +
"                     join MauMatSo on ChiTietSP.IdMauMatSo=MauMatSo.Id\n" +
"                      join MauVo on ChiTietSP.IdMauVo=MauVo.Id\n" +
"                      join PhuKien on ChiTietSP.IdPhuKien=PhuKien.Id\n" +
"                      join TinhNang on ChiTietSP.IdTinhNang=TinhNang.Id";
                                                                                 
                                                                                           
                                                                             
                                                                      
                                                           
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QlChiTietSanPham ctsp = new QlChiTietSanPham();
                ctsp.setMa(rs.getString("Ma"));
              ctsp.setTen(rs.getString("Ten"));
              ctsp.setThuongHieu(rs.getString("ThuongHieu"));
              ctsp.setXuatXu(rs.getString("XuatXu"));
              ctsp.setTheLoai(rs.getString("TheLoai"));
              ctsp.setChatLieuDay(rs.getString("ChatLieuDay"));
              ctsp.setMauMat(rs.getString("MauMatSo"));
              ctsp.setMauVo(rs.getString("MauVo"));
              ctsp.setPhuKien(rs.getString("PhuKien"));
              ctsp.setTinhNang(rs.getString("TinhNang"));
              ctsp.setHinhDangMat(rs.getString("HinhDangMatSo"));
              ctsp.setChatLieuMat(rs.getString("ChatLieuMatKinh"));
              ctsp.setGioiTinh(rs.getString("GioiTinh"));
              ctsp.setKieuMay(rs.getString("KieuMay"));
              ctsp.setNamBh(rs.getInt("NamBH"));
              ctsp.setKichThuoc(rs.getString("KichThuoc"));
              ctsp.setSoLuong(rs.getInt("SoLuongTon"));
              ctsp.setDonGia(rs.getString("DonGia"));
              ctsp.setTinhTrang(rs.getString("TinhTrang"));
                listCtsp.add(ctsp);
            }
            rs.close();
            ps.close();
            conn.close();
            return listCtsp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    @Override
//    public List<ChiTietSanPham> getAllCtsp() {
//        try {
//            List<ChiTietSanPham> listCtsp = new ArrayList<>();
//            Connection conn = DBContext.getConnection();
//            String sql = "select ChiTietSP.Ma, SanPham.Ten, ThuongHieu.Ten as ThuongHieu, XuatXu.Ten as XuatXu, "
//                    + " GioiTinh, KieuMay, TheLoai.Ten as TheLoai, PhuKien.Ten as PhuKien, TinhNang.Ten as TinhNang, "
//                    + " HinhDangMatSo, ChatLieuMatKinh, ChatLieuDay.Ten as ChatLieuDay, MauMatSo.Ten as MauMatSo, "
//                    + " MauVo.Ten as MauVo, KichThuoc,FORMAT(DonGia, 'c', 'vi-VN') as DonGia, NamBH, SoLuongTon, TinhTrang from ChiTietSP\n"
//                    + " join SanPham on ChiTietSP.IdSp=SanPham.Id\n"
//                    + " join ThuongHieu on ChiTietSP.IdThuongHieu=ThuongHieu.Id\n"
//                    + " join XuatXu on ChiTietSP.IdXuatxu=XuatXu.Id\n"
//                    + " join TheLoai on ChiTietSP.IdTheLoai=TheLoai.Id\n"
//                    + " join ChatLieuDay on ChiTietSP.IdChatLieuDay=ChatLieuDay.Id\n"
//                    + " join MauMatSo on ChiTietSP.IdMauMatSo=MauMatSo.Id\n"
//                    + " join MauVo on ChiTietSP.IdMauVo=MauVo.Id\n"
//                    + " join PhuKien on ChiTietSP.IdPhuKien=PhuKien.Id\n"
//                    + " join TinhNang on ChiTietSP.IdTinhNang=TinhNang.Id";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                ChiTietSanPham ctsp = new ChiTietSanPham();
//                ctsp.setMa(rs.getString("Ma"));
//                ctsp.setTen(rs.getString("Ten"));
//                ctsp.setThuongHieu(rs.getString("ThuongHieu"));
//                ctsp.setXuatXu(rs.getString("XuatXu"));
//                ctsp.setTheLoai(rs.getString("TheLoai"));
//                ctsp.setChatLieuDay(rs.getString("ChatLieuDay"));
//                ctsp.setChatLieuMat(rs.getString("ChatLieuMatKinh"));
//                ctsp.setMauMat(rs.getString("MauMatSo"));
//                ctsp.setMauVo(rs.getString("MauVo"));
//                ctsp.setGioiTinh(rs.getString("GioiTinh"));
//                ctsp.setPhuKien(rs.getString("PhuKien"));
//                ctsp.setTinhNang(rs.getString("TinhNang"));
//                ctsp.setNamBh(rs.getInt("NamBH"));
//                ctsp.setDonGia(rs.getString("DonGia"));
//                ctsp.setHinhDangMat(rs.getString("HinhDangMatSo"));
//                ctsp.setSoLuong(rs.getInt("SoLuongTon"));
//                ctsp.setKieuMay(rs.getString("KieuMay"));
//                ctsp.setTinhTrang(rs.getString("TinhTrang"));
//                ctsp.setKichThuoc(rs.getString("KichThuoc"));
//                listCtsp.add(ctsp);
//            }
//            rs.close();
//            ps.close();
//            conn.close();
//            return listCtsp;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

//    @Override
//    public List<ChiTietSanPham> timSp(String ma) {
//        try {
//            List<ChiTietSanPham> listCtsp = new ArrayList<>();
//            Connection conn = DBContext.getConnection();
//            String sql = "select ChiTietSP.Ma, SanPham.Ten, ThuongHieu.Ten as ThuongHieu, XuatXu.Ten as XuatXu, "
//                    + " GioiTinh, KieuMay, TheLoai.Ten as TheLoai, PhuKien.Ten as PhuKien, TinhNang.Ten as TinhNang, "
//                    + " HinhDangMatSo, ChatLieuMatKinh, ChatLieuDay.Ten as ChatLieuDay, MauMatSo.Ten as MauMatSo, "
//                    + " MauVo.Ten as MauVo, KichThuoc,FORMAT(DonGia, 'c', 'vi-VN') as DonGia, NamBH, SoLuongTon, TinhTrang from ChiTietSP\n"
//                    + " join SanPham on ChiTietSP.IdSp=SanPham.Id\n"
//                    + " join ThuongHieu on ChiTietSP.IdThuongHieu=ThuongHieu.Id\n"
//                    + " join XuatXu on ChiTietSP.IdXuatxu=XuatXu.Id\n"
//                    + " join TheLoai on ChiTietSP.IdTheLoai=TheLoai.Id\n"
//                    + " join ChatLieuDay on ChiTietSP.IdChatLieuDay=ChatLieuDay.Id\n"
//                    + " join MauMatSo on ChiTietSP.IdMauMatSo=MauMatSo.Id\n"
//                    + " join MauVo on ChiTietSP.IdMauVo=MauVo.Id\n"
//                    + " join PhuKien on ChiTietSP.IdPhuKien=PhuKien.Id\n"
//                    + " join TinhNang on ChiTietSP.IdTinhNang=TinhNang.Id"
//                    + " where ChiTietSP.Ma=?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, ma);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                ChiTietSanPham ctsp = new ChiTietSanPham();
//                ctsp.setMa(rs.getString("Ma"));
//                ctsp.setTen(rs.getString("Ten"));
//                ctsp.setThuongHieu(rs.getString("ThuongHieu"));
//                ctsp.setXuatXu(rs.getString("XuatXu"));
//                ctsp.setTheLoai(rs.getString("TheLoai"));
//                ctsp.setChatLieuDay(rs.getString("ChatLieuDay"));
//                ctsp.setChatLieuMat(rs.getString("ChatLieuMatKinh"));
//                ctsp.setMauMat(rs.getString("MauMatSo"));
//                ctsp.setMauVo(rs.getString("MauVo"));
//                ctsp.setGioiTinh(rs.getString("GioiTinh"));
//                ctsp.setPhuKien(rs.getString("PhuKien"));
//                ctsp.setTinhNang(rs.getString("TinhNang"));
//                ctsp.setNamBh(rs.getInt("NamBH"));
//                ctsp.setDonGia(rs.getString("DonGia"));
//                ctsp.setHinhDangMat(rs.getString("HinhDangMatSo"));
//                ctsp.setSoLuong(rs.getInt("SoLuongTon"));
//                ctsp.setKieuMay(rs.getString("KieuMay"));
//                ctsp.setTinhTrang(rs.getString("TinhTrang"));
//                ctsp.setKichThuoc(rs.getString("KichThuoc"));
//                listCtsp.add(ctsp);
//            }
//            rs.close();
//            ps.close();
//            conn.close();
//            return listCtsp;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
@Override
    public List<QlChiTietSanPham> timSps(String ma) {
        try {
            List<QlChiTietSanPham> listCtsp = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select ChiTietSP.Ma, SanPham.Ten, ThuongHieu.Ten as ThuongHieu, XuatXu.Ten as XuatXu, "
                    + " GioiTinh, KieuMay, TheLoai.Ten as TheLoai, PhuKien.Ten as PhuKien, TinhNang.Ten as TinhNang, "
                    + " HinhDangMatSo, ChatLieuMatKinh, ChatLieuDay.Ten as ChatLieuDay, MauMatSo.Ten as MauMatSo, "
                    + " MauVo.Ten as MauVo, KichThuoc,FORMAT(DonGia, 'c', 'vi-VN') as DonGia, NamBH, SoLuongTon, TinhTrang from ChiTietSP\n"
                    + " join SanPham on ChiTietSP.IdSp=SanPham.Id\n"
                    + " join ThuongHieu on ChiTietSP.IdThuongHieu=ThuongHieu.Id\n"
                    + " join XuatXu on ChiTietSP.IdXuatxu=XuatXu.Id\n"
                    + " join TheLoai on ChiTietSP.IdTheLoai=TheLoai.Id\n"
                    + " join ChatLieuDay on ChiTietSP.IdChatLieuDay=ChatLieuDay.Id\n"
                    + " join MauMatSo on ChiTietSP.IdMauMatSo=MauMatSo.Id\n"
                    + " join MauVo on ChiTietSP.IdMauVo=MauVo.Id\n"
                    + " join PhuKien on ChiTietSP.IdPhuKien=PhuKien.Id\n"
                    + " join TinhNang on ChiTietSP.IdTinhNang=TinhNang.Id"
                    + " where ChiTietSP.Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QlChiTietSanPham ctsp = new QlChiTietSanPham();
                ctsp.setMa(rs.getString("Ma"));
                ctsp.setTen(rs.getString("Ten"));
                ctsp.setThuongHieu(rs.getString("ThuongHieu"));
                ctsp.setXuatXu(rs.getString("XuatXu"));
                ctsp.setTheLoai(rs.getString("TheLoai"));
                ctsp.setChatLieuDay(rs.getString("ChatLieuDay"));
                ctsp.setChatLieuMat(rs.getString("ChatLieuMatKinh"));
                ctsp.setMauMat(rs.getString("MauMatSo"));
                ctsp.setMauVo(rs.getString("MauVo"));
                ctsp.setGioiTinh(rs.getString("GioiTinh"));
                ctsp.setPhuKien(rs.getString("PhuKien"));
                ctsp.setTinhNang(rs.getString("TinhNang"));
                ctsp.setNamBh(rs.getInt("NamBH"));
                ctsp.setDonGia(rs.getString("DonGia"));
                ctsp.setHinhDangMat(rs.getString("HinhDangMatSo"));
                ctsp.setSoLuong(rs.getInt("SoLuongTon"));
                ctsp.setKieuMay(rs.getString("KieuMay"));
                ctsp.setTinhTrang(rs.getString("TinhTrang"));
                ctsp.setKichThuoc(rs.getString("KichThuoc"));
                listCtsp.add(ctsp);
            }
            rs.close();
            ps.close();
            conn.close();
            return listCtsp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<ChiTietSanPham> locSpTheoTH(String th) {
        try {
            List<ChiTietSanPham> listCtsp = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select SanPham.Ma, SanPham.Ten, ThuongHieu.Ten as ThuongHieu, XuatXu.Ten as XuatXu, "
                    + " GioiTinh, KieuMay, TheLoai.Ten as TheLoai, PhuKien.Ten as PhuKien, TinhNang.Ten as TinhNang, "
                    + " HinhDangMatSo, ChatLieuMatKinh, ChatLieuDay.Ten as ChatLieuDay, MauMatSo.Ten as MauMatSo, "
                    + " MauVo.Ten as MauVo, KichThuoc,FORMAT(DonGia, 'c', 'vi-VN') as DonGia, NamBH, SoLuongTon, TinhTrang from ChiTietSP\n"
                    + " join SanPham on ChiTietSP.IdSp=SanPham.Id\n"
                    + " join ThuongHieu on ChiTietSP.IdThuongHieu=ThuongHieu.Id\n"
                    + " join XuatXu on ChiTietSP.IdXuatxu=XuatXu.Id\n"
                    + " join TheLoai on ChiTietSP.IdTheLoai=TheLoai.Id\n"
                    + " join ChatLieuDay on ChiTietSP.IdChatLieuDay=ChatLieuDay.Id\n"
                    + " join MauMatSo on ChiTietSP.IdMauMatSo=MauMatSo.Id\n"
                    + " join MauVo on ChiTietSP.IdMauVo=MauVo.Id\n"
                    + " join PhuKien on ChiTietSP.IdPhuKien=PhuKien.Id\n"
                    + " join TinhNang on ChiTietSP.IdTinhNang=TinhNang.Id"
                    + " where ThuongHieu.Ten=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, th);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham();
                ctsp.setMa(rs.getString("Ma"));
                ctsp.setTen(rs.getString("Ten"));
                ctsp.setThuongHieu(rs.getString("ThuongHieu"));
                ctsp.setXuatXu(rs.getString("XuatXu"));
                ctsp.setTheLoai(rs.getString("TheLoai"));
                ctsp.setChatLieuDay(rs.getString("ChatLieuDay"));
                ctsp.setChatLieuMat(rs.getString("ChatLieuMatKinh"));
                ctsp.setMauMat(rs.getString("MauMatSo"));
                ctsp.setMauVo(rs.getString("MauVo"));
                ctsp.setGioiTinh(rs.getString("GioiTinh"));
                ctsp.setPhuKien(rs.getString("PhuKien"));
                ctsp.setTinhNang(rs.getString("TinhNang"));
                ctsp.setNamBh(rs.getInt("NamBH"));
                ctsp.setDonGia(rs.getString("DonGia"));
                ctsp.setHinhDangMat(rs.getString("HinhDangMatSo"));
                ctsp.setSoLuong(rs.getInt("SoLuongTon"));
                ctsp.setKieuMay(rs.getString("KieuMay"));
                ctsp.setTinhTrang(rs.getString("TinhTrang"));
                ctsp.setKichThuoc(rs.getString("KichThuoc"));
                listCtsp.add(ctsp);
            }
            rs.close();
            ps.close();
            conn.close();
            return listCtsp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ChiTietSanPham> locSpTheoGT(String gt) {
        try {
            List<ChiTietSanPham> listCtsp = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select ChiTietSp.Ma, SanPham.Ten, ThuongHieu.Ten as ThuongHieu, XuatXu.Ten as XuatXu, "
                    + " GioiTinh, KieuMay, TheLoai.Ten as TheLoai, PhuKien.Ten as PhuKien, TinhNang.Ten as TinhNang, "
                    + " HinhDangMatSo, ChatLieuMatKinh, ChatLieuDay.Ten as ChatLieuDay, MauMatSo.Ten as MauMatSo, "
                    + " MauVo.Ten as MauVo, KichThuoc,FORMAT(DonGia, 'c', 'vi-VN') as DonGia, NamBH, SoLuongTon, TinhTrang from ChiTietSP\n"
                    + " join SanPham on ChiTietSP.IdSp=SanPham.Id\n"
                    + " join ThuongHieu on ChiTietSP.IdThuongHieu=ThuongHieu.Id\n"
                    + " join XuatXu on ChiTietSP.IdXuatxu=XuatXu.Id\n"
                    + " join TheLoai on ChiTietSP.IdTheLoai=TheLoai.Id\n"
                    + " join ChatLieuDay on ChiTietSP.IdChatLieuDay=ChatLieuDay.Id\n"
                    + " join MauMatSo on ChiTietSP.IdMauMatSo=MauMatSo.Id\n"
                    + " join MauVo on ChiTietSP.IdMauVo=MauVo.Id\n"
                    + " join PhuKien on ChiTietSP.IdPhuKien=PhuKien.Id\n"
                    + " join TinhNang on ChiTietSP.IdTinhNang=TinhNang.Id"
                    + " where GioiTinh=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, gt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham();
                ctsp.setMa(rs.getString("Ma"));
                ctsp.setTen(rs.getString("Ten"));
                ctsp.setThuongHieu(rs.getString("ThuongHieu"));
                ctsp.setXuatXu(rs.getString("XuatXu"));
                ctsp.setTheLoai(rs.getString("TheLoai"));
                ctsp.setChatLieuDay(rs.getString("ChatLieuDay"));
                ctsp.setChatLieuMat(rs.getString("ChatLieuMatKinh"));
                ctsp.setMauMat(rs.getString("MauMatSo"));
                ctsp.setMauVo(rs.getString("MauVo"));
                ctsp.setGioiTinh(rs.getString("GioiTinh"));
                ctsp.setPhuKien(rs.getString("PhuKien"));
                ctsp.setTinhNang(rs.getString("TinhNang"));
                ctsp.setNamBh(rs.getInt("NamBH"));
                ctsp.setDonGia(rs.getString("DonGia"));
                ctsp.setHinhDangMat(rs.getString("HinhDangMatSo"));
                ctsp.setSoLuong(rs.getInt("SoLuongTon"));
                ctsp.setKieuMay(rs.getString("KieuMay"));
                ctsp.setTinhTrang(rs.getString("TinhTrang"));
                ctsp.setKichThuoc(rs.getString("KichThuoc"));
                listCtsp.add(ctsp);
            }
            rs.close();
            ps.close();
            conn.close();
            return listCtsp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ChiTietSanPham> locSpTheoTT(String tt) {
        try {
            List<ChiTietSanPham> listCtsp = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select SanPham.Ma, SanPham.Ten, ThuongHieu.Ten as ThuongHieu, XuatXu.Ten as XuatXu, "
                    + " GioiTinh, KieuMay, TheLoai.Ten as TheLoai, PhuKien.Ten as PhuKien, TinhNang.Ten as TinhNang, "
                    + " HinhDangMatSo, ChatLieuMatKinh, ChatLieuDay.Ten as ChatLieuDay, MauMatSo.Ten as MauMatSo, "
                    + " MauVo.Ten as MauVo, KichThuoc,FORMAT(DonGia, 'c', 'vi-VN') as DonGia, NamBH, SoLuongTon, TinhTrang from ChiTietSP\n"
                    + " join SanPham on ChiTietSP.IdSp=SanPham.Id\n"
                    + " join ThuongHieu on ChiTietSP.IdThuongHieu=ThuongHieu.Id\n"
                    + " join XuatXu on ChiTietSP.IdXuatxu=XuatXu.Id\n"
                    + " join TheLoai on ChiTietSP.IdTheLoai=TheLoai.Id\n"
                    + " join ChatLieuDay on ChiTietSP.IdChatLieuDay=ChatLieuDay.Id\n"
                    + " join MauMatSo on ChiTietSP.IdMauMatSo=MauMatSo.Id\n"
                    + " join MauVo on ChiTietSP.IdMauVo=MauVo.Id\n"
                    + " join PhuKien on ChiTietSP.IdPhuKien=PhuKien.Id\n"
                    + " join TinhNang on ChiTietSP.IdTinhNang=TinhNang.Id"
                    + " where TinhTrang=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham();
                ctsp.setMa(rs.getString("Ma"));
                ctsp.setTen(rs.getString("Ten"));
                ctsp.setThuongHieu(rs.getString("ThuongHieu"));
                ctsp.setXuatXu(rs.getString("XuatXu"));
                ctsp.setTheLoai(rs.getString("TheLoai"));
                ctsp.setChatLieuDay(rs.getString("ChatLieuDay"));
                ctsp.setChatLieuMat(rs.getString("ChatLieuMatKinh"));
                ctsp.setMauMat(rs.getString("MauMatSo"));
                ctsp.setMauVo(rs.getString("MauVo"));
                ctsp.setGioiTinh(rs.getString("GioiTinh"));
                ctsp.setPhuKien(rs.getString("PhuKien"));
                ctsp.setTinhNang(rs.getString("TinhNang"));
                ctsp.setNamBh(rs.getInt("NamBH"));
                ctsp.setDonGia(rs.getString("DonGia"));
                ctsp.setHinhDangMat(rs.getString("HinhDangMatSo"));
                ctsp.setSoLuong(rs.getInt("SoLuongTon"));
                ctsp.setKieuMay(rs.getString("KieuMay"));
                ctsp.setTinhTrang(rs.getString("TinhTrang"));
                ctsp.setKichThuoc(rs.getString("KichThuoc"));
                listCtsp.add(ctsp);
            }
            rs.close();
            ps.close();
            conn.close();
            return listCtsp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<QlChiTietSanPham> addsp(QlChiTietSanPham sp) {
 String sql = """
        insert into ChiTietSP
                    (Ma
                    ,IdSp
                    ,IdThuongHieu
                    ,IdXuatxu
                      ,IdTheLoai
                         ,IdChatLieuDay
                           ,IdMauMatSo
                          ,IdMauVo
                           ,IdPhuKien
                         ,IdTinhNang
                      ,HinhDangMatSo
                     ,ChatLieuMatKinh
                    ,GioiTinh
                    ,KieuMay
                      ,NamBH
                         ,KichThuoc
                        ,SoLuongTon
                           ,DonGia
                         ,TinhTrang)
                    values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) """;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, sp.getMa());
            ps.setString(2, sp.getTen());
            ps.setString(3, sp.getThuongHieu());
            ps.setString(4, sp.getXuatXu());
            ps.setString(5, sp.getTheLoai());
            ps.setString(6, sp.getChatLieuDay());
            ps.setString(7, sp.getMauMat());
            ps.setString(8, sp.getMauVo());
            ps.setString(9, sp.getPhuKien());
            ps.setString(10, sp.getTinhNang());
            ps.setString(11, sp.getHinhDangMat());
            ps.setString(12, sp.getChatLieuMat());
            ps.setString(13, sp.getGioiTinh());
            ps.setString(14, sp.getKieuMay());
            ps.setInt(15, sp.getNamBh());
            ps.setString(16, sp.getKichThuoc());
            ps.setInt(17, sp.getSoLuong());
            ps.setString(18, sp.getDonGia());
            ps.setString(19, sp.getTinhTrang());
           ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ChiTietSanPham> getAllCtsp() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChiTietSanPham> timSp(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String updates(QlChiTietSanPham sp) {
 String sql = """
        update ChiTietSP  
                   set  IdSp= ?
                    ,IdThuongHieu = ?
                    ,IdXuatxu = ?
                      ,IdTheLoai= ?
                         ,IdChatLieuDay = ?
                           ,IdMauMatSo = ?
                          ,IdMauVo = ?
                           ,IdPhuKien = ?
                         ,IdTinhNang= ?
                      ,HinhDangMatSo= ?
                     ,ChatLieuMatKinh= ?
                    ,GioiTinh = ?
                    ,KieuMay = ?
                      ,NamBH = ?
                         ,KichThuoc = ?
                        ,SoLuongTon = ?
                           ,DonGia = ?
                         ,TinhTrang = ?
              where ChiTietSP.Ma = ?""";
     try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(19, sp.getMa());
            ps.setObject(1, sp.getTen());
            ps.setObject(2, sp.getThuongHieu());
            ps.setObject(3, sp.getXuatXu());
            ps.setObject(4, sp.getTheLoai());
            ps.setObject(5, sp.getChatLieuDay());
            ps.setObject(6, sp.getMauMat());
            ps.setObject(7, sp.getMauVo());
            ps.setObject(8, sp.getPhuKien());
            ps.setObject(9, sp.getTinhNang());
            ps.setObject(10, sp.getHinhDangMat());
            ps.setObject(11, sp.getChatLieuMat());
            ps.setObject(12, sp.getGioiTinh());
            ps.setObject(13, sp.getKieuMay());
            ps.setInt(14, sp.getNamBh());
            ps.setObject(15, sp.getKichThuoc());
            ps.setInt(16, sp.getSoLuong());
            ps.setObject(17, sp.getDonGia());
            ps.setObject(18, sp.getTinhTrang());
          ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String delete(String maNV) {
         try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from ChiTietSP where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNV);
           ps.executeUpdate();
            ps.close();
            conn.close();
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
