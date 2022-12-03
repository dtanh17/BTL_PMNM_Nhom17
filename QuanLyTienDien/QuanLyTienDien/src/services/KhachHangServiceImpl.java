/*
 * Project Name:      Phan Mem Quan Ly Tien Dien Java
 * Description:       Bai tap lon Java Quan Ly Tien Dien JDBC + Swing
 * Author:            Nhom 17
 * 
 */
package services;

import Qltd.KhachHangQltd;
import Qltd.KhachHangQltdImpl;
import java.util.List;
import models.KhachHang;

/**
 *
 * @author Tuan Anh
 */
public class KhachHangServiceImpl implements KhachHangService{
    
    private KhachHangQltd khachHangQltd = null;

    public KhachHangServiceImpl() {
        khachHangQltd = new KhachHangQltdImpl();
    }
    
    
    @Override
    public List<KhachHang> getList() {
        return khachHangQltd.getList();
    }

    @Override
    public int createORUpdate(KhachHang khachHang) {
        return khachHangQltd.createORUpdate(khachHang);
    }

    @Override
    public boolean deleteData(KhachHang khachHang) {
        return khachHangQltd.deleteData(khachHang);
    }

    @Override
    public KhachHang getKhachHang(int maKH) {
        return khachHangQltd.getKhachHang(maKH);
    }
    
}
