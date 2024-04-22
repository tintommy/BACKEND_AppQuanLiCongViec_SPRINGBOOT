package org.example.quanlycongviec.mapper;

import org.example.quanlycongviec.Request.CongViecRequest;
import org.example.quanlycongviec.entity.CongViec;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CongViecMapper {
    CongViecMapper INSTANCE = Mappers.getMapper(CongViecMapper.class);

    @Mapping(source = "nguoiDung.maNguoiDung", target = "maNd")
    CongViecRequest congViecToCongViecDto(CongViec congViec);

    List<CongViecRequest> congViecToCongViecDto(List<CongViec> congViecList);

    @Mapping(source = "maNd", target = "nguoiDung.maNguoiDung")
    CongViec congViecDtoToCongViec(CongViecRequest congViecDto);

}
