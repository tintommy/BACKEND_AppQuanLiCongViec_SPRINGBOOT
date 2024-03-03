package org.example.quanlycongviec.service.implement;

import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.entity.NguoiDung;
import org.example.quanlycongviec.repository.CongViecRepository;
import org.example.quanlycongviec.service.CongViecService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CongViecServiceImpl implements CongViecService {
    @Autowired
    CongViecRepository congViecRepository;
    @Override
    public List<CongViecNgay> layTatCaCongViecNgayCuaNguoiDung(int maNguoiDung) {
        return congViecRepository.layTatCaCongViecNgayCuaNguoiDung(maNguoiDung);
    }
}
