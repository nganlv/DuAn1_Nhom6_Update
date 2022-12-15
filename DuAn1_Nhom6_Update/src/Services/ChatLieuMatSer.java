/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChatLieuDay;
import DomainModels.ChatLieuMat;
import Repository.ChatLieuDayRepo;
import Repository.ChatLieuMatRepo;
import Repository.Interface.IChatLieuDayRepo;
import Repository.Interface.IChatLieuMatRepo;
import Service.Interface.IChatLieuMatSer;
import ViewModels.QlChatLieuDay;
import ViewModels.QlChatLieuMat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class ChatLieuMatSer implements IChatLieuMatSer{
    private final IChatLieuMatRepo iChatLieuMatRepo = new ChatLieuMatRepo();

    @Override
    public List<QlChatLieuMat> getAllClms() {
        try {
            List<QlChatLieuMat> listCld = new ArrayList<>();
            for (ChatLieuMat cld : iChatLieuMatRepo.getAllClm()) {
                listCld.add(new QlChatLieuMat(cld.getId(), cld.getMa(), cld.getTen()));
            }
            return listCld;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer addClms(QlChatLieuMat cld) {
        try {
            return iChatLieuMatRepo.addClm(new ChatLieuMat(cld.getId(), cld.getMa(), cld.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updateClms(QlChatLieuMat cld) {
        try {
            return iChatLieuMatRepo.updateClm(new ChatLieuMat(cld.getId(), cld.getMa(), cld.getTen()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer deleteClms(String ma) {
        try {
            return iChatLieuMatRepo.deleteClm(ma);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
