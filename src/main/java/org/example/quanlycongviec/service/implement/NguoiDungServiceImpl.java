package org.example.quanlycongviec.service.implement;

import org.example.quanlycongviec.entity.NguoiDung;
import org.example.quanlycongviec.repository.NguoiDungRepository;
import org.example.quanlycongviec.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {

    private NguoiDungRepository nguoiDungRepository;
    @Override
    public NguoiDung save(NguoiDung nguoiDung) {
        return nguoiDungRepository.save(nguoiDung);
    }

    @Autowired
    public void setNguoiDungRepository(NguoiDungRepository nguoiDungRepository) {
        this.nguoiDungRepository = nguoiDungRepository;
    }
}
