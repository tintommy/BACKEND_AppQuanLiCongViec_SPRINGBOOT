package org.example.quanlycongviec.service.implement;

import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.repository.CongViecRepository;
import org.example.quanlycongviec.service.CongViecNgayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongViecNgayImpl implements CongViecNgayService {
    private CongViecRepository congViecRepository;

    @Autowired
    public void setCongViecRepository(CongViecRepository congViecRepository) {
        this.congViecRepository = congViecRepository;
    }


    @Override
    public List<CongViecNgay> layTatCaCongViecNgayCuaNguoiDung(int maNguoiDung) {
        return null;
    }
}
