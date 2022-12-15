/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.ChatLieuDay;
import DomainModels.ChatLieuMat;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IChatLieuMatRepo {
    public List<ChatLieuMat> getAllClm();
   public Integer addClm(ChatLieuMat clm);
   public Integer updateClm(ChatLieuMat clm);
   public Integer deleteClm(String ma);
}
