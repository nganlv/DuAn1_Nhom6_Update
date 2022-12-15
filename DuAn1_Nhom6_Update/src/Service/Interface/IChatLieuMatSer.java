/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModels.ChatLieuDay;
import ViewModels.QlChatLieuDay;
import ViewModels.QlChatLieuMat;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IChatLieuMatSer {
    public List<QlChatLieuMat> getAllClms();
    public Integer addClms(QlChatLieuMat cld);
    public Integer updateClms(QlChatLieuMat cld);
    public Integer deleteClms(String ma);
}
