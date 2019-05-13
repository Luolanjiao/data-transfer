package com.llj.datagenarator.service.implement;

import com.llj.datagenarator.service.DataExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * @author lanjiao.luo
 * @date 2019/5/13 16:13
 **/
@Component
public class DatDataExportImpl implements DataExport {

    @Autowired
    private MSSQLFileContentFormaterImpl mssqlFileContentFormater;

    @Override
    public void export(File file) throws IOException {
        String formatContent= mssqlFileContentFormater.formate(file);
        String path = this.getClass().getResource("/dat").getPath();
        String tableName = file.getName().substring(0, file.getName().indexOf("."));
        String nowdate=new SimpleDateFormat("yyyyMMdd").format(new java.util.Date());;
        File targetFile = new File(path + "/efs_" + tableName + "_f."+ nowdate+".dat");
        if (targetFile.exists()) {
            targetFile.delete();
        }
        targetFile.createNewFile();
        File targetFile_ok = new File(path + "/efs_" + tableName + "_f."+nowdate+".ok");
        if (targetFile_ok.exists()) {
            targetFile_ok.delete();
        }
        targetFile_ok.createNewFile();
        FileWriter fileWriter = new FileWriter(targetFile);
        System.out.println(formatContent);
        fileWriter.write(formatContent);
        FileWriter fileWriter_ok = new FileWriter(targetFile_ok);
        fileWriter_ok.write("efs_" + tableName + "=" + mssqlFileContentFormater.getRecordCount(formatContent));
        fileWriter.close();
        fileWriter_ok.close();
    }
}
