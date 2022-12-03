/*
 * Project Name:      Phan Mem Quan Ly Tien Dien Java
 * Description:       Bai tap lon Java Quan Ly Tien Dien JDBC + Swing
 * Author:            Nhom 17
 * 
 */
package services;

import Qltd.ThangQltd;
import Qltd.ThangQltdImpl;
import java.util.List;
import models.Thang;

/**
 *
 * @author Tuan Anh
 */
public class ThangServiceImpl implements ThangService{
    
    private ThangQltd thangQltd = null;

    public ThangServiceImpl() {
        thangQltd = new ThangQltdImpl();
    }

    @Override
    public List<Thang> getList() {
        return thangQltd.getList();
    }

    @Override
    public int createORUpdate(Thang thang) {
        return thangQltd.createORUpdate(thang);
    }

    @Override
    public Thang getThang(int thangID) {
        return thangQltd.getThang(thangID);
    }

    @Override
    public Thang getLastThangOf(int maKH) {
        return thangQltd.getLastThangOf(maKH);
    }

    @Override
    public Thang getLastThang() {
        return thangQltd.getLastThang();
    }
    
}
