package com.stiger.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stiger.exportExcel.Student;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletResponse;
import java.util.List;

//@Service
public interface ExportExcelService extends IService<Student> {
    void exportByIds(List<Integer> ids, HttpServletResponse response);
}
