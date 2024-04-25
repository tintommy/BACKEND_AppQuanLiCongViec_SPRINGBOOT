package org.example.quanlycongviec.service;

import org.example.quanlycongviec.entity.NguoiDung;

public interface NguoiDungService {
    NguoiDung save(NguoiDung nguoiDung);
    NguoiDung findUserByEmail(String email);
    NguoiDung saveMaPin(String email,String pin);

    Boolean checkMaPin(String email, String pin);
    Boolean DoiMaPin(String email,String pass, String pin);

}
