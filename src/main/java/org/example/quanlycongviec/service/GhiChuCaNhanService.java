package org.example.quanlycongviec.service;

import org.example.quanlycongviec.entity.GhiChuCaNhan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GhiChuCaNhanService {
    GhiChuCaNhan save(GhiChuCaNhan ghiChuCaNhan);
    List<GhiChuCaNhan> timDanhSachGhiChuTheoMaNguoiDung(int maNd);
    Void xoaTheoMa(int maGhiChu);
    GhiChuCaNhan taoHoacSuaGhiChu(GhiChuCaNhan gccn, String email);
}
