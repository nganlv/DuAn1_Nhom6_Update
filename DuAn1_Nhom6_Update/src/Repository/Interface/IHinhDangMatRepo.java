/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.ChatLieuDay;
import DomainModels.HinhDangMat;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IHinhDangMatRepo {
    public List<HinhDangMat> getAllHdm();
   public Integer addHdm(HinhDangMat hdm);
   public Integer updateHdm(HinhDangMat hdm);
   public Integer deleteHdm(String ma);
}
