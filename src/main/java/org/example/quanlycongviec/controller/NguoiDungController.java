package org.example.quanlycongviec.controller;

import org.example.quanlycongviec.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NguoiDungController {
    private NguoiDungService nguoiDungService;

    @Autowired
    public void setNguoiDungService(NguoiDungService nguoiDungService) {
        this.nguoiDungService = nguoiDungService;
    }
}
