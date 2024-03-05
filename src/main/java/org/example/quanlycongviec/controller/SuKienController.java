package org.example.quanlycongviec.controller;

import lombok.AllArgsConstructor;
import org.example.quanlycongviec.service.SuKienService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SuKienController {
    private SuKienService suKienService;
}
