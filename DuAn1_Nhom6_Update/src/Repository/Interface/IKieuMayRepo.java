/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModels.ChatLieuDay;
import DomainModels.KieuMay;
import java.util.List;

/**
 *
 * @author levan
 */
public interface IKieuMayRepo {
    public List<KieuMay> getAllKm();
   public Integer addKm(KieuMay km);
   public Integer updateKm(KieuMay km);
   public Integer deleteKm(String ma);
}
