/*
 * Project Name:      Phan Mem Quan Ly Tien Dien Java
 * Description:       Bai tap lon Java Quan Ly Tien Dien JDBC + Swing
 * Author:            Nhom 17
 * 
 */
package services;

import Qltd.HoaDonQltd;
import Qltd.HoaDonQltdImpl;
import java.util.List;
import models.HoaDon;
import models.Thang;

/**
 *
 * @author Tuan Anh
 */
public class HoaDonServiceImpl implements HoaDonService{

    private HoaDonQltd hoaDonHuyImpl = null;

    public HoaDonServiceImpl() {
        hoaDonHuyImpl = new HoaDonQltdImpl();
    }
    
    @Override
    public List<HoaDon> getList() {
        return hoaDonHuyImpl.getList();
    }

    @Override
    public boolean deleteData(long maHoaDon) {
        return hoaDonHuyImpl.deleteData(maHoaDon);
    }

    @Override
    public int createHoaDon(HoaDon hoaDon) {
        return hoaDonHuyImpl.createHoaDon(hoaDon);
    }

    @Override
    public int updateBillStatus(int maHD) {
        return hoaDonHuyImpl.updateBillStatus(maHD);
    }

    public List<HoaDon> getListOfThang(Thang thang) {
        return hoaDonHuyImpl.getListOfThang(thang);
    }
    
}
