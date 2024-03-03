package org.example.quanlycongviec.service;

import org.example.quanlycongviec.entity.GhiChuCaNhan;
import org.springframework.stereotype.Service;

@Service
public interface GhiChuCaNhanService {
    GhiChuCaNhan save(GhiChuCaNhan ghiChuCaNhan);
}
