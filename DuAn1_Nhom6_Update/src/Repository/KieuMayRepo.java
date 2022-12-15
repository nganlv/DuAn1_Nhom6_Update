/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ChatLieuMat;
import DomainModels.KieuMay;
import Repository.Interface.IKieuMayRepo;
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
public class KieuMayRepo implements IKieuMayRepo{
    @Override
    public List<KieuMay> getAllKm() {
        try {
            List<KieuMay> listCld = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select * from KieuMay";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KieuMay cld = new KieuMay();
                cld.setId(rs.getString("Id"));
                cld.setMa(rs.getString("Ma"));
                cld.setTen(rs.getString("Ten"));
                listCld.add(cld);
            }
            rs.close();
            ps.close();
            conn.close();
            return listCld;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addKm(KieuMay clm) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into KieuMay values(newid(),?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, clm.getMa());
            ps.setString(2, clm.getTen());
            int add = ps.executeUpdate();
            ps.close();
            conn.close();
            return add;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updateKm(KieuMay clm) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update KieuMay set Ten=? where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(2, clm.getMa());
            ps.setString(1, clm.getTen());
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
    public Integer deleteKm(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from KieuMay where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            int delete = ps.executeUpdate();
            ps.close();
            conn.close();
            return delete;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
