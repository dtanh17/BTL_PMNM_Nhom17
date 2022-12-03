/*
 * Project Name:      Phan Mem Quan Ly Tien Dien Java
 * Description:       Bai tap lon Java Quan Ly Tien Dien JDBC + Swing
 * Author:            Nhom 17
 * 
 */
package services;

import Qltd.NhanVienQltd;
import Qltd.NhanVienQltdImpl;
import java.util.List;
import models.NhanVien;

/**
 *
 * @author Tuan Anh
 */
public class NhanVienServiceImpl implements NhanVienService{
    
    private NhanVienQltd nhanVienQltd = null;

    public NhanVienServiceImpl() {
        nhanVienQltd = new NhanVienQltdImpl();
    }
    
    @Override
    public NhanVien getLogin(String taiKhoan, String matKhau) {
        return nhanVienQltd.getLogin(taiKhoan, matKhau);
    }

    @Override
    public List<NhanVien> getList() {
        return nhanVienQltd.getList();
    }

    @Override
    public int create(NhanVien nhanVien) {
        return nhanVienQltd.create(nhanVien);
    }
    
    @Override
    public int update(NhanVien nhanVien) {
        return nhanVienQltd.update(nhanVien);
    }

    @Override
    public boolean deleteData(int maNV) {
        return nhanVienQltd.deleteData(maNV);
    }

    @Override
    public int changePassword(int maNV, String oldPass, String newPass) {
        return nhanVienQltd.changePassword(maNV, oldPass, newPass);
    }
    
}
