package org.example.quanlycongviec.service.implement;

import org.example.quanlycongviec.entity.SuKien;
import org.example.quanlycongviec.repository.SuKienRepository;
import org.example.quanlycongviec.service.SuKienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SuKienServiceImpl implements SuKienService {

    private SuKienRepository suKienRepository;
    @Override
    public SuKien save(SuKien suKien) {
        return suKienRepository.save(suKien);
    }

    @Override
    public List<SuKien> timSuKienTheoNgayCuaNguoiDung(String ngay, int maNd) {
      return suKienRepository.findByNgayAndNguoiDung_MaNguoiDung(ngay,maNd);
    }

    @Override
    public List<SuKien> timSuKienSapToiCuaNguoiDung(String ngay, int maNd) {
        return suKienRepository.findNearlyEvent(ngay,maNd);
    }

    @Autowired
    public void setSuKienRepository(SuKienRepository suKienRepository) {
        this.suKienRepository = suKienRepository;
    }
}
