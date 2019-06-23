package com.stiger.controller;

import com.stiger.service.ExportExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zheng.yuan
 * @Date: 2019/6/22 16:12
 * @Description:
 */
@RestController
@RequestMapping("/api/v1/exportExcel/")
public class ExportExcelController {

    private static Logger logger = LoggerFactory.getLogger(ExportExcelController.class);


    @Autowired
    private ExportExcelService exportExcelService;

    @PostMapping("exportByIds")
    public void exportByIds(@RequestParam String id, HttpServletResponse response){
        List<Integer> ids = new ArrayList<>();
        ids.add(Integer.valueOf(id));
        exportExcelService.exportByIds(ids, response);
    }
}
