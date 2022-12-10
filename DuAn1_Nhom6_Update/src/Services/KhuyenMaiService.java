/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import ViewModels.QlKhuyenMai;
import DomainModels.KhuyenMai;
import java.util.*;
import Repository.KhuyenMaiRepo;
import Repository.Interface.IKhuyenMai;
import Service.Interface.IKhuyenMaiService;

/**
 *
 * @author pc
 */
public class KhuyenMaiService implements IKhuyenMaiService{
     private final IKhuyenMai iKmRepo = new KhuyenMaiRepo();

    @Override
    public List<QlKhuyenMai> getAlls() {
        try {
            List<QlKhuyenMai> listSp = new ArrayList<>();
            for (KhuyenMai sp : iKmRepo.getAll()) {
                listSp.add(new QlKhuyenMai( sp.getId(),sp.getMa(), sp.getTen(), sp.getNgayBD(), sp.getNgayKT(), sp.getGiagia()));
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(QlKhuyenMai sp) {
        try {
             iKmRepo.addDongSp(new KhuyenMai(sp.getId(), sp.getMa(), sp.getTen(), sp.getNgayBD(), sp.getNgayKT(), sp.getGiagia()));
        } catch (Exception e) {
            e.printStackTrace();
        }
      
    }

    @Override
    public void update(QlKhuyenMai sp) {
        try {
             iKmRepo.updateSp(new KhuyenMai( sp.getId(),sp.getMa(), sp.getTen(), sp.getNgayBD(), sp.getNgayKT(), sp.getGiagia()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void delete(String ma) {
        try {
             iKmRepo.deleteSp(ma);
        } catch (Exception e) {
            e.printStackTrace();
        }
      
    }
}
