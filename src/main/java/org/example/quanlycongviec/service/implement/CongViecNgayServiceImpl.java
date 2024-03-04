package org.example.quanlycongviec.service.implement;

import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.repository.CongViecNgayRepository;
import org.example.quanlycongviec.service.CongViecNgayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongViecNgayServiceImpl implements CongViecNgayService {
    private CongViecNgayRepository congViecNgayRepository;

    @Autowired
    public void setCongViecNgayRepository(CongViecNgayRepository congViecNgayRepository) {
        this.congViecNgayRepository = congViecNgayRepository;
    }

    @Override
    public List<CongViecNgay> layTatCaCongViecNgayCuaNguoiDung(int maNguoiDung) {
        return congViecNgayRepository.findByCongViec_NguoiDung_MaNguoiDung(maNguoiDung);
    }

    @Override
    public CongViecNgay save(CongViecNgay congViecNgay) {
        return congViecNgayRepository.save(congViecNgay);
    }


}
