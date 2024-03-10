package org.example.quanlycongviec.service;

import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.entity.HinhAnh;

import java.util.List;

public interface HinhAnhService {
    List<HinhAnh> layTatCaHinhAnhCuaCongViecNgay(int maCvNgay);
    void save(HinhAnh hinhAnh);
    void saveAll(List<HinhAnh> hinhAnhList);
    void xoaHinhAnhTheoMa(int maHinhAnh);
}
