/*
 * Project Name:      Phan Mem Quan Ly Tien Dien Java
 * Description:       Bai tap lon Java Quan Ly Tien Dien JDBC + Swing
 * Author:            Nhom 17
 * 
 */
package services;

import Qltd.ChiSoDienQltdImpl;
import java.util.List;
import models.ChiSoDien;
import models.Thang;

/**
 *
 * @author Tuan Anh
 */
public class ChiSoDienServiceImpl implements ChiSoDienService{

    private ChiSoDienQltdImpl chiSoDienQltdImpl = null;

    public ChiSoDienServiceImpl() {
        chiSoDienQltdImpl = new ChiSoDienQltdImpl();
    }
    
    @Override
    public List<ChiSoDien> getList() {
        return chiSoDienQltdImpl.getList();
    }

    @Override
    public List<ChiSoDien> getListExcludedInHoaDon() {
        return chiSoDienQltdImpl.getListExcludedInHoaDon();
    }

    @Override
    public ChiSoDien getChiSoDien(int maKH, int thangID) {
        return chiSoDienQltdImpl.getChiSoDien(maKH, thangID);
    }

    @Override
    public ChiSoDien getLastChiSoDien(int maKH) {
        return chiSoDienQltdImpl.getLastChiSoDien(maKH);
    }

    @Override
    public ChiSoDien getFirstChiSoDien(int maKH) {
        return chiSoDienQltdImpl.getFirstChiSoDien(maKH);
    }

    @Override
    public int createORUpdate(ChiSoDien chiSoDien) {
        return chiSoDienQltdImpl.createORUpdate(chiSoDien);
    }

    @Override
    public List<ChiSoDien> getListOfThang(Thang thang) {
        return chiSoDienQltdImpl.getListOfThang(thang);
    }
    
}
