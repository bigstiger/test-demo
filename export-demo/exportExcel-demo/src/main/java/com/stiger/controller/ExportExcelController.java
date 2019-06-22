package com.stiger.controller;

import com.stiger.service.ExportExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
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
    public void exportByIds(@RequestParam List<Integer> ids, HttpServletResponse response){
        exportExcelService.exportByIds(ids, response);
    }
}
