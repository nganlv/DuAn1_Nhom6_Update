/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModels.ChatLieuDay;
import ViewModels.QlChatLieuDay;
import ViewModels.QlKieuMay;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IKieuMaySer {
    public List<QlKieuMay> getAllKms();
    public Integer addKms(QlKieuMay cld);
    public Integer updateKms(QlKieuMay cld);
    public Integer deleteKms(String ma);
}
