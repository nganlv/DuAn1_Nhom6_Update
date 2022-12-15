/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModels.ChatLieuDay;
import ViewModels.QlChatLieuDay;
import ViewModels.QlHinhDangMat;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IHinhDangMatSer {
    public List<QlHinhDangMat> getAllHdms();
    public Integer addHdms(QlHinhDangMat cld);
    public Integer updateHdms(QlHinhDangMat cld);
    public Integer deleteHdms(String ma);
}
