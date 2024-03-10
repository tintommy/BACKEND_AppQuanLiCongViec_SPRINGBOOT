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
    public List<CongViecNgay> layTatCaCongViecNgayCuaNguoiDung(int maNguoiDung,String ngayLam) {
        return congViecNgayRepository.findByCongViec_NguoiDung_MaNguoiDungAndNgayLam(maNguoiDung,ngayLam);
    }

    @Override
    public CongViecNgay save(CongViecNgay congViecNgay) {
        return congViecNgayRepository.save(congViecNgay);
    }

    @Override
    public void deleteById(int maCvNgay) {
        congViecNgayRepository.deleteById(maCvNgay);
    }

    @Override
    public CongViecNgay layCongViecNgayTheoMaCvNgay(int maCvNgay) {
        return congViecNgayRepository.findByMaCvNgay(maCvNgay);
    }


}
