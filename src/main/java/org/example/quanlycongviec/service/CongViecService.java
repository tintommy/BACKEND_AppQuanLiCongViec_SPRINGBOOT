package org.example.quanlycongviec.service;

import org.example.quanlycongviec.entity.CongViec;
import org.example.quanlycongviec.entity.CongViecNgay;

import java.util.List;

public interface CongViecService {
    CongViec save(CongViec congViec);
    List<String> danhSachNgay(int maNd);

}
