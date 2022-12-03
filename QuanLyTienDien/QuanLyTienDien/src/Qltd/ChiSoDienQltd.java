/*
 * Project Name:      Phan Mem Quan Ly Tien Dien Java
 * Description:       Bai tap lon Java Quan Ly Tien Dien JDBC + Swing
 * Author:            Nhom 17
 * 
 */
package Qltd;

import java.util.List;
import models.ChiSoDien;

/**
 *
 * @author Tuan Anh
 */
public interface ChiSoDienQltd {
    public List<ChiSoDien> getList();
    // Lấy danh sách chỉ số điện chưa lập hoá đơn
    public List<ChiSoDien> getListExcludedInHoaDon();
    public ChiSoDien getChiSoDien(int maKH, int thangID);
    public ChiSoDien getLastChiSoDien(int maKH);
    public ChiSoDien getFirstChiSoDien(int maKH);
    public int createORUpdate(ChiSoDien chiSoDien);
}
