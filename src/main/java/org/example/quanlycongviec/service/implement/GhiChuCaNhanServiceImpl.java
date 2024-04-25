package org.example.quanlycongviec.service.implement;

import org.example.quanlycongviec.entity.GhiChuCaNhan;
import org.example.quanlycongviec.entity.NguoiDung;
import org.example.quanlycongviec.repository.GhiChuCaNhanRepository;
import org.example.quanlycongviec.repository.NguoiDungRepository;
import org.example.quanlycongviec.service.GhiChuCaNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GhiChuCaNhanServiceImpl implements GhiChuCaNhanService {

    private GhiChuCaNhanRepository ghiChuCaNhanRepository;

    @Autowired
    private NguoiDungRepository nguoiDungRepository;
    @Override
    public GhiChuCaNhan save(GhiChuCaNhan ghiChuCaNhan) {
        return ghiChuCaNhanRepository.save(ghiChuCaNhan);
    }

    @Override
    public List<GhiChuCaNhan> timDanhSachGhiChuTheoMaNguoiDung(int maNd) {
        return ghiChuCaNhanRepository.timDanhSachGhiChuTheoMaNguoiDung(maNd);
    }

    @Override
    public Void xoaTheoMa(int maGhiChu) {
        ghiChuCaNhanRepository.deleteById(maGhiChu);
        return null;
    }

    @Override
    public GhiChuCaNhan taoHoacSuaGhiChu(GhiChuCaNhan gccn, String email) {
        NguoiDung nd = nguoiDungRepository.findByEmail(email) ;
        gccn.setNguoiDung(nd);
        return ghiChuCaNhanRepository.save(gccn);
    }

    @Autowired
    public void setGhiChuCaNhanRepository(GhiChuCaNhanRepository ghiChuCaNhanRepository) {
        this.ghiChuCaNhanRepository = ghiChuCaNhanRepository;
    }
}
