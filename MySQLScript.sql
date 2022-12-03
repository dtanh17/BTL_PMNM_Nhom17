-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3306
-- Thời gian đã tạo: Th5 05, 2021 lúc 08:27 AM
-- Phiên bản máy phục vụ: 8.0.21
-- Phiên bản PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlytiendien`
--
-- --------------------------------------------------------

-- CREATE SCHEMA `QuanLyTienDien`;
-- USE `QuanLyTienDien`;

--
-- Cấu trúc bảng cho bảng `KhachHang`
--

DROP TABLE IF EXISTS `KhachHang`;
CREATE TABLE IF NOT EXISTS `KhachHang` (
  `MaKH` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `HoTen` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CCCD` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NgaySinh` date NOT NULL,
  `SoDienThoai` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaKH`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `NhanVien`
--

DROP TABLE IF EXISTS `NhanVien`;
CREATE TABLE IF NOT EXISTS `NhanVien` (
  `MaNV` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `TenNV` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ChucVu` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TaiKhoan` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `MatKhau` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MaNV`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Thang`
--

DROP TABLE IF EXISTS `Thang`;
CREATE TABLE IF NOT EXISTS `Thang` (
  `ThangID` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `NgayDau` date NOT NULL,
  `NgayCuoi` date NOT NULL,
  PRIMARY KEY (`ThangID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
COMMIT;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ChiSoDien`
--

DROP TABLE IF EXISTS `ChiSoDien`;
CREATE TABLE IF NOT EXISTS `ChiSoDien` (
  `ID` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `MaKH` int NOT NULL REFERENCES KhachHang(MaKH),
  `ThangID` int NOT NULL REFERENCES Thang(ThangID),
  `ChiSoCu` int NOT NULL,
  `ChiSoMoi` int NOT NULL,
  `NgayGhi` timestamp NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `HoaDon`
--

DROP TABLE IF EXISTS `HoaDon`;
CREATE TABLE IF NOT EXISTS `HoaDon` (
  `MaHD` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `MaKH` int NOT NULL REFERENCES KhachHang(MaKH),
  `ThangID` int NOT NULL REFERENCES Thang(ThangID),
  `LuongDienTieuThu` int DEFAULT NULL,
  `TongTien` decimal(20,0) DEFAULT NULL,
  `NgayLapPhieu` timestamp NULL DEFAULT NULL,
  `TinhTrang` boolean NOT NULL DEFAULT false,
  `MaNV` int NOT NULL REFERENCES NhanVien(MaNV),
  PRIMARY KEY (`MaHD`,`MaKH`,`ThangID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


ALTER TABLE `KhachHang` AUTO_INCREMENT = 1000;

ALTER TABLE `NhanVien` AUTO_INCREMENT = 1000;

ALTER TABLE `Thang` AUTO_INCREMENT = 1;

ALTER TABLE `HoaDon` AUTO_INCREMENT = 100000;

 
--
-- Đổ dữ liệu cho bảng `KhachHang`
--

INSERT INTO `KhachHang` (`MaKH`,`HoTen`, `DiaChi`, `CCCD`, `NgaySinh`, `SoDienThoai`) VALUES
(1000, 'Ngô Tuấn Tú',	'Số 182, ngõ 11, đường Cầu Diễn, Minh Khai, Bắc Từ Liêm, Hà Nội',	'034200010146',	'1990-07-30',	'0943840321'),
(1001, 'Chu Hoàng Minh',	'Số 23, ngõ 54, đường Cầu Diễn, Minh Khai, Bắc Từ Liêm, Hà Nội','038152000048',	'1993-08-11',	'0977816239'),
(1002, 'Nguyễn Việt Hoàng',	'Số 02, ngõ 23, đường Phúc Diễn, Minh Khai, Bắc Từ Liêm, Hà Nội', '001301019150',	'1998-12-03',	'0984719141'),
(1003, 'Đào Anh Sơn',	'Số 09, ngõ 09, đường Cầu Diễn, Minh Khai, Bắc Từ Liêm, Hà Nội','001088006676',	'1980-09-01',	'0962765326'),
(1004, 'Đặng Thùy Trang',		'Số 123, ngõ 56, đường Cầu Diễn, Minh Khai, Bắc Từ Liêm, Hà Nội','036198005051',	'1999-06-02',	'0919286506'),
(1005, 'Lê Kim Anh',		'Số 56, ngõ 134, đường Phúc Diễn, Minh Khai, Bắc Từ Liêm, Hà Nội','110611332',	'1982-07-20',	'0986694740'),
(1006, 'Nguyễn Thị Hương',		'Số 76/24, ngõ 235, đường Cầu Diễn, Minh Khai, Bắc Từ Liêm, Hà Nội','1148002841',	'1982-12-14',	'0962234901'),
(1007, 'Lê Thu Hằng',	'Số 284, ngõ 7, đường Phúc Diễn, Minh Khai, Bắc Từ Liêm, Hà Nội','036085003921',	'1979-03-16',	'0988302858'),
(1008, 'Nguyễn Bảo Linh',	'Số 50, ngõ 130, đường Cầu Diễn, Minh Khai, Bắc Từ Liêm, Hà Nội','110432858',	'1985-04-14',	'0912530992'),
(1009, 'Trần Việt Quốc',	'Số 12, ngõ 18, đường Cầu Diễn, Minh Khai, Bắc Từ Liêm, Hà Nội',	'034188004647',	'1995-10-01',	'0972669599'),
(1010, 'Bùi Thanh Sơn',	'Số 18, ngõ 02, đường Phúc Diễn, Minh Khai, Bắc Từ Liêm, Hà Nội','038081004732',	'1997-03-13',	'0988302858'),
(1011, 'Nguyễn Quốc Thịnh',	'Số 1, ngõ 15, đường Cầu Diễn, Minh Khai, Bắc Từ Liêm, Hà Nội','001185018699',	'1998-07-15',	'0977552795');

--
-- Đổ dữ liệu cho bảng `NhanVien`
--

INSERT INTO `NhanVien`(`MaNV`, `TenNV`, `ChucVu`, `TaiKhoan`, `MatKhau`) VALUES 
(1000,	'Đỗ Thị Hồng Anh',	'QuanLy',	'admin',	MD5('admin')	),
(1001,	'Trần Văn Quân',	'QuanLy',	'quanly',	MD5('quanly')	),
(1002,	'Lê Văn Công',		'ThoDien',	'thodien1',	MD5('123456')	),
(1003,	'Hoàng Thế Nam',	'ThoDien',	'thodien2',	MD5('123456')	),
(1004,	'Lê Sỹ Tôn',		'ThoDien',	'thodien3',	MD5('1234567')	),
(1005,	'Nguyễn Thu Ngân',	'ThuTien',	'thutien1',	MD5('12345')	),
(1006,	'Hoàng Thiên Linh',	'ThuTien',	'thutien2',	MD5('123456789'));

--
-- Đổ dữ liệu cho bảng `Thang`
--

INSERT INTO `Thang`(`ThangID`, `NgayDau`, `NgayCuoi`) VALUES 
(1,	'2022-01-22',	'2022-02-21'),
(2,	'2022-02-22',	'2022-03-21'),
(3,	'2022-03-22',	'2022-04-21');

--
-- Đổ dữ liệu cho bảng `ChiSoDien`
--

INSERT INTO `ChiSoDien`(`MaKH`, `ThangID`, `ChiSoCu`, `ChiSoMoi`, `NgayGhi`) VALUES 
(1000,1,5680,5800,'2022-02-21'),
(1001,1,4500,4750,'2022-02-21'),
(1002,1,1520,1950,'2022-02-21'),
(1003,1,3400,3600,'2022-02-21'),
(1004,1,1000,1200,'2022-02-21'),
(1005,1,1200,1250,'2022-02-21'),
(1006,1,7600,7900,'2022-02-21'),

(1000,2,5800,5990,'2022-03-21'),
(1001,2,4750,4960,'2022-03-21'),
(1002,2,1950,2100,'2022-03-21'),
(1003,2,3600,3900,'2022-03-21'),
(1004,2,1200,1500,'2022-03-21'),
(1005,2,1250,1350,'2022-03-21'),
(1006,2,7900,8200,'2022-03-21'),

(1000,3,5990,6200,'2022-04-21'),
(1001,3,4960,5190,'2022-04-21'),
(1002,3,2100,2200,'2022-04-21'),
(1003,3,3900,4500,'2022-04-21'),
(1004,3,1500,1700,'2022-04-21'),
(1005,3,1350,1401,'2022-04-21'),
(1006,3,8200,8600,'2022-04-21');


--
-- Đổ dữ liệu cho bảng `HoaDon`
--



INSERT INTO `HoaDon`(`MaHD`, `MaKH`, `ThangID`, `LuongDienTieuThu`, `TongTien`, `NgayLapPhieu`, `TinhTrang`, `MaNV`) VALUES 
(100001,1000,1,5800-5680,(5800-5680)*2500,'2022-02-25',true,1005),
(100002,1001,1,4750-4500,(4750-4500)*2500,'2022-02-28',true,1005),
(100003,1002,1,1950-1520,(1950-1520)*2500,'2022-02-26',true,1006),
(100004,1003,1,3600-3400,(3600-3400)*2500,'2022-02-25',true,1006),
(100005,1004,1,1200-1000,(1200-1000)*2500,'2022-02-28',true,1006),
(100006,1005,1,1250-1200,(1250-1200)*2500,'2022-02-25',true,1005),
(100007,1006,1,7900-7600,(7900-7600)*2500,'2022-02-28',true,1005),

(100008,1000,2,5990-5800,(5990-5800)*2500,'2022-03-25',true,1006),
(100009,1001,2,4960-4750,(4960-4750)*2500,'2022-03-25',true,1005),
(100010,1002,2,2100-1950,(2100-1950)*2500,'2022-03-26',true,1006),
(100011,1003,2,3900-3600,(3900-3600)*2500,'2022-03-28',true,1006),
(100012,1004,2,1500-1200,(1500-1200)*2500,'2022-03-25',true,1006),
(100013,1005,2,1350-1250,(1350-1250)*2500,'2022-03-25',true,1005),
(100014,1006,2,8200-7900,(8200-7900)*2500,'2022-03-28',true,1005),

(100015,1000,3,6200-5990,(6200-5990)*2500,'2022-04-26',true,1005),
(100016,1001,3,5190-4960,(5190-4960)*2500,'2022-04-30',true,1006),
(100018,1003,3,4500-3900,(4500-3900)*2500,'2022-04-27',true,1006),
(100020,1005,3,1401-1350,(1401-1350)*2500,'2022-02-26',true,1006);
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
