/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBContext;
import ViewModels.KhachHang;

import java.util.ArrayList;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Acer
 */
public class KhachHangRepo {

    public ArrayList<KhachHang> getAll() throws Exception {
        ArrayList<KhachHang> Kh = new ArrayList();
        Connection con = DBContext.getConnection();
        String sql = "SELECT Ma, HoTen, GioiTinh, NgaySinh, Sdt, DiaChi, Email, NgayTao, NgayHetHan, Diem FROM KhachHang";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Kh.add(new KhachHang(
                    rs.getString("Ma"),
                    rs.getString("Hoten"),
                    rs.getString("GioiTinh"),
                    rs.getString("Sdt"),
                    rs.getString("DiaChi"),
                    rs.getString("Email"),
                    rs.getString("Diem"),
                    rs.getString("NgaySinh"),
                    rs.getString("NgayTao"),
                    rs.getString("NgayHetHan")
            ));
        }

        return Kh;
    }

    public Integer insert(KhachHang kh) throws Exception {
        String sql = " INSERT INTO KhachHang"
                + "         (Ma, HoTen, GioiTinh, Sdt, DiaChi, Email, Diem, NgaySinh, NgayTao, NgayHetHan)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getHoTen());
            ps.setString(3, kh.getGioiTinh());
            ps.setString(4, kh.getSdt());

            ps.setString(5, kh.getDiaChi());
            ps.setString(6, kh.getEmail());
            ps.setString(7, kh.getDiem());

            ps.setString(8, kh.getNgaysinh());
            ps.setString(9, kh.getNgayTao());
            ps.setString(10, kh.getNgayHetHan());

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Integer deleteK(String maKH) {
        String sql = "DELETE FROM KhachHang where Ma = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maKH);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;

    }

    public Integer updateK(KhachHang kh) {
        String sql = "UPDATE KhachHang SET HoTen =?, GioiTinh =?, NgaySinh =?, Sdt =?, DiaChi =?, Email =?, NgayTao =?, NgayHetHan =?, Diem =? where  Ma = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, kh.getHoTen());
            ps.setObject(2, kh.getGioiTinh());
            ps.setObject(3, kh.getNgaysinh());
            ps.setObject(4, kh.getSdt());
            ps.setObject(5, kh.getDiaChi());
            ps.setObject(6, kh.getEmail());
            ps.setObject(7, kh.getNgayTao());
            ps.setObject(8, kh.getNgayHetHan());
            ps.setObject(9, kh.getDiem());
            ps.setObject(10, kh.getMaKH());
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<KhachHang> getTim(String ma) throws Exception {
        
    ArrayList<KhachHang> kh = new ArrayList<>();
        
        
         Connection con = DBContext.getConnection(); 
         String sql = "SELECT Ma, HoTen, GioiTinh, NgaySinh, Sdt, DiaChi, Email, NgayTao, NgayHetHan, Diem FROM KhachHang where Ma = ?"; 
         PreparedStatement ps = con.prepareStatement(sql); 
            ps.setString(1,ma );

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang nv = new KhachHang();
                nv.setMaKH(rs.getString("Ma"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setNgaysinh(rs.getString("NgaySinh"));
                nv.setSdt(rs.getString("Sdt"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setEmail(rs.getString("Email"));
                nv.setNgayTao(rs.getString("NgayTao"));
                nv.setNgayHetHan(rs.getString("NgayHetHan"));
                nv.setDiem(rs.getString("Diem"));
                kh.add(nv);

            }

        return kh;
    }
     public ArrayList<KhachHang> getloc(String gt) {
        ArrayList<KhachHang> listKh = new ArrayList<>();
        String sql = "SELECT Ma, HoTen, GioiTinh, NgaySinh, Sdt, DiaChi, Email, NgayTao, NgayHetHan,Diem FROM     KhachHang where GioiTinh = ? ";
                                          

        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, gt);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang nv = new KhachHang();
                nv.setMaKH(rs.getString("Ma"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setNgaysinh(rs.getString("NgaySinh"));
                nv.setSdt(rs.getString("Sdt"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setEmail(rs.getString("Email"));
                nv.setNgayTao(rs.getString("NgayTao"));
                nv.setNgayHetHan(rs.getString("NgayHetHan"));
                nv.setDiem(rs.getString("Diem"));
                listKh.add(nv);

            }
            rs.close();
            ps.close();
            con.close();
            return listKh;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
