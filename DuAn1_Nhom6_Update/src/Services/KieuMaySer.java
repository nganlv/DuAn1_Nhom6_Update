/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.KieuMay;
import DomainModels.MauVo;
import Repository.Interface.IKieuMayRepo;
import Repository.Interface.IMauVoRepo;
import Repository.KieuMayRepo;
import Repository.MauVoRepo;
import Service.Interface.IKieuMaySer;
import ViewModels.QlKieuMay;
import ViewModels.QlMauVo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levan
 */
public class KieuMaySer implements IKieuMaySer{
    private final IKieuMayRepo iKieuMayRepo = new KieuMayRepo();

    @Override
    public List<QlKieuMay> getAllKms() {
        try {
            List<QlKieuMay> listMv = new ArrayList<>();
            for (KieuMay mv : iKieuMayRepo.getAllKm()) {
                listMv.add(new QlKieuMay(mv.getId(), mv.getMa(), mv.getTen()));
            }
            return listMv;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     

    @Override
    public Integer addKms(QlKieuMay mv) {
        try {
            return iKieuMayRepo.addKm(new KieuMay(mv.getId(), mv.getMa(), mv.getTen()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updateKms(QlKieuMay mv) {
        try {
            return iKieuMayRepo.updateKm(new KieuMay(mv.getId(), mv.getMa(), mv.getTen()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer deleteKms(String ma) {
        try {
            return iKieuMayRepo.deleteKm(ma);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
