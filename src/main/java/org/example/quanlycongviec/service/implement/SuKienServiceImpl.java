package org.example.quanlycongviec.service.implement;

import org.example.quanlycongviec.entity.SuKien;
import org.example.quanlycongviec.repository.SuKienRepository;
import org.example.quanlycongviec.service.SuKienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuKienServiceImpl implements SuKienService {

    private SuKienRepository suKienRepository;
    @Override
    public SuKien save(SuKien suKien) {
        return suKienRepository.save(suKien);
    }
    @Autowired
    public void setSuKienRepository(SuKienRepository suKienRepository) {
        this.suKienRepository = suKienRepository;
    }
}
