package org.example.quanlycongviec.service.implement;

import org.example.quanlycongviec.entity.GhiChuCaNhan;
import org.example.quanlycongviec.repository.GhiChuCaNhanRepository;
import org.example.quanlycongviec.service.GhiChuCaNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GhiChuCaNhanServiceImpl implements GhiChuCaNhanService {

    private GhiChuCaNhanRepository ghiChuCaNhanRepository;
    @Override
    public GhiChuCaNhan save(GhiChuCaNhan ghiChuCaNhan) {
        return ghiChuCaNhanRepository.save(ghiChuCaNhan);
    }

    @Autowired
    public void setGhiChuCaNhanRepository(GhiChuCaNhanRepository ghiChuCaNhanRepository) {
        this.ghiChuCaNhanRepository = ghiChuCaNhanRepository;
    }
}
