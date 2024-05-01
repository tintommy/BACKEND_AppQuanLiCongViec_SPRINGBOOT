package org.example.quanlycongviec.service.implement;

import org.example.quanlycongviec.entity.CongViec;
import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.repository.CongViecNgayRepository;
import org.example.quanlycongviec.repository.CongViecRepository;
import org.example.quanlycongviec.service.CongViecNgayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CongViecNgayServiceImpl implements CongViecNgayService {
    private CongViecNgayRepository congViecNgayRepository;
    @Autowired
    CongViecRepository congViecRepository;

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

    @Override
    public List<CongViecNgay> layTatCaCongViecNgayCuaNguoiDungTheoThangNam(int maNd, int thang, int nam) {
        return congViecNgayRepository.getAllTaskOfUserByMonthYear(maNd,thang,nam);
    }

    @Override

    public CongViecNgay capNhatCvNgay(CongViecNgay congViecNgay, int maCv) {
        Optional<CongViec> cv = congViecRepository.findById(maCv);
        congViecNgay.setCongViec(cv.get());
        return congViecNgayRepository.save(congViecNgay);
    }    


    @Override
    public List<CongViecNgay> layTatCaCongViecTuNgayDenNgay(int maNd, String ngayBatDau, String ngayKetThuc) {
        return congViecNgayRepository.findByCongViec_NguoiDung_MaNguoiDungAndNgayLamBetween(maNd,ngayBatDau,ngayKetThuc);

    }


}
