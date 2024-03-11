package org.example.quanlycongviec.service.implement;

import org.example.quanlycongviec.entity.HinhAnh;
import org.example.quanlycongviec.repository.HinhAnhRepository;
import org.example.quanlycongviec.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HinhAnhServiceImpl implements HinhAnhService {
    @Autowired
    HinhAnhRepository hinhAnhRepository;

    @Override
    public List<HinhAnh> layTatCaHinhAnhCuaCongViecNgay(int maCvNgay) {
        return hinhAnhRepository.findByCvNgay_MaCvNgay(maCvNgay);
    }

    @Override
    public void save(HinhAnh hinhAnh) {
        hinhAnhRepository.save(hinhAnh);
    }

    @Override
    public void saveAll(List<HinhAnh> hinhAnhList) {

        try {
            hinhAnhRepository.saveAll(hinhAnhList);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void xoaHinhAnhTheoMa(int maHinhAnh) {
        hinhAnhRepository.deleteById(maHinhAnh);
    }
}
