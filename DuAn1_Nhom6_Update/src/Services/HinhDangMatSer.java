/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChatLieuMat;
import DomainModels.HinhDangMat;
import Repository.ChatLieuMatRepo;
import Repository.HinhDangMatRepo;
import Repository.Interface.IChatLieuMatRepo;
import Repository.Interface.IHinhDangMatRepo;
import Service.Interface.IHinhDangMatSer;
import ViewModels.QlChatLieuMat;
import ViewModels.QlHinhDangMat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class HinhDangMatSer implements IHinhDangMatSer{
     private final IHinhDangMatRepo iHinhDangMatRepo = new HinhDangMatRepo();

    @Override
    public List<QlHinhDangMat> getAllHdms() {
        try {
            List<QlHinhDangMat> listCld = new ArrayList<>();
            for (HinhDangMat cld : iHinhDangMatRepo.getAllHdm()) {
                listCld.add(new QlHinhDangMat(cld.getId(), cld.getMa(), cld.getTen()));
            }
            return listCld;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addHdms(QlHinhDangMat cld) {
        try {
            return iHinhDangMatRepo.addHdm(new HinhDangMat(cld.getId(), cld.getMa(), cld.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

     @Override
    public Integer updateHdms(QlHinhDangMat cld) {
        try {
            return iHinhDangMatRepo.updateHdm(new HinhDangMat(cld.getId(), cld.getMa(), cld.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

     @Override
    public Integer deleteHdms(String ma) {
        try {
            return iHinhDangMatRepo.deleteHdm(ma);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
