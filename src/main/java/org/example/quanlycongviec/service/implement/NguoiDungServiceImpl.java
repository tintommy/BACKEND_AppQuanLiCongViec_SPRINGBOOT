package org.example.quanlycongviec.service.implement;

import org.example.quanlycongviec.entity.NguoiDung;
import org.example.quanlycongviec.repository.NguoiDungRepository;
import org.example.quanlycongviec.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {

    private NguoiDungRepository nguoiDungRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public NguoiDung save(NguoiDung nguoiDung) {
        return nguoiDungRepository.save(nguoiDung);
    }

    @Override
    public NguoiDung findUserByEmail(String email) {
        return nguoiDungRepository.findByEmail(email);
    }

    @Override
    public NguoiDung saveMaPin(String email, String pin) {
        NguoiDung nd= nguoiDungRepository.findByEmail(email);
        nd.setMaPin(passwordEncoder.encode(pin));
        return nguoiDungRepository.save(nd);
    }

    @Override
    public Boolean checkMaPin(String email, String pin) {
        NguoiDung nd= nguoiDungRepository.findByEmail(email);
        return passwordEncoder.matches(pin,nd.getMaPin());
    }

    @Override
    public Boolean DoiMaPin(String email, String pass, String pin) {
        NguoiDung nd = nguoiDungRepository.findByEmail(email);
        if(!passwordEncoder.matches(pass,nd.getMatKhau()))
            return false;

        nd.setMaPin(passwordEncoder.encode(pin));
        nguoiDungRepository.save(nd);
        return true;
    }

    @Autowired
    public void setNguoiDungRepository(NguoiDungRepository nguoiDungRepository) {
        this.nguoiDungRepository = nguoiDungRepository;
    }
}
