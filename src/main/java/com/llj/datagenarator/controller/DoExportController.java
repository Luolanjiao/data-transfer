package com.llj.datagenarator.controller;

import com.llj.datagenarator.service.implement.DatDataExportImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author lanjiao.luo
 * @date 2019/5/13 11:41
 **/
@RestController
@RequestMapping("/dat")
public class DoExportController {
    @Autowired
    private DatDataExportImpl dataExport;

    @Value("${datasourse.path}")
    private String dataSoursePath;

    @RequestMapping("/export")
    public String doExport() throws IOException {
        //遍历sql文件，对每个文件分别生成一个dat和一个ok文件
        File folder=new File(dataSoursePath.trim());
        if(folder.isDirectory()){
            for (File file:
            folder.listFiles()) {
                dataExport.export(file);
            }
        }
        return "ok";
    }
}
