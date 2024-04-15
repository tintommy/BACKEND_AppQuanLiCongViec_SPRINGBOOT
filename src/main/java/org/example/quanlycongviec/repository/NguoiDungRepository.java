package org.example.quanlycongviec.repository;

import org.example.quanlycongviec.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {
    NguoiDung findByEmail(String email);
}
