package org.example.quanlycongviec.service;

import org.example.quanlycongviec.entity.NguoiDung;

public interface NguoiDungService {
    NguoiDung save(NguoiDung nguoiDung);
    NguoiDung findUserByEmail(String email);
}
