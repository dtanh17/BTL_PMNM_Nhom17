/*
 * Project Name:      Phan Mem Quan Ly Tien Dien Java
 * Description:       Bai tap lon Java Quan Ly Tien Dien JDBC + Swing
 * Author:            Nhom 17
 * 
 */
package controllers;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import models.NhanVien;
import services.NhanVienService;
import services.NhanVienServiceImpl;
import utility.ClassTableModel;

/**
 *
 * @author Tuan Anh
 */
public class NhanVienController {
    //Info 
    private JTextField jtfMaNV;
    private JTextField jtfTenNV;
    private JComboBox jcbChucVu;
    private JTextField jtfTaiKhoan;
    private JPasswordField jpfPassword;
    
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btnReset;
    
    // Doi MK
    private JPasswordField jpfOld;
    private JPasswordField jpfNew;
    private JPasswordField jpfReConfirm;
    
    private JButton btnDoiMK;
    
    // View
    private JTextField jtfSearchUser;
    private JPanel jpnTableUser;

    
    private NhanVienService nvService = new NhanVienServiceImpl();
    private ClassTableModel classTableModel = new ClassTableModel();
    private TableRowSorter<TableModel> rowSorter = null;
    
    public NhanVienController(JTextField jtfMaNV, JTextField jtfTenNV, JComboBox jcbChucVu, JTextField jtfTaiKhoan, JPasswordField jpfPassword, 
            JButton btnThem, JButton btnSua, JButton btnXoa, JButton btnReset, 
            JPasswordField jpfOld, JPasswordField jpfNew, JPasswordField jpfReConfirm, JButton btnDoiMK, 
            JTextField jtfSearchUser, JPanel jpnTableUser) {
        this.jtfMaNV = jtfMaNV;
        this.jtfTenNV = jtfTenNV;
        this.jcbChucVu = jcbChucVu;
        this.jtfTaiKhoan = jtfTaiKhoan;
        this.jpfPassword = jpfPassword;
        this.btnThem = btnThem;
        this.btnSua = btnSua;
        this.btnXoa = btnXoa;
        this.btnReset = btnReset;
        
        this.jpfOld = jpfOld;
        this.jpfNew = jpfNew;
        this.jpfReConfirm = jpfReConfirm;
        this.btnDoiMK = btnDoiMK;
        
        this.jtfSearchUser = jtfSearchUser;
        this.jpnTableUser = jpnTableUser;
        
        
    }
    
    
    
    public void setDataToTable() {
        final String[] COLUMNS = {"M?? NV", "T??n NV", "Ch???c v???", "T??i kho???n"};
        List<NhanVien> listItem = nvService.getList();
        
        DefaultTableModel model = classTableModel.setTableNhanVien(listItem, COLUMNS);
        
        JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        jtfSearchUser.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearchUser.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearchUser.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        
        table.addMouseListener(new MouseAdapter() {
            //S??? ki???n click ????p v??o th?? s??? m??? jdialog ????? ch???nh s???a
            @Override
            public void mouseClicked(MouseEvent e) {
                if (table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.convertRowIndexToModel(table.getSelectedRow());
                    //selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);
                    
                    // Lay thong tin tren bang
                    String maNV = model.getValueAt(selectedRowIndex, 0).toString() != null?
                            model.getValueAt(selectedRowIndex, 0).toString() : "";
                    String tenNV = model.getValueAt(selectedRowIndex, 1).toString() != null?
                            model.getValueAt(selectedRowIndex, 1).toString() : "";
                    String chucVu = model.getValueAt(selectedRowIndex, 2).toString() != null?
                            model.getValueAt(selectedRowIndex, 2).toString() : "";
                   String taiKhoan = model.getValueAt(selectedRowIndex, 3).toString() != null?
                            model.getValueAt(selectedRowIndex, 3).toString() : "";
                    
                    jtfMaNV.setText(maNV);
                    jtfTenNV.setText(tenNV);
                    jcbChucVu.setSelectedItem(chucVu);
                    jtfTaiKhoan.setText(taiKhoan);
                    
                    // Disable - enable
                    jpfPassword.setEnabled(false);

                    btnThem.setEnabled(false);
                    btnSua.setEnabled(true);
                    btnXoa.setEnabled(true);

                    jpfNew.setEnabled(true);
                    jpfOld.setEnabled(true);
                    jpfReConfirm.setEnabled(true);

                    btnDoiMK.setEnabled(true);
                }
            }
            
            
            
        });

        // design
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnTableUser.removeAll();
        jpnTableUser.setLayout(new CardLayout());
        jpnTableUser.add(scroll);
        jpnTableUser.validate();
        jpnTableUser.repaint();
    }
    
    public void setEvent(){
        //S??? ki???n btnResset
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetDefault();
            }
        });
        //S??? ki???n cho btnThem
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get from field
                String tenNV = jtfTenNV.getText();
                String chucVu = jcbChucVu.getSelectedItem().toString();
                String taiKhoan = jtfTaiKhoan.getText();
                String matKhau = String.valueOf(jpfPassword.getPassword()).trim();
                
                if (tenNV.isEmpty() || taiKhoan.isEmpty() || matKhau.isEmpty()) {
                    JOptionPane.showMessageDialog(jpnTableUser.getRootPane(), "Vui l??ng nh???p ?????y ????? c??c tr?????ng!");
                } else {
                    // m?? ho?? md5 m???t kh???u
                    String matKhauHashed = models.Security.getMD5(matKhau);
                    NhanVien nv = new NhanVien(0, tenNV, chucVu, taiKhoan, matKhauHashed);
                     int check = nvService.create(nv);
                     if (check > 0) {
                        JOptionPane.showMessageDialog(jpnTableUser.getRootPane(), "Th??m th??nh c??ng!");
                        setDataToTable();
                        resetDefault();
                    } else if (check == -1) {
                        JOptionPane.showMessageDialog(jpnTableUser.getRootPane(), "T??n t??i kho???n ???? t???n t???i!");
                    } else {
                        JOptionPane.showMessageDialog(jpnTableUser.getRootPane(), "Th??m th???t b???i!");
                    }
                }
            }
            
        });
        
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //get from field
                int maNV = Integer.parseInt(jtfMaNV.getText());
                String tenNV = jtfTenNV.getText();
                String chucVu = jcbChucVu.getSelectedItem().toString();
                String taiKhoan = jtfTaiKhoan.getText();
                
                
                if (maNV < 1 || tenNV.isEmpty() || taiKhoan.isEmpty()) {
                    JOptionPane.showMessageDialog(jpnTableUser.getRootPane(), "Vui l??ng nh???p ?????y ????? c??c tr?????ng!");
                } else {
                    NhanVien nv = new NhanVien(maNV, tenNV, chucVu, taiKhoan, "");
                    int check = nvService.update(nv);
                    if (check == -1) {
                        JOptionPane.showMessageDialog(jpnTableUser.getRootPane(), "T??n t??i kho???n ???? t???n t???i!");
                    } else if (check == 0) {
                        JOptionPane.showMessageDialog(jpnTableUser.getRootPane(), "S???a th???t b???i!");
                    } else  {
                        JOptionPane.showMessageDialog(jpnTableUser.getRootPane(), "S???a th??nh c??ng!");
                        setDataToTable();
                        resetDefault();
                    }
                }
            }
        });
        
        
        // S??? ki???n btn xoa
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int maNV = Integer.parseInt(jtfMaNV.getText());
                
                if (nvService.deleteData(maNV)) {
                    JOptionPane.showMessageDialog(jpnTableUser.getRootPane(), "Xo?? th??nh c??ng!");
                    setDataToTable();
                    resetDefault();
                } else {
                    
                    JOptionPane.showMessageDialog(jpnTableUser.getRootPane(), "C?? l???i x???y ra!");
                }
            }
        });
        
        // S??? ki???n ?????i m???t kh???u
        btnDoiMK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int maNV = Integer.parseInt(jtfMaNV.getText());
                String oldPass = String.valueOf(jpfOld.getPassword()).trim();
                String newPass = String.valueOf(jpfNew.getPassword()).trim();
                String reConfirm = String.valueOf(jpfReConfirm.getPassword()).trim();
                
                if (oldPass.isEmpty() || newPass.isEmpty() || reConfirm.isEmpty()) {
                    JOptionPane.showMessageDialog(jpnTableUser.getRootPane(), "Kh??ng ???????c ????? tr???ng!");
                } else if (oldPass.compareTo(newPass) == 0) {
                    JOptionPane.showMessageDialog(jpnTableUser.getRootPane(), "M???t kh???u m???i gi???ng m???t kh???u c??!");
                } else if (newPass.compareTo(reConfirm) !=0) {
                    JOptionPane.showMessageDialog(jpnTableUser.getRootPane(), "Hai m???t kh???u x??c nh???n kh??ng gi???ng nhau!");
                } else {
                    String oldPassHashed = models.Security.getMD5(oldPass);
                    String newPassHashed = models.Security.getMD5(newPass);
                    int check = nvService.changePassword(maNV, oldPassHashed, newPassHashed);
                    System.out.println(oldPassHashed);
                    System.out.println(newPassHashed);
                    if (check==-10) {
                        JOptionPane.showMessageDialog(jpnTableUser.getRootPane(), "M???t kh???u c?? kh??ng kh???p!");
                    } else if(check == 0) {
                        JOptionPane.showMessageDialog(jpnTableUser.getRootPane(), "?????i m???t kh???u th???t b???i!");
                    } else {
                        JOptionPane.showMessageDialog(jpnTableUser.getRootPane(), "?????i m???t kh???u th??nh c??ng!");
                        setDataToTable();
                        resetDefault();
                    }
                }
            }
        });
    }
    private void resetDefault()
    {
        jtfMaNV.setEnabled(false);
        jtfTenNV.setEnabled(true);
        jtfTaiKhoan.setEnabled(true);
        jpfPassword.setEnabled(true);
        
        btnThem.setEnabled(true);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        
        jpfNew.setEnabled(false);
        jpfOld.setEnabled(false);
        jpfReConfirm.setEnabled(false);
        
        btnDoiMK.setEnabled(false);
        
        //Clear
        
        jtfMaNV.setText("");
        jtfTenNV.setText("");
        jtfTaiKhoan.setText("");
        jpfPassword.setText("");
        
        jpfNew.setText("");
        jpfOld.setText("");
        jpfReConfirm.setText("");
    }
}
