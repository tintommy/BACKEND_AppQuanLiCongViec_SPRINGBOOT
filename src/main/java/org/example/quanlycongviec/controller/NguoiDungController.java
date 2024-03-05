package org.example.quanlycongviec.controller;

import lombok.AllArgsConstructor;
import org.example.quanlycongviec.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class NguoiDungController {
    private NguoiDungService nguoiDungService;

}
