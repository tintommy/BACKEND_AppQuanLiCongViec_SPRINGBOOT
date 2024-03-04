package org.example.quanlycongviec.service.implement;

import org.example.quanlycongviec.entity.CongViec;
import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.repository.CongViecRepository;
import org.example.quanlycongviec.service.CongViecNgayService;
import org.example.quanlycongviec.service.CongViecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongViecServiceImpl implements CongViecService {

    private CongViecRepository congViecRepository;

    @Autowired
    public void setCongViecRepository(CongViecRepository congViecRepository) {
        this.congViecRepository = congViecRepository;
    }


    @Override
    public CongViec save(CongViec congViec) {
        return congViecRepository.save(congViec);
    }
}
