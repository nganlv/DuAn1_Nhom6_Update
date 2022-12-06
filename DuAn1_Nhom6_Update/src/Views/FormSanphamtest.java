/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.ChatLieuDay;
import DomainModels.ChiTietSanPham;
import DomainModels.MauMatSo;
import DomainModels.MauVo;
import DomainModels.PhuKien;
import DomainModels.SanPham;
import DomainModels.TheLoai;
import DomainModels.ThuongHieu;
import DomainModels.TinhNang;
import DomainModels.XuatXu;
import Service.Interface.IChatLieuDaySer;
import Service.Interface.IChiTietSanPhamService;
import Service.Interface.IMauMatSoSer;
import Service.Interface.IMauVoSer;
import Service.Interface.IPhuKienSer;
import Service.Interface.ISanPhamSer;
import Service.Interface.ITheLoaiSer;
import Service.Interface.IThuongHieuSer;
import Service.Interface.ITinhNangSer;
import Service.Interface.IXuatXuSer;
import Services.ChatLieuDayService;
import Services.ChiTietSanPhamService;
import Services.MauMatSoService;
import Services.MauVoService;
import Services.PhuKienService;
import Services.SanPhamService;
import Services.TheLoaiService;
import Services.ThuongHieuService;
import Services.TinhNangService;
import Services.XuatXuService;
import ViewModels.QlChatLieuDay;
import ViewModels.QlChiTietSanPham;
import ViewModels.QlMauMatSo;
import ViewModels.QlMauVo;
import ViewModels.QlPhuKien;
import ViewModels.QlSanPham;
import ViewModels.QlTheLoai;
import ViewModels.QlThuongHieu;
import ViewModels.QlTinhNang;
import ViewModels.QlXuatXu;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguye
 */
public class FormSanphamtest extends javax.swing.JFrame {
private final IChiTietSanPhamService iChiTietSanPhamService = new ChiTietSanPhamService();
    private final ISanPhamSer iSanPhamSer = new SanPhamService();
    private final IThuongHieuSer iThuongHieuSer = new ThuongHieuService();
    private final IXuatXuSer iXuatXuSer = new XuatXuService();
    private final IChatLieuDaySer iChatLieuDaySer = new ChatLieuDayService();
    private IMauMatSoSer iMauMatSoSer = new MauMatSoService();
    private final IMauVoSer iMauVoSer = new MauVoService();
    private final IPhuKienSer iPhuKienSer = new PhuKienService();
    private final ITinhNangSer iTinhNangSer = new TinhNangService();
    private final ITheLoaiSer iTheLoaiSer = new TheLoaiService();
    /**
     * Creates new form FormSanphamtest
     */
    public FormSanphamtest() {
        initComponents();
        loadCombobox();
        loadCbSp();
        loadCbTh();
        loadCbXx();
        loadCbTl();
        loadCbCld();
        loadCbMms();
        loadCbMv();
        loadCbPk();
        loadCbTn();
        loadTableCtsp();
    }
 private void loadTableCtsp() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã", "Tên", "Thương hiệu", "Xuất xứ", "Giới tính", "Kiểu máy", "Thể loại", "Phụ kiện", "Tính năng", "Hình dạng mặt", "Chất liệu mặt", "Chất liệu dây", "Màu mặt số", "Màu vỏ", "Kích thước", "Đơn giá", "Năm bảo hành", "Số lượng tồn", "Tình trạng"});
       List<QlChiTietSanPham> listCtsp = iChiTietSanPhamService.getAllCtsps();
       if (listCtsp == null) {
          JOptionPane.showMessageDialog(this, "Rỗng");
          return;
       }
       for (QlChiTietSanPham ctsp : listCtsp) {
            model.addRow(new Object[]{ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
               ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.getTinhTrang()});
        }
       tblChiTietSp.setModel(model);
   }    

    public ChiTietSanPham getData(){
    ChiTietSanPham sp=new ChiTietSanPham();
    sp.setMa(txtMa.getText().trim());
    sp.setKieuMay(txtKieuMay.getText().trim());
    sp.setHinhDangMat(txtHinhDangMat.getText().trim());
    sp.setChatLieuMat(txtChatLieuMat.getText().trim());
    sp.setKichThuoc(txtKichThuoc.getText().trim());
    sp.setDonGia(txtDonGia.getText().trim());
    sp.setSoLuong(Integer.parseInt(txtSoLuongTon.getText().trim()));
    SanPham sp122=(SanPham) cboTen.getSelectedItem();
    ThuongHieu th=(ThuongHieu)cboThuongHieu.getSelectedItem();
    XuatXu xx=(XuatXu) cboXuatXu.getSelectedItem();
    TheLoai tl=(TheLoai) cboTheLoai.getSelectedItem();
    PhuKien pk=(PhuKien) cboPhuKien.getSelectedItem();
    TinhNang tn=(TinhNang)  cboTinhNang.getSelectedItem();
    ChatLieuDay cld=(ChatLieuDay) cboChatLieuDay.getSelectedItem();
    MauMatSo mms=(MauMatSo) cboMauMatSo.getSelectedItem();
    MauVo mv=(MauVo) cboMauVo.getSelectedItem();
    sp.setTen(sp122.getId());
    sp.setThuongHieu(th.getId());
    sp.setXuatXu(xx.getId());
    sp.setTheLoai(tl.getId());
    sp.setPhuKien(pk.getId());
    sp.setTinhNang(tn.getId());
    sp.setChatLieuDay(cld.getId());
    sp.setMauMat(mms.getId());
    sp.setMauVo(mv.getId());
       
        if(rdoGioiTinh.isSelected()){
            sp.setGioiTinh("Nam");
        }else{
            sp.setGioiTinh("Nữ");
        }
    if(rdDangkd.isSelected()){
        sp.setTinhTrang("Còn kinh doanh");
    }else{
    sp.setTinhTrang("Ngừng kinh doanh");
    }
    return sp;
}
    public  boolean CheckValidate(){
        if(txtChatLieuMat.getText().isBlank()||txtDonGia.getText().isBlank()||txtHinhDangMat.getText().isBlank()||txtKichThuoc.getText().isBlank()||txtKieuMay.getText().isBlank()||txtMa.getText().isBlank()||txtNamBh.getText().isBlank()||txtSoLuongTon.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu ");
         return false;
        }
        if(txtMa.getText().trim().length()>10){
         JOptionPane.showMessageDialog(this, "mã san pham không quá 10 ký tu");
         return false;
           
    }
         if(!rdoGioiTinh.isSelected()&&!rdNu.isSelected()){
         JOptionPane.showMessageDialog(this,"Phải chọn 1 giới tính");
         return false;
     }
          
         if(!rdDangkd.isSelected()&&!rdDaNghi.isSelected()){
         JOptionPane.showMessageDialog(this,"Phải chọn 1 trang thái");
         return false;
     }
          try {
            int namBH = Integer.parseInt(txtNamBh.getText());
            if (namBH < 0 || namBH > 10) {
                JOptionPane.showMessageDialog(this, "Năm bảo hành không được nhỏ hơn 0 hoặc lớn hơn 10");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Năm bảo hành phải là số nguyên");
            return false;
        }
          try {
            int kt = Integer.parseInt(txtSoLuongTon.getText());
            if (kt < 0 ) {
                JOptionPane.showMessageDialog(this, "so luong ton phai lon hon 0");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "so luong ton phải là số nguyên");
            return false;
        }
          try {
            int kt = Integer.parseInt(txtDonGia.getText());
            if (kt < 0 ) {
                JOptionPane.showMessageDialog(this, "so luong ton phai lon hon 0");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "don gia phải là số !");
            return false;
        }
          
        if (txtMa.getText().trim().length() > 10) {
            JOptionPane.showMessageDialog(this, "mã không quá 10 ký tu!");
            return false;
        }
          return true;
    }
    private void loadCombobox() {
        
        String[] gioiTinh = {"Nam", "Nữ"};
        String[]tinhTrang={"Còn kinh doanh","Ngừng kinh doanh"};
        cboGioiTinh.setModel(new DefaultComboBoxModel<>(gioiTinh));
        cboTinhTrang.setModel(new DefaultComboBoxModel<>(tinhTrang));
    }

    private void loadCbSp() {
        List<SanPham> listSp = iSanPhamSer.getAllSp();
        
        for (SanPham sp : listSp) {
            cboTen.addItem(sp);
        }
    }

    private void loadCbTh() {
        List<ThuongHieu> listTh = iThuongHieuSer.getAllTh();
        if (listTh == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        }
        for (ThuongHieu th : listTh) {
           cboThuongHieu.addItem(th);
           cboThuongHieu2.addItem(th.getTen());
        }

    }

    private void loadCbXx() {
        List<XuatXu> listXx = iXuatXuSer.getAllXx();
        if (listXx == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        }
        for (XuatXu xx : listXx) {
            cboXuatXu.addItem(xx);
        }
    }

    private void loadCbTl() {
        List<TheLoai> listTl = iTheLoaiSer.getAllTl();
        if (listTl == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        }
        for (TheLoai tl : listTl) {
            cboTheLoai.addItem(tl);
        }
    }

    private void loadCbCld() {
        List<ChatLieuDay> listCld = iChatLieuDaySer.getAllCld();
        if (listCld == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        }
        for (ChatLieuDay cld : listCld) {
            cboChatLieuDay.addItem(cld);
        }
    }

    private void loadCbMms() {
        List<MauMatSo> listMms = iMauMatSoSer.getAllMms();
        if (listMms == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        }
        for (MauMatSo mms : listMms) {
            cboMauMatSo.addItem(mms);
        }
    }

    private void loadCbMv() {
        List<MauVo> listMv = iMauVoSer.getAllMv();
        if (listMv == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        }
        for (MauVo mv : listMv) {
            cboMauVo.addItem(mv);
        }
    }

    private void loadCbPk() {
        List<PhuKien> listPk = iPhuKienSer.getAllPk();
        if (listPk == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        }
        for (PhuKien pk : listPk) {
            cboPhuKien.addItem(pk);
        }
    }

    private void loadCbTn() {
        List<TinhNang> listTn = iTinhNangSer.getAllTn();
        if (listTn == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        }
        for (TinhNang tn : listTn) {
            cboTinhNang.addItem(tn);
        }
    }
     public void loadTextField(){
         int index=tblChiTietSp.getSelectedRow();
         txtMa.setText(tblChiTietSp.getValueAt(index, 0).toString());
             for (int i = 0; i < cboTen.getItemCount(); i++) {
         SanPham ch =cboTen.getItemAt(i);
            if (ch.getTen().equalsIgnoreCase(tblChiTietSp.getValueAt(index, 1).toString())) {
               cboTen.setSelectedIndex(i);
                break;
            }
        }
                 for (int i = 0; i <cboThuongHieu.getItemCount(); i++) {
            ThuongHieu ch =cboThuongHieu.getItemAt(i);
            if (ch.getTen().equalsIgnoreCase(tblChiTietSp.getValueAt(index, 2).toString())) {
              cboThuongHieu.setSelectedIndex(i);
                break;
            }
        }
        for (int i = 0; i < cboXuatXu.getItemCount(); i++) {
           XuatXu ch =cboXuatXu.getItemAt(i);
            if (ch.getTen().equalsIgnoreCase(tblChiTietSp.getValueAt(index, 3).toString())) {
               cboXuatXu.setSelectedIndex(i);
                break;
            }
        }
        if(tblChiTietSp.getValueAt(index, 4).toString().equalsIgnoreCase("Nam")){
            rdoGioiTinh.setSelected(true);
        }else{
            rdNu.setSelected(true);
        }
             txtKieuMay.setText(tblChiTietSp.getValueAt(index, 5).toString());
        for (int i = 0; i < cboTheLoai.getItemCount(); i++) {
          TheLoai ch =cboTheLoai.getItemAt(i);
            if (ch.getTen().equalsIgnoreCase(tblChiTietSp.getValueAt(index, 6).toString())) {
               cboTheLoai.setSelectedIndex(i);
                break;
            }
        }
         for (int i = 0; i < cboPhuKien.getItemCount(); i++) {
          PhuKien ch =cboPhuKien.getItemAt(i);
            if (ch.getTen().equalsIgnoreCase(tblChiTietSp.getValueAt(index, 7).toString())) {
              cboPhuKien.setSelectedIndex(i);
                break;
            }
        }
         for (int i = 0; i < cboTinhNang.getItemCount(); i++) {
          TinhNang ch =cboTinhNang.getItemAt(i);
            if (ch.getTen().equalsIgnoreCase(tblChiTietSp.getValueAt(index, 8).toString())) {
              cboTinhNang.setSelectedIndex(i);
                break;
            }
        }
//         for (int i = 0; i < cboTinhNang.getItemCount(); i++) {
//          TinhNang ch =cboTinhNang.getItemAt(i);
//            if (ch.getTen().equalsIgnoreCase(tblChiTietSp.getValueAt(index, 9).toString())) {
//              cboTinhNang.setSelectedIndex(i);
//                break;
//            }
//        }
          txtHinhDangMat.setText(tblChiTietSp.getValueAt(index, 9).toString());
           txtChatLieuMat.setText(tblChiTietSp.getValueAt(index, 10).toString());
           for (int i = 0; i < cboChatLieuDay.getItemCount(); i++) {
         ChatLieuDay ch = cboChatLieuDay.getItemAt(i);
            if (ch.getTen().equalsIgnoreCase(tblChiTietSp.getValueAt(index, 11).toString())) {
               cboChatLieuDay.setSelectedIndex(i);
                break;
            }
        }
            for (int i = 0; i < cboMauMatSo.getItemCount(); i++) {
        MauMatSo ch = cboMauMatSo.getItemAt(i);
            if (ch.getTen().equalsIgnoreCase(tblChiTietSp.getValueAt(index, 12).toString())) {
               cboMauMatSo.setSelectedIndex(i);
                break;
            }
        }
        for (int i = 0; i < cboMauVo.getItemCount(); i++) {
        MauVo ch = cboMauVo.getItemAt(i);
            if (ch.getTen().equalsIgnoreCase(tblChiTietSp.getValueAt(index, 13).toString())) {
               cboMauVo.setSelectedIndex(i);
                break;
            }
        }     
         txtKichThuoc.setText(tblChiTietSp.getValueAt(index, 14).toString());
          txtDonGia.setText(tblChiTietSp.getValueAt(index, 15).toString());
           txtNamBh.setText(tblChiTietSp.getValueAt(index, 16).toString());
            txtSoLuongTon.setText(tblChiTietSp.getValueAt(index, 17).toString());
            if(tblChiTietSp.getValueAt(index, 18).toString().equalsIgnoreCase("Còn kinh doanh")){
            rdDangkd.setSelected(true);
        }else{
            rdDaNghi.setSelected(true);
        }
     
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        cboThuongHieu = new javax.swing.JComboBox<>();
        cboXuatXu = new javax.swing.JComboBox<>();
        rdoGioiTinh = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        cboTheLoai = new javax.swing.JComboBox<>();
        txtKichThuoc = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        cboPhuKien = new javax.swing.JComboBox<>();
        cboTinhNang = new javax.swing.JComboBox<>();
        cboChatLieuDay = new javax.swing.JComboBox<>();
        txtNamBh = new javax.swing.JTextField();
        cboMauMatSo = new javax.swing.JComboBox<>();
        cboMauVo = new javax.swing.JComboBox<>();
        txtSoLuongTon = new javax.swing.JTextField();
        rdDangkd = new javax.swing.JRadioButton();
        rdDaNghi = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChiTietSp = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboThuongHieu2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cboGioiTinh = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTimSp = new javax.swing.JTextField();
        cboTinhTrang = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnTh = new javax.swing.JButton();
        btnXx = new javax.swing.JButton();
        btnTloai = new javax.swing.JButton();
        btnPk = new javax.swing.JButton();
        btnTn = new javax.swing.JButton();
        btnMv = new javax.swing.JButton();
        btnMms = new javax.swing.JButton();
        btnCld = new javax.swing.JButton();
        btnSp = new javax.swing.JButton();
        cboTen = new javax.swing.JComboBox<>();
        txtKieuMay = new javax.swing.JTextField();
        txtHinhDangMat = new javax.swing.JTextField();
        txtChatLieuMat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jLabel6.setText("Mã");

        jLabel7.setText("Tên");

        jLabel8.setText("Thương hiệu");

        jLabel9.setText("Xuất xứ");

        jLabel10.setText("Thể loại");

        jLabel11.setText("Chất liệu dây");

        jLabel12.setText("Màu mặt số");

        jLabel13.setText("Màu vỏ");

        jLabel14.setText("Phụ kiện");

        jLabel15.setText("Tính năng");

        jLabel16.setText("Hình dạng mặt số");

        jLabel17.setText("Chất liệu mặt kính");

        jLabel18.setText("Giới tính");

        jLabel19.setText("Kiểu máy");

        jLabel20.setText("Năm bảo hành");

        jLabel21.setText("Số lượng tồn");

        jLabel22.setText("Kích thước");

        jLabel23.setText("Đơn giá");

        jLabel24.setText("Tình trạng");

        buttonGroup1.add(rdoGioiTinh);
        rdoGioiTinh.setText("Nam");

        buttonGroup1.add(rdNu);
        rdNu.setText("Nữ");

        txtSoLuongTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongTonActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdDangkd);
        rdDangkd.setText("Kinh doanh");

        buttonGroup2.add(rdDaNghi);
        rdDaNghi.setText("Ngừng kinh doanh");

        tblChiTietSp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblChiTietSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietSpMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblChiTietSp);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Lọc sản phẩm");

        cboThuongHieu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThuongHieu2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Thương hiệu");

        cboGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGioiTinhActionPerformed(evt);
            }
        });

        jLabel3.setText("Giới tính");

        jLabel4.setText("Tình trạng");

        txtTimSp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimSpKeyReleased(evt);
            }
        });

        cboTinhTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTinhTrangActionPerformed(evt);
            }
        });

        jLabel5.setText("Tìm kiếm sản phẩm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel2)
                        .addGap(161, 161, 161)
                        .addComponent(jLabel3)
                        .addGap(82, 82, 82))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(cboThuongHieu2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(cboTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(txtTimSp, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(126, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(161, 161, 161))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboThuongHieu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnThem.setBackground(new java.awt.Color(255, 255, 102));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 255, 102));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 255, 102));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(255, 255, 102));
        btnReset.setText("Làm mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnLoad.setBackground(new java.awt.Color(255, 255, 102));
        btnLoad.setText("Tất cả sản phẩm");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnLoad)
                        .addGap(73, 73, 73)))
                .addGap(42, 42, 42))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoad)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnTh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTh.setText("+");
        btnTh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThActionPerformed(evt);
            }
        });

        btnXx.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXx.setText("+");
        btnXx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXxActionPerformed(evt);
            }
        });

        btnTloai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTloai.setText("+");
        btnTloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTloaiActionPerformed(evt);
            }
        });

        btnPk.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPk.setText("+");
        btnPk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPkActionPerformed(evt);
            }
        });

        btnTn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTn.setText("+");
        btnTn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTnActionPerformed(evt);
            }
        });

        btnMv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMv.setText("+");
        btnMv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMvActionPerformed(evt);
            }
        });

        btnMms.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMms.setText("+");
        btnMms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMmsActionPerformed(evt);
            }
        });

        btnCld.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCld.setText("+");
        btnCld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCldActionPerformed(evt);
            }
        });

        btnSp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSp.setText("+");
        btnSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rdoGioiTinh)
                                .addGap(18, 18, 18)
                                .addComponent(rdNu))
                            .addComponent(cboXuatXu, 0, 132, Short.MAX_VALUE)
                            .addComponent(cboThuongHieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboTen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMa)
                            .addComponent(cboTheLoai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKieuMay))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSp)
                                    .addComponent(btnTh)
                                    .addComponent(btnXx)
                                    .addComponent(btnTloai))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboPhuKien, 0, 134, Short.MAX_VALUE)
                            .addComponent(cboMauMatSo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboChatLieuDay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboTinhNang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboMauVo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHinhDangMat)
                            .addComponent(txtChatLieuMat))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPk)
                            .addComponent(btnTn)
                            .addComponent(btnCld)
                            .addComponent(btnMms)
                            .addComponent(btnMv))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addGap(38, 38, 38)
                                        .addComponent(rdDangkd)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdDaNghi))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23)
                                            .addComponent(jLabel22))
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel21))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNamBh, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 49, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel14)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPhuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(txtKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPk))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel15)
                    .addComponent(cboTinhNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTn)
                    .addComponent(btnSp)
                    .addComponent(cboTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel16)
                    .addComponent(cboThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamBh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTh)
                    .addComponent(jLabel20)
                    .addComponent(txtHinhDangMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel17)
                    .addComponent(cboXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXx)
                    .addComponent(txtChatLieuMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel11)
                    .addComponent(rdoGioiTinh)
                    .addComponent(rdNu)
                    .addComponent(cboChatLieuDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCld)
                    .addComponent(jLabel24)
                    .addComponent(rdDangkd)
                    .addComponent(rdDaNghi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel12)
                            .addComponent(cboMauMatSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMms)
                            .addComponent(txtKieuMay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cboTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(cboMauVo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTloai)
                            .addComponent(btnMv)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sản phẩm chi tiết", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSoLuongTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongTonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongTonActionPerformed

    private void tblChiTietSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietSpMouseClicked
//        int index=tblChiTietSp.getSelectedRow();
//        fillCtsp(index);
        loadTextField();
    }//GEN-LAST:event_tblChiTietSpMouseClicked

    private void cboThuongHieu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThuongHieu2ActionPerformed
        locSpTheoTH();
    }//GEN-LAST:event_cboThuongHieu2ActionPerformed

    private void cboGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGioiTinhActionPerformed
        locSpTheoGT();
    }//GEN-LAST:event_cboGioiTinhActionPerformed
private void fillCtsp(int index){
    List<QlChiTietSanPham> listCtsp = iChiTietSanPhamService.getAllCtsps();
    txtMa.setText(listCtsp.get(index).getMa());
    cboTen.getModel().setSelectedItem(listCtsp.get(index).getTen());
   cboXuatXu.getModel().setSelectedItem(listCtsp.get(index).getThuongHieu());
    cboXuatXu.getModel().setSelectedItem(listCtsp.get(index).getXuatXu());
    cboTheLoai.getModel().setSelectedItem(listCtsp.get(index).getTheLoai());
    txtKieuMay.setText(listCtsp.get(index).getKieuMay());
    cboPhuKien.getModel().setSelectedItem(listCtsp.get(index).getPhuKien());
    cboTinhNang.getModel().setSelectedItem(listCtsp.get(index).getTinhNang());
    txtHinhDangMat.setText(listCtsp.get(index).getHinhDangMat());
    txtChatLieuMat.setText(listCtsp.get(index).getChatLieuMat());
    cboChatLieuDay.getModel().setSelectedItem(listCtsp.get(index).getChatLieuDay());
    cboMauMatSo.getModel().setSelectedItem(listCtsp.get(index).getMauMat());
    cboMauVo.getModel().setSelectedItem(listCtsp.get(index).getMauVo());
    txtKichThuoc.setText(listCtsp.get(index).getKichThuoc());
    txtDonGia.setText(listCtsp.get(index).getDonGia());
    txtNamBh.setText(String.valueOf(listCtsp.get(index).getNamBh()));
    txtSoLuongTon.setText(String.valueOf(listCtsp.get(index).getSoLuong()));
}
    private void txtTimSpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimSpKeyReleased
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã", "Tên", "Thương hiệu", "Xuất xứ", "Giới tính", "Kiểu máy", "Thể loại", "Phụ kiện", "Tính năng", "Hình dạng mặt", "Chất liệu mặt", "Chất liệu dây", "Màu mặt số", "Màu vỏ", "Kích thước", "Đơn giá", "Năm bảo hành", "Số lượng tồn", "Tình trạng"});
        List<ChiTietSanPham> listCtsp = iChiTietSanPhamService.timSps(txtTimSp.getText());
        if (listCtsp == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
            return;
        }
        for (ChiTietSanPham ctsp : listCtsp) {
            model.addRow(new Object[]{ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
                ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.getTinhTrang()});
        }
        tblChiTietSp.setModel(model);
    }//GEN-LAST:event_txtTimSpKeyReleased

    private void cboTinhTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTinhTrangActionPerformed
        locSpTheoTT();
    }//GEN-LAST:event_cboTinhTrangActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if(CheckValidate()){
            if(iChiTietSanPhamService.checkMa(txtMa.getText().trim())){
                JOptionPane.showMessageDialog(this,"Mã San pham đã tồn tại");
                        
            }else{
                iChiTietSanPhamService.add(getData());
                 JOptionPane.showMessageDialog(this,"thêm thanh công!");
                loadTableCtsp();
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if(CheckValidate()){
            if(!iChiTietSanPhamService.checkMa(txtMa.getText().trim())){
                JOptionPane.showMessageDialog(this,"Mã San pham đã tồn tại");
                        
            }else{
                iChiTietSanPhamService.update(getData());
                 JOptionPane.showMessageDialog(this,"sua thanh công!");
                loadTableCtsp();
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int chon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if(chon == JOptionPane.YES_OPTION){
            iChiTietSanPhamService.deleteThs(txtMa.getText().trim());
            JOptionPane.showMessageDialog(this,"xóa thanh công!");
            loadTableCtsp();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtMa.setText(null);
        txtChatLieuMat.setText(null);
        txtDonGia.setText(null);
        txtHinhDangMat.setText(null);
        txtKichThuoc.setText(null);
        txtKieuMay.setText(null);
        txtNamBh.setText(null);
        txtSoLuongTon.setText(null);
    }//GEN-LAST:event_btnResetActionPerformed
 private void locSpTheoTH() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã", "Tên", "Thương hiệu", "Xuất xứ", "Giới tính", "Kiểu máy", "Thể loại", "Phụ kiện", "Tính năng", "Hình dạng mặt", "Chất liệu mặt", "Chất liệu dây", "Màu mặt số", "Màu vỏ", "Kích thước", "Đơn giá", "Năm bảo hành", "Số lượng tồn", "Tình trạng"});
        List<QlChiTietSanPham> listCtsp = iChiTietSanPhamService.locSpTheoTHs(cboThuongHieu2.getItemAt(cboThuongHieu2.getSelectedIndex()));
        if (listCtsp == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
            return;
        }
        for (QlChiTietSanPham ctsp : listCtsp) {
            model.addRow(new Object[]{ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
                ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.getTinhTrang()});
        }
        tblChiTietSp.setModel(model);
    }

    private void locSpTheoGT() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã", "Tên", "Thương hiệu", "Xuất xứ", "Giới tính", "Kiểu máy", "Thể loại", "Phụ kiện", "Tính năng", "Hình dạng mặt", "Chất liệu mặt", "Chất liệu dây", "Màu mặt số", "Màu vỏ", "Kích thước", "Đơn giá", "Năm bảo hành", "Số lượng tồn", "Tình trạng"});
        List<QlChiTietSanPham> listCtsp = iChiTietSanPhamService.locSpTheoGTs(cboGioiTinh.getItemAt(cboGioiTinh.getSelectedIndex()));
        if (listCtsp == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
            return;
        }
        for (QlChiTietSanPham ctsp : listCtsp) {
            model.addRow(new Object[]{ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
                ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.getTinhTrang()});
        }
        tblChiTietSp.setModel(model);
    }

    private void locSpTheoTT() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã", "Tên", "Thương hiệu", "Xuất xứ", "Giới tính", "Kiểu máy", "Thể loại", "Phụ kiện", "Tính năng", "Hình dạng mặt", "Chất liệu mặt", "Chất liệu dây", "Màu mặt số", "Màu vỏ", "Kích thước", "Đơn giá", "Năm bảo hành", "Số lượng tồn", "Tình trạng"});
        List<QlChiTietSanPham> listCtsp = iChiTietSanPhamService.locSpTheoTTs ( cboTinhTrang.getItemAt(cboTinhTrang.getSelectedIndex()));
        if (listCtsp == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
            return;
        }
        for (QlChiTietSanPham ctsp : listCtsp) {
            model.addRow(new Object[]{ctsp.getMa(), ctsp.getTen(), ctsp.getThuongHieu(), ctsp.getXuatXu(),
                ctsp.getGioiTinh(), ctsp.getKieuMay(), ctsp.getTheLoai(), ctsp.getPhuKien(), ctsp.getTinhNang(),
                ctsp.getHinhDangMat(), ctsp.getChatLieuMat(), ctsp.getChatLieuDay(), ctsp.getMauMat(),
                ctsp.getMauVo(), ctsp.getKichThuoc(), ctsp.getDonGia(), ctsp.getNamBh(), ctsp.getSoLuong(), ctsp.getTinhTrang()});
        }
        tblChiTietSp.setModel(model);
    }
    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        loadTableCtsp();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnThActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThActionPerformed
        new FormThuongHieu().setVisible(true);
    }//GEN-LAST:event_btnThActionPerformed

    private void btnXxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXxActionPerformed
        new FormXuatXu().setVisible(true);
    }//GEN-LAST:event_btnXxActionPerformed

    private void btnTloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTloaiActionPerformed
        new FormTheLoai().setVisible(true);
    }//GEN-LAST:event_btnTloaiActionPerformed

    private void btnPkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPkActionPerformed
        new FormPhuKien().setVisible(true);
    }//GEN-LAST:event_btnPkActionPerformed

    private void btnTnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTnActionPerformed
        new FormTinhNang().setVisible(true);
    }//GEN-LAST:event_btnTnActionPerformed

    private void btnMvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMvActionPerformed
        new FormMauVo().setVisible(true);
    }//GEN-LAST:event_btnMvActionPerformed

    private void btnMmsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMmsActionPerformed
        new FormMauMatSo().setVisible(true);
    }//GEN-LAST:event_btnMmsActionPerformed

    private void btnCldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCldActionPerformed
        new FormChatLieuDay().setVisible(true);
    }//GEN-LAST:event_btnCldActionPerformed

    private void btnSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpActionPerformed
        new FormSanPham().setVisible(true);
    }//GEN-LAST:event_btnSpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormSanphamtest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSanphamtest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSanphamtest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSanphamtest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSanphamtest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCld;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnMms;
    private javax.swing.JButton btnMv;
    private javax.swing.JButton btnPk;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSp;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTh;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTloai;
    private javax.swing.JButton btnTn;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXx;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<ChatLieuDay> cboChatLieuDay;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JComboBox<MauMatSo> cboMauMatSo;
    private javax.swing.JComboBox<MauVo> cboMauVo;
    private javax.swing.JComboBox<PhuKien> cboPhuKien;
    private javax.swing.JComboBox<SanPham> cboTen;
    private javax.swing.JComboBox<TheLoai> cboTheLoai;
    private javax.swing.JComboBox<ThuongHieu> cboThuongHieu;
    private javax.swing.JComboBox<String> cboThuongHieu2;
    private javax.swing.JComboBox<TinhNang> cboTinhNang;
    private javax.swing.JComboBox<String> cboTinhTrang;
    private javax.swing.JComboBox<XuatXu> cboXuatXu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdDaNghi;
    private javax.swing.JRadioButton rdDangkd;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JRadioButton rdoGioiTinh;
    private javax.swing.JTable tblChiTietSp;
    private javax.swing.JTextField txtChatLieuMat;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtHinhDangMat;
    private javax.swing.JTextField txtKichThuoc;
    private javax.swing.JTextField txtKieuMay;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNamBh;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtTimSp;
    // End of variables declaration//GEN-END:variables
}