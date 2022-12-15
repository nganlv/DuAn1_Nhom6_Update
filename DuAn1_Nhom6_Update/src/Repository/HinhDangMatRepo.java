/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ChatLieuDay;
import DomainModels.HinhDangMat;
import Repository.Interface.IHinhDangMatRepo;
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
public class HinhDangMatRepo implements IHinhDangMatRepo{
    @Override
    public List<HinhDangMat> getAllHdm() {
        try {
            List<HinhDangMat> listHdm = new ArrayList<>();
            Connection conn = DBContext.getConnection();
            String sql = "select * from HinhDangMat";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HinhDangMat cld = new HinhDangMat();
                cld.setId(rs.getString("Id"));
                cld.setMa(rs.getString("Ma"));
                cld.setTen(rs.getString("Ten"));
                listHdm.add(cld);
            }
            rs.close();
            ps.close();
            conn.close();
            return listHdm;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addHdm(HinhDangMat cld) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into HinhDangMat values(newid(),?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cld.getMa());
            ps.setString(2, cld.getTen());
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
    public Integer updateHdm(HinhDangMat cld) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update HinhDangMat set Ten=? where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(2, cld.getMa());
            ps.setString(1, cld.getTen());
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
    public Integer deleteHdm(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from HinhDangMat where Ma=?";
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
