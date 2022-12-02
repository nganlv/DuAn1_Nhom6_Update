/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModels.ChucVu;
import DomainModels.NhanVien;
import DomainModels.TaiKhoan;
import Service.Interface.IChucVuSer;
import Service.Interface.QLNhanVien;
import Service.Interface.QLTaiKhoan;
import Services.ChucVuServiceImpl;
import Services.INhanVien;
import Services.ITaiKhoan;
import ViewModels.QuanLyNhanVien;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author levan
 */
public class NhanVienJpanel extends javax.swing.JPanel {
private final QLNhanVien nvService=new INhanVien();
private final QLTaiKhoan tkService=new ITaiKhoan();
private final IChucVuSer cvService=new ChucVuServiceImpl();
DefaultTableModel model = new DefaultTableModel();
    /**
     * Creates new form NhanVienJpanel
     */
    public NhanVienJpanel() {
        initComponents();
        LoadTable();
         loadCombobox();
        
        dpTime.getSettings().setAllowKeyboardEditing(false);
        dpTime.getSettings().setDateRangeLimits(LocalDate.MIN, LocalDate.now());
        dpTime.getSettings().setFormatForDatesCommonEra("dd-MM-yyyy");
    }
public String formatDate(Date date){
    SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        String StrDate = formater.format(date);
        return StrDate;
}
public void LoadTable(){
    List<QuanLyNhanVien> listNV =nvService.getAll();
    
    DefaultTableModel model=new DefaultTableModel();
    model.setColumnCount(0);
    model.setRowCount(0);
    model.setColumnIdentifiers(new String[]{"Mã nhân viên", "Tên",  "Giới tính", "Ngày sinh","SDT", "Địa chỉ",  "Email", "TaiKhoan", "Chức vụ", "Trạng thái"});
    for (QuanLyNhanVien nv : listNV) {
        String trangThai;
        if(nv.getTrangthai()==1){
            trangThai="dang lam";
        }else{
            trangThai="Da nghi viec";
        }
        model.addRow(new Object[]{nv.getMa(),nv.getTen(),nv.getGioitinh(),formatDate(nv.getNgaysinh()),nv.getSdt(),nv.getDiachi(),nv.getEmail(),nv.getTaikhoan(),nv.getChucvu(),trangThai});
    }
  tblNhanVien.setModel(model);
    
}

    private void loadCombobox() {
    List<TaiKhoan> Listtk=tkService.getAlls();
        cbTK.removeAllItems();
        for (TaiKhoan taiKhoan : Listtk) {
            cbTK.addItem(taiKhoan);
        }
          List<ChucVu> listCV = cvService.getAll();
        cbCV.removeAllItems();
        for (ChucVu cv : listCV) {
            cbCV.addItem(cv);
          cbLoc.addItem(cv);
        }
    }
     

 public NhanVien getData(){
        NhanVien nv = new NhanVien();
        nv.setMa(txtMa.getText().trim());
        nv.setTen(txtTen.getText().trim());
        
        if(rdNam.isSelected()){
            nv.setGioitinh("Nam");
        }else{
            nv.setGioitinh("Nữ");
        }
        
        try {
            nv.setNgaysinh(new SimpleDateFormat("dd-MM-yyyy").parse(dpTime.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(NhanVienJpanel.class.getName()).log(Level.SEVERE, null, ex);
        }
         nv.setSdt(txtSdt.getText().trim());
        nv.setDiachi(txtDiaChi.getText().trim());
       
        nv.setEmail(txtEmail.getText().trim());
        
       TaiKhoan ch = (TaiKhoan) cbTK.getSelectedItem();
    ChucVu cv = (ChucVu) cbCV.getSelectedItem();
        
        nv.setIdtk(ch.getId());
        nv.setIdcv(cv.getId());
        
        if(rdDanglam.isSelected()){
            nv.setTrangthai(1);
      }else{
         nv.setTrangthai(0);
      }
      
      return nv;
   }
 public void loadTextField(){
        int index = tblNhanVien.getSelectedRow();
        txtMa.setText(tblNhanVien.getValueAt(index, 0).toString());
        txtTen.setText(tblNhanVien.getValueAt(index, 1).toString());
       
        
        if(tblNhanVien.getValueAt(index, 2).toString().equalsIgnoreCase("Nam")){
            rdNam.setSelected(true);
        }else{
            rdNu.setSelected(true);
        }
        
        dpTime.setText(tblNhanVien.getValueAt(index, 3).toString());
          txtSdt.setText(tblNhanVien.getValueAt(index, 4).toString());
        txtDiaChi.setText(tblNhanVien.getValueAt(index, 5).toString());
      
        txtEmail.setText(tblNhanVien.getValueAt(index, 6).toString());
        
        for (int i = 0; i < cbTK.getItemCount(); i++) {
            TaiKhoan tk = cbTK.getItemAt(i);
            if (tk.getTen().equalsIgnoreCase(tblNhanVien.getValueAt(index, 7).toString())) {
                cbTK.setSelectedIndex(i);
                break;
            }
        }
       
       for (int i = 0; i < cbCV.getItemCount(); i++) {
         ChucVu cv = cbCV.getItemAt(i);
            if (cv.getTen().equalsIgnoreCase(tblNhanVien.getValueAt(index, 8).toString())) {
            } else {
                cbCV.setSelectedIndex(i);
                break;
            }
        }
        
        if(tblNhanVien.getValueAt(index, 9).toString().equalsIgnoreCase("dang lam")){
            rdDanglam.setSelected(true);
        }else{
            rdDanghiviec.setSelected(true);
        }
        
    }
 public boolean CheckValidate(){
     if(txtMa.getText().isBlank()|| txtTen.getText().isBlank()|| txtSdt.getText().isBlank()||txtDiaChi.getText().isBlank()||txtEmail.getText().isBlank()){
         JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu ");
         return false;
     }
     if(txtMa.getText().trim().length()>10){
         JOptionPane.showMessageDialog(this, "mã nhân viên không quá 10 ký tu");
         return false;
     }
     if(!rdNam.isSelected()&&!rdNu.isSelected()){
         JOptionPane.showMessageDialog(this,"Phải chọn 1 giới tính");
         return false;
     }
     if(dpTime.getText().isBlank()){
         JOptionPane.showMessageDialog(this, "Phải chọn 1 ngày sinh");
            return false;
                 
     }
      String regexSDT = "\\d{10}";
      if(!txtSdt.getText().matches(regexSDT)){
            JOptionPane.showMessageDialog(this, "Số điện thoại có 10 số");
            return false;
        }
      return true;
 }
 public List<QuanLyNhanVien> tim() {
        if (txtSearch.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "vui lòng nhập mã để tìm");
            return null;

        } else {
//            RowFilter<DefaultTableModel,Object> rf=RowFilter.regexFilter(cbLoc.getSelectedItem().toString(),0);
//             sorter.setRowFilter(rf);
            String ten = txtSearch.getText();
            model.setColumnIdentifiers(new String[]{"Mã nhân viên", "Tên",  "Giới tính", "Ngày sinh","SDT", "Địa chỉ",  "Email", "TaiKhoan", "Chức vụ", "Trạng thái"});
            model.setRowCount(0);
            List<QuanLyNhanVien> dsnv = nvService.getTims(ten);
            for (QuanLyNhanVien kh : dsnv) {
                String trangThai;
        if(kh.getTrangthai()==1){
            trangThai="dang lam";
        }else{
            trangThai="Da nghi viec";
        }
                Object[] row = new Object[]{
                    kh.getMa(),
                    kh.getTen(),
                    kh.getGioitinh(),
                    kh.getNgaysinh(),
                    kh.getSdt(),
                    kh.getDiachi(),
                kh.getEmail(),
                kh.getTaikhoan(),
                kh.getChucvu(),
                trangThai};
                model.addRow(row);
            }
            tblNhanVien.setModel(model);
       
            return dsnv;
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
        jPanel1 = new javax.swing.JPanel();

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        dateNs = new com.github.lgooddatepicker.components.DatePicker();
        rdoGioiTinh = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        txtTen = new javax.swing.JTextField();
        txtMa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTenTk = new javax.swing.JTextField();
        txtMk = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtChucVu = new javax.swing.JTextField();
        rdoTrangThai = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        cboGioiTinh = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cboChucVu = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cboTrangThai = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Thiết lập thông tin nhân viên");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Mã ");

        jLabel3.setText("Họ tên");

        jLabel4.setText("Giới tính");

        jLabel5.setText("Ngày sinh");

        jLabel6.setText("Số điện thoại");

        jLabel7.setText("Địa chỉ");

        buttonGroup2.add(rdoGioiTinh);
        rdoGioiTinh.setText("Nam");

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setText("Nữ");

        jLabel8.setText("Email");

        jLabel9.setText("Tên tài khoản");

        jLabel10.setText("Mật khẩu");

        jLabel11.setText("Chức vụ");

        jLabel12.setText("Trạng thái");

        buttonGroup1.add(rdoTrangThai);
        rdoTrangThai.setText("Đang làm");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Đã nghỉ việc");

        btnThem.setBackground(new java.awt.Color(255, 255, 51));
        btnThem.setText("Thêm");

        btnSua.setBackground(new java.awt.Color(255, 255, 51));
        btnSua.setText("Sửa");

        btnReset.setBackground(new java.awt.Color(255, 255, 51));
        btnReset.setText("Làm mới");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdoGioiTinh)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2))
                    .addComponent(dateNs, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(txtSdt)
                    .addComponent(txtTen)
                    .addComponent(txtMa))
                .addGap(176, 176, 176)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDiaChi)
                            .addComponent(txtMk)
                            .addComponent(txtTenTk)
                            .addComponent(txtEmail)
                            .addComponent(txtChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                        .addComponent(jLabel12)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdoTrangThai)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton4))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnThem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoTrangThai)
                    .addComponent(jRadioButton4))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(rdoGioiTinh)
                            .addComponent(jRadioButton2)
                            .addComponent(jLabel9)
                            .addComponent(txtTenTk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(dateNs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtMk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));


        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
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

        jScrollPane1.setViewportView(tblNhanVien);

        jLabel14.setText("Lọc theo giới tính");

        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("Lọc theo chức vụ");

        cboChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel16.setText("Lọc theo trạng thái");

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel17.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel14)
                                .addGap(134, 134, 134)
                                .addComponent(jLabel15)
                                .addGap(132, 132, 132)
                                .addComponent(jLabel16)
                                .addGap(189, 189, 189)
                                .addComponent(jLabel17))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107)
                                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 109, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Thông tin nhân viên");


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel13))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))

        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()

                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))

        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))

        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        loadTextField();
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if(CheckValidate()){
            if(nvService.checkMa(txtMa.getText().trim())){
                JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại ");
            }else{
                JOptionPane.showMessageDialog(this, nvService.add(getData()));
                LoadTable();
            }

        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        JOptionPane.showMessageDialog(this, nvService.update(getData()));
        LoadTable();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, nvService.delete(txtMa.getText().trim()));
        LoadTable();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
        LoadTable();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        tim();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cbLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocActionPerformed
        // TODO add your handling code here:
             DefaultTableModel model=new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã nhân viên", "Tên",  "Giới tính", "Ngày sinh","SDT", "Địa chỉ",  "Email", "TaiKhoan", "Chức vụ", "Trạng thái"});
        List<QuanLyNhanVien> listQlnv=nvService.getLOCs(String.valueOf(cbLoc.getItemAt(cbLoc.getSelectedIndex())));
        for (QuanLyNhanVien nv : listQlnv) {
            String trangThai;
            if(nv.getTrangthai()==1){
                trangThai="dang lam";
            }else{
                trangThai="Da nghi viec";
            }
            model.addRow(new Object[]{nv.getMa(),nv.getTen(),nv.getGioitinh(),formatDate(nv.getNgaysinh()),nv.getSdt(),nv.getDiachi(),nv.getEmail(),nv.getTaikhoan(),nv.getChucvu(),trangThai});
        }
        tblNhanVien.setModel(model);
    }//GEN-LAST:event_cbLocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboChucVu;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JComboBox<String> cboTrangThai;
    private com.github.lgooddatepicker.components.DatePicker dateNs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;

    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;

    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoGioiTinh;
    private javax.swing.JRadioButton rdoTrangThai;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtChucVu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMk;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenTk;
    private javax.swing.JTextField txtTim;

    // End of variables declaration//GEN-END:variables
}
