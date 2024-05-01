package org.example.quanlycongviec.service.implement;

import org.example.quanlycongviec.entity.NguoiDung;
import org.example.quanlycongviec.entity.SuKien;
import org.example.quanlycongviec.repository.NguoiDungRepository;
import org.example.quanlycongviec.repository.SuKienRepository;
import org.example.quanlycongviec.service.SuKienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SuKienServiceImpl implements SuKienService {

    private SuKienRepository suKienRepository;

    @Autowired
    private NguoiDungRepository nguoiDungRepository;


    @Override
    public List<SuKien> timSuKienTheoNgayCuaNguoiDung(String ngay, int maNd) {
      return suKienRepository.findByNgayAndNguoiDung_MaNguoiDung(ngay,maNd);
    }

    @Override
    public List<SuKien> timSuKienSapToiCuaNguoiDung(String ngay, int maNd) {
        return suKienRepository.findNearlyEvent(ngay,maNd);
    }

    @Override
    public SuKien add(SuKien suKien, int maNd) {
        SuKien sk= new SuKien();
        sk.setGio(suKien.getGio());
        sk.setTenSuKien(suKien.getTenSuKien());
        sk.setNgay(suKien.getNgay());
        sk.setNhacTruoc(suKien.getNhacTruoc());
        sk.setMoTa(suKien.getMoTa());
        sk.setNgayNhac(suKien.getNgayNhac());
        NguoiDung nd = nguoiDungRepository.findById(maNd).get();
        sk.setNguoiDung(nd);
        return suKienRepository.save(sk);
    }

    @Override
    public SuKien update(SuKien suKien, int maNd) {
        SuKien sk= new SuKien();
        sk.setMaSK(suKien.getMaSK());
        sk.setGio(suKien.getGio());
        sk.setTenSuKien(suKien.getTenSuKien());
        sk.setNgay(suKien.getNgay());
        sk.setNhacTruoc(suKien.getNhacTruoc());
        sk.setMoTa(suKien.getMoTa());
        sk.setNgayNhac(suKien.getNgayNhac());
        NguoiDung nd = nguoiDungRepository.findById(maNd).get();
        sk.setNguoiDung(nd);
       return suKienRepository.save(sk);
    }

    @Override
    public Void delete(int maSuKien) {

        suKienRepository.deleteById(maSuKien);
        return null;
    }

    @Override
    public List<SuKien> layTatCaSuKienCuaNguoiDung(int maNd) {
        return suKienRepository.getAllEventOfUser(maNd);
    }

    @Override
    public List<SuKien> laySuKienTuNgayDenNgayCuaNguoiDung(int maNd, String ngayBD, String ngayKT) {
        return suKienRepository.findEventsFromDayToDay(maNd, ngayBD, ngayKT);
    }

    @Autowired
    public void setSuKienRepository(SuKienRepository suKienRepository) {
        this.suKienRepository = suKienRepository;
    }
}
