package org.example.quanlycongviec.controller;

import org.example.quanlycongviec.service.GhiChuCaNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GhiChuMatKhauController {
    private GhiChuCaNhanService ghiChuCaNhanService;

    @Autowired
    public void setGhiChuCaNhanService(GhiChuCaNhanService ghiChuCaNhanService) {
        this.ghiChuCaNhanService = ghiChuCaNhanService;
    }
}
