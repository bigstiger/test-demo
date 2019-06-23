package com.stiger.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stiger.exportExcel.ExportExcelDao;
import com.stiger.exportExcel.Student;
import com.stiger.service.ExportExcelService;
import org.jxls.template.SimpleExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther: zheng.yuan
 * @Date: 2019/6/22 16:21
 * @Description:
 */
@Service
public class ExportExcelServiceImpl extends ServiceImpl<ExportExcelDao, Student> implements ExportExcelService {

    @Autowired
    private ExportExcelDao exportExcelDao;

    @Override
    public void exportByIds(List<Integer> ids, HttpServletResponse response) {
        if (ids.isEmpty()){
            return;
        }
        List<Student> students = exportExcelDao.selectBatchIds(ids);
        //表头信息,字段
        List<String> excelHeader = new ArrayList<>();
        //内容
        List<List<String>> excelLoad = new ArrayList<>();

        //set load
        //List<List<Student>> collect = new ArrayList<List<Student>>((Collection<? extends List<Student>>) students);

        students.sort(Comparator.comparingInt(Student::getId));
        ArrayList<String> loads = new ArrayList<>();
        students.forEach(y -> {
            loads.add(y.getName());
        });
        excelLoad.add(loads);


        //set header
        if(students.size() > 0) {
            //List<> newAllChartExport = (List<NewAllChartExport>)groupBySegmentId.values().toArray()[0];
            students.sort(Comparator.comparingInt(Student::getId));
            students.forEach(x -> {
                excelHeader.add(x.getCity());
            });
        }

        //construct excel
        try {
            response.addHeader("Content-disposition", "attachment; filename=" + ids + ".xls");
            response.setContentType("application/vnd.ms-excel");
            new SimpleExporter().gridExport(excelHeader, excelLoad, "", response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
