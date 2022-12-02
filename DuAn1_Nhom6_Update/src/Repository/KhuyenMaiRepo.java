package Repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import DomainModels.KhuyenMai;
import Repository.Interface.IKhuyenMai;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utilities.DBContext;

/**
 *
 * @author pc
 */
public class KhuyenMaiRepo implements IKhuyenMai {

    @Override
    public List<KhuyenMai> getAll() {
        try {
            List<KhuyenMai> ds = new ArrayList<>();
            String sql = "SELECT Ma, Ten, NgayBatDau, NgayKetThuc, GiamGia\n"
                    + "FROM     KhuyenMai";
            Connection conn = DBContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai sp = new KhuyenMai();

                sp.setMa(rs.getString("Ma"));
                sp.setTen(rs.getString("Ten"));
                sp.setNgayBD(rs.getString("NgayBatDau"));
                sp.setNgayKT(rs.getString("NgayKetThuc"));
                sp.setGiagia(rs.getString("GiamGia"));

                ds.add(sp);
            }
            rs.close();
            ps.close();
            conn.close();
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean addDongSp(KhuyenMai sp) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "INSERT INTO [dbo].[KhuyenMai]\n"
                    + "           ([Id]\n"
                    + "           ,[Ma]\n"
                    + "           ,[Ten]\n"
                    + "           ,[NgayBatDau]\n"
                    + "           ,[NgayKetThuc]\n"
                    + "           ,[GiamGia])\n"
                    + "     VALUES\n"
                    + "           (newid()\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMa());
            ps.setString(2, sp.getTen());
            ps.setString(3, sp.getNgayBD());
            ps.setString(4, sp.getNgayKT());
            ps.setString(5, sp.getGiagia());
            boolean kq = ps.executeUpdate() > 0;
            ps.close();
            conn.close();
            return kq;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updateSp(KhuyenMai sp) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "UPDATE [dbo].[KhuyenMai]\n"
                    + "   SET \n"
                    + "     \n"
                    + "      [Ten] =?\n"
                    + "      ,[NgayBatDau] = ?\n"
                    + "      ,[NgayKetThuc] = ?\n"
                    + "      ,[GiamGia] = ?\n"
                    + " WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(5, sp.getMa());
            ps.setString(1, sp.getTen());
            ps.setString(2, sp.getNgayBD());
            ps.setString(3, sp.getNgayKT());
            ps.setString(4, sp.getGiagia());
            boolean kq = ps.executeUpdate() > 0;
            ps.close();
            conn.close();
            return kq;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean deleteSp(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from KhuyenMai where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            boolean kq = ps.executeUpdate() > 0;
            ps.close();
            conn.close();
            return kq;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }
}
