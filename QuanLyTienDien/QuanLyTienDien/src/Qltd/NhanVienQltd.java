/*
 * Project Name:      Phan Mem Quan Ly Tien Dien Java
 * Description:       Bai tap lon Java Quan Ly Tien Dien JDBC + Swing
 * Author:            Nhom 17
 * 
 */
package Qltd;

import java.util.List;
import models.NhanVien;

/**
 *
 * @author Tuan Anh
 */
public interface NhanVienQltd {
    public List<NhanVien> getList();
    public int create(NhanVien nhanVien);
    public int update(NhanVien nhanVien);
    public boolean deleteData(int maNV);
    public int changePassword(int maNV, String oldPass, String newPass);
    public NhanVien getLogin(String taiKhoan, String matKhau);
}
