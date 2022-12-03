/*
 * Project Name:      Phan Mem Quan Ly Tien Dien Java
 * Description:       Bai tap lon Java Quan Ly Tien Dien JDBC + Swing
 * Author:            Nhom 17
 * 
 */
package Qltd;

import java.util.List;
import models.HoaDon;
import models.Thang;

/**
 *
 * @author Tuan Anh
 */
public interface HoaDonQltd {
    public List<HoaDon> getList();
    public boolean deleteData(long maHoaDon);
    public int createHoaDon(HoaDon hoaDon);
    public int updateBillStatus(int maHD);
    public List<HoaDon> getListOfThang(Thang thang);
}
