package org.example.quanlycongviec.service.implement;

import org.example.quanlycongviec.entity.GhiChuMatKhau;
import org.example.quanlycongviec.repository.GhiChuMatKhauRepository;
import org.example.quanlycongviec.service.GhiChuMatKhauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GhiChuMatKhauServiceImpl implements GhiChuMatKhauService {

    private GhiChuMatKhauRepository ghiChuMatKhauRepository;
    @Override
    public GhiChuMatKhau save(GhiChuMatKhau ghiChuMatKhau) {
        return ghiChuMatKhauRepository.save(ghiChuMatKhau);
    }

    @Autowired
    public void setGhiChuMatKhauRepository(GhiChuMatKhauRepository ghiChuMatKhauRepository) {
        this.ghiChuMatKhauRepository = ghiChuMatKhauRepository;
    }
}
