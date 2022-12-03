/*
 * Project Name:      Phan Mem Quan Ly Tien Dien Java
 * Description:       Bai tap lon Java Quan Ly Tien Dien JDBC + Swing
 * Author:            Nhom 17
 * 
 */
package services;

import Qltd.ThongKeQltdImpl;
import java.util.List;


public class ThongKeServiceImpl implements ThongKeService {

    ThongKeQltdImpl thongKeHuyImpl = new ThongKeQltdImpl();
    @Override
    public List<List<Object>> getRawData() {
        return thongKeHuyImpl.getRawData();
    }
    
}
