package org.example.quanlycongviec.service.implement;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.quanlycongviec.entity.CongViec;
import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.repository.CongViecNgayRepository;
import org.example.quanlycongviec.repository.CongViecRepository;
import org.example.quanlycongviec.response.NgayDaTaoResponse;
import org.example.quanlycongviec.service.CongViecNgayService;
import org.example.quanlycongviec.service.CongViecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CongViecServiceImpl implements CongViecService {

    private CongViecRepository congViecRepository;
    private CongViecNgayRepository congViecNgayRepository;



    @Override
    @Transactional
    public CongViec save(CongViec congViec) {
        CongViec newCongViec =congViecRepository.save(congViec);

        if(congViec.getMaCV() == 0) {
            return newCongViec;
        }

        // mot lan
        if (congViec.getChuKi().equals("0")) {
            CongViecNgay congViecNgay = new CongViecNgay();
            congViecNgay.setTrangThai(false);
            congViecNgay.setNgayLam(congViec.getNgayBatDau());
            congViecNgay.setCongViec(newCongViec);
            congViecNgayRepository.save(congViecNgay);
        }
        // hang ngay
        else if (congViec.getChuKi().equals("1")) {
            List<String> ngayLam = listDailyDates(congViec.getNgayBatDau(), congViec.getDungSauNgay());
            System.out.println(ngayLam);
            for(String item:ngayLam ){
                CongViecNgay congViecNgay = new CongViecNgay();
                congViecNgay.setTrangThai(false);
                congViecNgay.setNgayLam(item);
                congViecNgay.setCongViec(newCongViec);
                congViecNgayRepository.save(congViecNgay);
            }
        }
        // tu t2 den t6
        else if(congViec.getChuKi().equals("2")){
            List<String> ngayLam = listWeekdays(congViec.getNgayBatDau(), congViec.getDungSauNgay());
            for(String item:ngayLam ){
                CongViecNgay congViecNgay = new CongViecNgay();
                congViecNgay.setTrangThai(false);
                congViecNgay.setNgayLam(item);
                congViecNgay.setCongViec(newCongViec);
                congViecNgayRepository.save(congViecNgay);
            }
        }
        //hang tuan
        else if(congViec.getChuKi().equals("3")){
            List<String> ngayLam = listWeeklyDates(congViec.getNgayBatDau(), congViec.getDungSauNgay());
            for(String item:ngayLam ){
                CongViecNgay congViecNgay = new CongViecNgay();
                congViecNgay.setTrangThai(false);
                congViecNgay.setNgayLam(item);
                congViecNgay.setCongViec(newCongViec);
                congViecNgayRepository.save(congViecNgay);
            }
        }
        // hang thang
        else if(congViec.getChuKi().equals("4")){
            List<String> ngayLam = listMonthlyDates(congViec.getNgayBatDau(), congViec.getDungSauNgay());
            for(String item:ngayLam ){
                CongViecNgay congViecNgay = new CongViecNgay();
                congViecNgay.setTrangThai(false);
                congViecNgay.setNgayLam(item);
                congViecNgay.setCongViec(newCongViec);
                congViecNgayRepository.save(congViecNgay);
            }
        }
        // hang nam
        else {
            List<String> ngayLam = listAnnualDates(congViec.getNgayBatDau(), congViec.getDungSauNgay());
            for(String item:ngayLam ){
                CongViecNgay congViecNgay = new CongViecNgay();
                congViecNgay.setTrangThai(false);
                congViecNgay.setNgayLam(item);
                congViecNgay.setCongViec(newCongViec);
                congViecNgayRepository.save(congViecNgay);
            }
        }
        return newCongViec;
    }

    @Override
    @Transactional
    public long deleteCongViecTrongNgay(String ngaLam) {
        return congViecNgayRepository.deleteByNgayLam(ngaLam);
    }

    @Override
    public List<CongViecNgay> layTatCaCongViecTheoNgay(int maNd, String ngay) {
        return congViecNgayRepository.findByCongViec_NguoiDung_MaNguoiDungAndNgayLam(maNd,ngay);
    }

    @Override
    @Transactional
    public int deleteCongViecNgayById(int id) {
        return congViecNgayRepository.deleteByMaCvNgay(id);
    }

    @Override
    public CongViecNgay saveCongViecNgay(CongViecNgay congViecNgay) {
        return congViecNgayRepository.save(congViecNgay);
    }

    public List<NgayDaTaoResponse> danhSachNgay(int maNd) {
        List<CongViecNgay> items = congViecNgayRepository.findCongViecNgayByCongViec_NguoiDung_MaNguoiDung(maNd);
        Set<String> danhSachNgay = new LinkedHashSet<>();
        for (CongViecNgay item: items) {
            danhSachNgay.add(item.getNgayLam());
        }
        List<String> tempDanhSachNgay = new ArrayList<>(danhSachNgay);
        tempDanhSachNgay.sort(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        List<NgayDaTaoResponse> ngayDaTaoResponses = new ArrayList<>();
        for (String ngay:tempDanhSachNgay ) {
            int daLam = congViecNgayRepository.countByNgayLamAndTrangThaiAndCongViec_NguoiDung_MaNguoiDung(ngay,true,maNd);
            int chuaLam = congViecNgayRepository.countByNgayLamAndTrangThaiAndCongViec_NguoiDung_MaNguoiDung(ngay,false,maNd);
            double phanTram = (double) daLam /((double)chuaLam + (double)daLam);
            BigDecimal bd = new BigDecimal(phanTram).setScale(2, RoundingMode.HALF_UP);
            phanTram = bd.doubleValue() * 100;

            NgayDaTaoResponse response = new NgayDaTaoResponse();
            response.setNgay(ngay);
            response.setPhanTram(phanTram);
            response.setMaNd(maNd);
            ngayDaTaoResponses.add(response);
        }
        return ngayDaTaoResponses;
    }




    //Hang ngay
    private static List<String> listDailyDates(String startDateStr, String endDateStr) {
        List<String> dates = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);

            while (calendar.getTime().before(endDate) || calendar.getTime().equals(endDate)) {
                dates.add(sdf.format(calendar.getTime()));
                // Thêm 1 ngày để lấy ngày tiếp theo trong chu kỳ hàng ngày
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dates;
    }

    // tu thu 2 den thu 6
    public static List<String> listWeekdays(String startDateStr, String endDateStr) {
        List<String> dates = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);

            while (calendar.getTime().before(endDate) || calendar.getTime().equals(endDate)) {
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                // Kiểm tra nếu ngày hiện tại là từ thứ Hai đến thứ Sáu (2 đến 6)
                if (dayOfWeek >= Calendar.MONDAY && dayOfWeek <= Calendar.FRIDAY) {
                    dates.add(sdf.format(calendar.getTime()));
                }
                // Tăng ngày lên 1 để kiểm tra ngày tiếp theo
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dates;
    }

    //hang tuan
    private static List<String> listWeeklyDates(String startDateStr, String endDateStr) {
        List<String> dates = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);

            while (calendar.getTime().before(endDate) || calendar.getTime().equals(endDate)) {
                dates.add(sdf.format(calendar.getTime()));
                // Thêm 7 ngày để lấy ngày tiếp theo trong chu kỳ hàng tuần
                calendar.add(Calendar.DAY_OF_MONTH, 7);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dates;
    }



    // hang thang
    private static List<String> listMonthlyDates(String startDateStr, String endDateStr) {
        List<String> dates = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);

            while (calendar.getTime().before(endDate) || calendar.getTime().equals(endDate)) {
                dates.add(sdf.format(calendar.getTime()));
                // Thêm 1 tháng để lấy ngày tiếp theo trong chu kỳ hàng tháng
                calendar.add(Calendar.MONTH, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dates;
    }


    //hang nam
    private static List<String> listAnnualDates(String startDateStr, String endDateStr) {
        List<String> dates = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);

            while (calendar.getTime().before(endDate) || calendar.getTime().equals(endDate)) {
                dates.add(sdf.format(calendar.getTime()));
                // Thêm 1 năm để lấy ngày tiếp theo trong chu kỳ hàng năm
                calendar.add(Calendar.YEAR, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dates;
    }

}
