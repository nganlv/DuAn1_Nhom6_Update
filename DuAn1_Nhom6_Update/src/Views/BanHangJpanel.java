/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModels.HoaDon;
import Service.Interface.IChiTietSanPhamService;
import Service.Interface.IHoaDonChiTietSer;
import Services.HoaDonChoService;
import Service.Interface.IHoaDonChoService;
import Service.Interface.IHoaDonSer;
import Service.Interface.IKhachHang_BanHangService;
import Services.SanPham_BanHangService;
import ViewModels.QLSanPham_BanHang;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Service.Interface.ISanPham_BanHangService;
import Services.ChiTietSanPhamService;
import Services.HoaDonChiTietService;
import Services.HoaDonService;
import Services.KhachHang_BanHangService;
import ViewModels.QlChiTietSanPham;
import ViewModels.QlHoaDon;
import ViewModels.QlHoaDonChiTiet;
import ViewModels.QlHoaDonCho;
import ViewModels.QlKhachHang_BanHang;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author levan
 */
public class BanHangJpanel extends javax.swing.JPanel {

    private final ISanPham_BanHangService iSanPhamService = new SanPham_BanHangService();
    private final IChiTietSanPhamService iChiTietSanPhamService = new ChiTietSanPhamService();  
    private final IHoaDonSer iHoaDonSer = new HoaDonService();
    List<QlHoaDonChiTiet> listHdct = new ArrayList<>();

    /**
     * Creates new form BanHang
     */
    public BanHangJpanel() {
        initComponents();
        loadTableSp();
        loadTableGioHang();
        clock();
        loadComboboxTT();
        loadComboboxHtbh();
        dateTT.getSettings().setAllowKeyboardEditing(true);
        dateTT.getSettings().setDateRangeLimits(LocalDate.now(), LocalDate.MAX);
        jlbUserName.setText(FormDangNhap.userName);
        donHang();
    
    }

    public void clock() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    SimpleDateFormat sdf = new SimpleDateFormat();
                    sdf.applyPattern("hh:mm:ss aa");
                    Date date = new Date();
                    jlbClock.setText(sdf.format(date));
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                }
            }
        }.start();
    }

    private void loadTableSp() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã", "Tên", "Đơn giá", "Giảm giá", "Hình dạng mặt số", "Chất liệu mặt kính", "Kích thước", "Màu vỏ", "Thể loại", "Giới tính", "Kiểu máy", "Số lượng tồn"});
        List<QLSanPham_BanHang> listSp = iSanPhamService.getAllSps();
        if (listSp == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        }
        for (QLSanPham_BanHang sp : listSp) {
            model.addRow(new Object[]{sp.getMa(), sp.getTen(), sp.getDonGia(), sp.getGiamGia(), sp.getHinhDangMat(),
                sp.getChatLieuMat(), sp.getKichThuoc(), sp.getMauVo(), sp.getTheLoai(), sp.getGioiTinh(), sp.getKieuMay(), sp.getSoLuong()});
        }
        tblSanPham.setModel(model);
    }

    private void loadTableHdc2() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã hóa đơn", "Ngày tạo", "Nhân viên tạo", " Khách hàng"});
        List<QlHoaDon> listhdc = iHoaDonSer.getAllHdcs(jlbTenKh.getText());
        if (listhdc == null) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        }
//        List<QlHoaDon> listHdc = iHoaDonSer.getAllHdcs();
        for (QlHoaDon hd : listhdc) {
            model.addRow(new Object[]{hd.getMaHd(), hd.getNgayTao(), hd.getTenNv(), hd.getTenKh()});
        }
        tblHoaDonCho.setModel(model);
    }

    private void loadTableGioHang() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Giảm giá", "Số lượng", "Thành tiền"});

        for (QlHoaDonChiTiet hdct : listHdct) {
            model.addRow(new Object[]{hdct.getMaSp(), hdct.getTenSp(), hdct.getDonGia(), hdct.getGiamGia(), hdct.getSoLuong(), hdct.getThanhTien()});

        }
        tblGioHang.setModel(model);

    }

    private void loadComboboxTT() {
        String[] thanhToan = {"Tiền mặt", "Chuyển khoản", "Quẹt thẻ"};
        cboHinhThucTT.setModel(new DefaultComboBoxModel<>(thanhToan));
    }

    private void loadComboboxHtbh() {
        String[] thanhToan = {"Bán trực tiếp", "Ship code"};
        cboHtbh.setModel(new DefaultComboBoxModel<>(thanhToan));
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDonCho = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnXoaGh = new javax.swing.JButton();
        btnDeleteAll = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txtTim = new javax.swing.JTextField();
        btnAllSp = new javax.swing.JButton();
        btnThemSp = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtIdCtsp = new javax.swing.JTextField();
        txtIdHd = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnTaoHd = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jlbMaHd = new javax.swing.JLabel();
        jlbDonGia = new javax.swing.JLabel();
        jlbGiamGia = new javax.swing.JLabel();
        jlbThanhTien = new javax.swing.JLabel();
        btnResetHd = new javax.swing.JButton();
        btnHuyHd = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnDsKh = new javax.swing.JButton();
        jlbMaKh = new javax.swing.JLabel();
        jlbTenKh = new javax.swing.JLabel();
        btnChon = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cboHinhThucTT = new javax.swing.JComboBox<>();
        cboHtbh = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jlbTienThua = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dateTT = new com.github.lgooddatepicker.components.DatePicker();
        txtGhiChu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jlbClock = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jlbUserName = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setText("Hóa đơn chờ");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblHoaDonCho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Ngày tạo", "Nhân viên tạo", "Tên khách hàng"
            }
        ));
        tblHoaDonCho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonChoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDonCho);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setText("Giỏ hàng");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGioHang);

        btnXoaGh.setText("Xóa");
        btnXoaGh.setBackground(new java.awt.Color(255, 255, 0));
        btnXoaGh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaGhActionPerformed(evt);
            }
        });

        btnDeleteAll.setBackground(new java.awt.Color(255, 255, 102));
        btnDeleteAll.setText("Xóa tất cả");
        btnDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDeleteAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaGh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnXoaGh)
                        .addGap(26, 26, 26)
                        .addComponent(btnDeleteAll)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Danh sách sản phẩm");
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSanPham);

        txtTim.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtTimInputMethodTextChanged(evt);
            }
        });
        txtTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimActionPerformed(evt);
            }
        });
        txtTim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKeyReleased(evt);
            }
        });

        btnAllSp.setText("Tất cả sản phẩm");
        btnAllSp.setBackground(new java.awt.Color(255, 255, 0));
        btnAllSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllSpActionPerformed(evt);
            }
        });

        btnThemSp.setText("Thêm vào giỏ hàng");
        btnThemSp.setBackground(new java.awt.Color(255, 255, 0));
        btnThemSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSpActionPerformed(evt);
            }
        });

        jLabel16.setText("Tìm kiếm sản phẩm");

        txtIdCtsp.setEnabled(false);

        txtIdHd.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnThemSp)
                                .addGap(69, 69, 69)
                                .addComponent(btnAllSp))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                        .addComponent(txtIdCtsp, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(txtIdHd, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtIdCtsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdHd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemSp)
                    .addComponent(btnAllSp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnTaoHd.setText("Tạo ");
        btnTaoHd.setBackground(new java.awt.Color(255, 255, 0));
        btnTaoHd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHdActionPerformed(evt);
            }
        });

        jLabel11.setText("Mã hóa đơn");

        jLabel12.setText("Đơn giá");

        jLabel13.setText("Giảm giá");

        jLabel14.setText("Thành tiền");

        jLabel17.setText("Hình thức bán hàng");

        jlbMaHd.setText("Vui lòng tạo!");

        jlbDonGia.setText("0");
        jlbDonGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jlbGiamGia.setText("0");
        jlbGiamGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jlbThanhTien.setText("0");
        jlbThanhTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnResetHd.setText("Làm mới");
        btnResetHd.setBackground(new java.awt.Color(255, 255, 0));
        btnResetHd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetHdActionPerformed(evt);
            }
        });

        btnHuyHd.setText("Hủy hóa đơn");
        btnHuyHd.setBackground(new java.awt.Color(255, 255, 0));
        btnHuyHd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHdActionPerformed(evt);
            }
        });

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setBackground(new java.awt.Color(255, 255, 0));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setPreferredSize(new java.awt.Dimension(300, 118));

        jLabel7.setText("Id KH");

        jLabel8.setText("Tên KH");

        btnDsKh.setText("Danh sách");
        btnDsKh.setBackground(new java.awt.Color(255, 255, 0));
        btnDsKh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDsKhActionPerformed(evt);
            }
        });

        jlbMaKh.setText("37B69C7E-9B68-454D-9C67-20FB5FED9CEF");
        jlbMaKh.setEnabled(false);

        jlbTenKh.setText("Khách bán lẻ");

        btnChon.setText("Cập nhật");
        btnChon.setBackground(new java.awt.Color(255, 255, 51));
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jlbTenKh, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jlbMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDsKh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jlbMaKh)
                    .addComponent(btnDsKh))
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jlbTenKh)
                    .addComponent(btnChon))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Hình thức thanh toán");

        jLabel10.setText("Tiền khách đưa");

        txtTienKhachDua.setText("0");
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        jLabel15.setText("Tiền thừa");

        jlbTienThua.setText("0");
        jlbTienThua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setText("Ghi chú");

        jLabel9.setText("Ngày thanh toán");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btnResetHd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHuyHd, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(49, 49, 49)
                                .addComponent(jlbMaHd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTaoHd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(49, 49, 49)
                                .addComponent(cboHtbh, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                    .addComponent(jlbDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addGap(65, 65, 65))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addGap(72, 72, 72)))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jlbThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlbGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlbTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTienKhachDua, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))))
                        .addContainerGap(32, Short.MAX_VALUE))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(cboHinhThucTT, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGhiChu)
                                    .addComponent(dateTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jlbMaHd)
                    .addComponent(btnTaoHd))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jlbDonGia))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jlbGiamGia))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jlbThanhTien))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jlbTienThua))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cboHtbh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboHinhThucTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(dateTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResetHd)
                    .addComponent(btnHuyHd))
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.getAccessibleContext().setAccessibleDescription("");

        jLabel5.setText("Đơn hàng");
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jlbClock.setText("00:00 AM");
        jlbClock.setForeground(new java.awt.Color(255, 0, 0));

        jLabel18.setText("Tên đăng nhập:");
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jlbUserName.setText("abc");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(jlbUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(157, 157, 157)
                        .addComponent(jlbClock, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jlbClock)
                    .addComponent(jLabel18)
                    .addComponent(jlbUserName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fillHoaDonCho2(int index) {
       List<QlHoaDon> listhdc = iHoaDonSer.getAllHdcs(jlbTenKh.getText());
        jlbMaHd.setText(String.valueOf(listhdc.get(index).getMaHd()));
        txtIdHd.setText(listhdc.get(index).getIdHd());
//        txtTenKh.setText(listhdc.get(index).getTenKh());
//        txtMaKh.setText(listhdc.get(index).getMaKh());
    }
    private void btnThemSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSpActionPerformed
        if (txtTim.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm");
            return;
        }
        String soLuong = JOptionPane.showInputDialog(null, "Mời bạn nhập số lượng sản phẩm", "Hệ thống quản lý bán hàng", JOptionPane.INFORMATION_MESSAGE);
//        QlHoaDonChiTiet hdct = new QlHoaDonChiTiet();
////        hdct.setSoLuong(Integer.parseInt(soLuong));
////        hdct.setDonGia(Double.parseDouble(txtDonGia.getText()));
////        
////        iHoaDonChiTietSer.updateSls(hdct);
        List<QLSanPham_BanHang> listSp = iSanPhamService.getAllSps();
        int index = tblSanPham.getSelectedRow();
        QlHoaDonChiTiet hdct = new QlHoaDonChiTiet();
        hdct.setMaSp(listSp.get(index).getMa());
        hdct.setTenSp(listSp.get(index).getTen());
        hdct.setDonGia(listSp.get(index).getDonGia());
        hdct.setGiamGia(listSp.get(index).getGiamGia());
        hdct.setSoLuong(Integer.parseInt(soLuong));
        hdct.setThanhTien((listSp.get(index).getDonGia() - listSp.get(index).getGiamGia()) * Integer.parseInt(soLuong));
        listHdct.add(hdct);

        QlChiTietSanPham ctsp = new QlChiTietSanPham();
        ctsp.setSoLuong((listSp.get(index).getSoLuong()) - Integer.parseInt(soLuong));
        ctsp.setMa(listSp.get(index).getMa());
        iChiTietSanPhamService.update(ctsp);
        
        QlHoaDon hd=new QlHoaDon();
        hd.setDonGia(listSp.get(index).getDonGia());
        hd.setSoLuong(Integer.parseInt(soLuong));
        hd.setIdCtsp(txtIdCtsp.getText());
        hd.setIdHd(txtIdHd.getText());
        iHoaDonSer.addHdcts(hd);
        loadTableSp();
        loadTableGioHang();
        donHang();

    }//GEN-LAST:event_btnThemSpActionPerformed

    private void tblHoaDonChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonChoMouseClicked
        int index = tblHoaDonCho.getSelectedRow();
        fillHoaDonCho2(index);

    }//GEN-LAST:event_tblHoaDonChoMouseClicked

    private void btnAllSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllSpActionPerformed
        loadTableSp();
    }//GEN-LAST:event_btnAllSpActionPerformed
    private void fillSp(int index) {
        List<QLSanPham_BanHang> listSp = iSanPhamService.getAllSps();
        txtTim.setText(listSp.get(index).getMa());
        txtIdCtsp.setText(listSp.get(index).getId());
    }


    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int index = tblSanPham.getSelectedRow();
        fillSp(index);
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        int index = tblGioHang.getSelectedRow();
//        fillHd(index);
//        tienThua(index);
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void btnXoaGhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaGhActionPerformed

        int index = tblGioHang.getSelectedRow();
        int chon = JOptionPane.showConfirmDialog(this, "Bạn chắc có muốn xóa không", "Xác nhận xóa", JOptionPane.YES_NO_CANCEL_OPTION);
        if (chon == JOptionPane.YES_OPTION) {
            listHdct.remove(index);
            loadTableGioHang();
        }
    }//GEN-LAST:event_btnXoaGhActionPerformed

    private void btnDsKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDsKhActionPerformed
        new FormDanhSachKhachHang().setVisible(true);
    }//GEN-LAST:event_btnDsKhActionPerformed

    private void btnResetHdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetHdActionPerformed
        jlbDonGia.setText("0");
        jlbMaHd.setText("Vui lòng tạo!");
        jlbGiamGia.setText("0");
        jlbThanhTien.setText("0");
        jlbTenKh.setText("Khách bán lẻ");
        txtTienKhachDua.setText(null);
        txtGhiChu.setText(null);
        DefaultTableModel model = new DefaultTableModel();
        tblHoaDonCho.setModel(model);
        tblGioHang.setModel(model);
    }//GEN-LAST:event_btnResetHdActionPerformed
    private void addHdc() {
        
        QlHoaDon hd = new QlHoaDon();
       
        hd.setTenKh(jlbMaKh.getText());
        
        iHoaDonSer.addHdcs(hd);
    }
    private void btnTaoHdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHdActionPerformed
//if(jlbMaKh.getText().isBlank()||jlbTenKh.getText().isBlank()){
//    JOptionPane.showMessageDialog(this, "Chưa chọn khách hàng");
//    return;
//}       
        addHdc();
        loadTableHdc2();
    }//GEN-LAST:event_btnTaoHdActionPerformed

    private void txtTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimActionPerformed

    }//GEN-LAST:event_txtTimActionPerformed

    private void txtTimInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtTimInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimInputMethodTextChanged

    private void txtTimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKeyReleased
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã", "Tên", "Đơn giá", "Giảm giá", "Hình dạng mặt số", "Chất liệu mặt kính", "Kích thước", "Màu vỏ", "Thể loại", "Giới tính", "Kiểu máy", "Số lượng tồn"});
        List<QLSanPham_BanHang> listSp = iSanPhamService.timSpTheoMas(txtTim.getText());
        if (listSp == null) {
            JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại");
        }
        for (QLSanPham_BanHang sp : listSp) {
            model.addRow(new Object[]{sp.getMa(), sp.getTen(), sp.getDonGia(), sp.getGiamGia(), sp.getHinhDangMat(),
                sp.getChatLieuMat(), sp.getKichThuoc(), sp.getMauVo(), sp.getTheLoai(), sp.getGioiTinh(), sp.getKieuMay(), sp.getSoLuong()});
        }
        tblSanPham.setModel(model);
    }//GEN-LAST:event_txtTimKeyReleased

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        donHang();
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased
    private void donHang() {
        double donGia = 0;
        int ix = tblGioHang.getRowCount();
        for (int i = 0; i < ix; i++) {

            donGia = donGia + Double.parseDouble(tblGioHang.getValueAt(i, 2).toString());

            jlbDonGia.setText(String.valueOf(donGia));
        }
        double tongTien = 0;

        for (int i = 0; i < ix; i++) {

            tongTien = tongTien + Double.parseDouble(tblGioHang.getValueAt(i, 5).toString());
//  
            jlbThanhTien.setText(String.valueOf(tongTien));
        }
        double giamGia = 0;

        for (int i = 0; i < ix; i++) {

            giamGia = giamGia + Double.parseDouble(tblGioHang.getValueAt(i, 3).toString());
//  
            jlbGiamGia.setText(String.valueOf(giamGia));
            double tienKhachDua = Double.parseDouble(txtTienKhachDua.getText());
            jlbTienThua.setText(String.valueOf(tienKhachDua - tongTien));
        }
    }
    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (jlbMaKh.getText().trim().isEmpty() || jlbTenKh.getText().trim().isEmpty() || txtTienKhachDua.getText().trim().isEmpty() || dateTT.getText().isEmpty() || txtGhiChu.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin");
            return;
        }
        QlHoaDon hd = new QlHoaDon();
        hd.setMaHd(Integer.parseInt(jlbMaHd.getText()));
        hd.setGhiChu(txtGhiChu.getText());
        hd.setNgayTT(dateTT.getText());
        hd.setTongTien(Double.parseDouble(jlbDonGia.getText()));
        hd.setGiamGia(Double.parseDouble(jlbGiamGia.getText()));
        hd.setTienKhachDua(Double.parseDouble(txtTienKhachDua.getText()));
        hd.setHinhThucBh(cboHtbh.getItemAt(cboHtbh.getSelectedIndex()));
        hd.setHinhThucTT(cboHinhThucTT.getItemAt(cboHinhThucTT.getSelectedIndex()));
        iHoaDonSer.updateTTs(hd);
        JOptionPane.showMessageDialog(this, "Thanh toán thành công");
        btnResetHdActionPerformed(evt);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnHuyHdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHdActionPerformed
        if (jlbMaKh.getText().trim().isEmpty() || jlbTenKh.getText().trim().isEmpty() || txtTienKhachDua.getText().trim().isEmpty() || dateTT.getText().isEmpty() || txtGhiChu.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin");
            return;
        }
        QlHoaDon hd = new QlHoaDon();
        hd.setMaHd(Integer.parseInt(jlbMaHd.getText()));
        hd.setGhiChu(txtGhiChu.getText());
        hd.setNgayTT(dateTT.getText());
        hd.setTongTien(Double.parseDouble(jlbDonGia.getText()));
        hd.setGiamGia(Double.parseDouble(jlbGiamGia.getText()));
        hd.setTienKhachDua(Double.parseDouble(txtTienKhachDua.getText()));
        hd.setHinhThucBh(cboHtbh.getItemAt(cboHtbh.getSelectedIndex()));
        hd.setHinhThucTT(cboHinhThucTT.getItemAt(cboHinhThucTT.getSelectedIndex()));
        iHoaDonSer.updateTT2s(hd);
        JOptionPane.showMessageDialog(this, "Hủy thành công");
        btnResetHdActionPerformed(evt);
    }//GEN-LAST:event_btnHuyHdActionPerformed

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        jlbMaKh.setText(FormDanhSachKhachHang.idKh);
        jlbTenKh.setText(FormDanhSachKhachHang.tenKh);
    }//GEN-LAST:event_btnChonActionPerformed

    private void btnDeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAllActionPerformed
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Giảm giá", "Số lượng", "Thành tiền"});      
        tblGioHang.setModel(model);
    }//GEN-LAST:event_btnDeleteAllActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllSp;
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnDeleteAll;
    private javax.swing.JButton btnDsKh;
    private javax.swing.JButton btnHuyHd;
    private javax.swing.JButton btnResetHd;
    private javax.swing.JButton btnTaoHd;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemSp;
    private javax.swing.JButton btnXoaGh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboHinhThucTT;
    private javax.swing.JComboBox<String> cboHtbh;
    private com.github.lgooddatepicker.components.DatePicker dateTT;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jlbClock;
    private javax.swing.JLabel jlbDonGia;
    private javax.swing.JLabel jlbGiamGia;
    private javax.swing.JLabel jlbMaHd;
    private javax.swing.JLabel jlbMaKh;
    private javax.swing.JLabel jlbTenKh;
    private javax.swing.JLabel jlbThanhTien;
    private javax.swing.JLabel jlbTienThua;
    private javax.swing.JLabel jlbUserName;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDonCho;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtIdCtsp;
    private javax.swing.JTextField txtIdHd;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables

}
