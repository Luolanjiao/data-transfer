package com.llj.datagenarator.service.implement;

import com.llj.datagenarator.model.FormaterSetting;
import com.llj.datagenarator.service.FileContentFormater;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lanjiao.luo
 * @date 2019/5/10 17:37
 **/
@Component
public class MSSQLFileContentFormaterImpl implements FileContentFormater {

    @Autowired
    private FormaterSetting formaterSetting;

    @Override
    public String formate(File sqlFile) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(sqlFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        int i = 0;
        StringBuffer targetStrBuffer = new StringBuffer();
        String record_str = null;
        while (i < formaterSetting.getRecordCount()) {
            record_str = reader.readLine();
            if( record_str == null){
                break;
            }
            if (record_str.equals("GO")) {
                continue;
            }
            targetStrBuffer.append(record_str);
            targetStrBuffer.append(formaterSetting.getRecordSeparate());
            i++;
        }
        String tableName = sqlFile.getName().substring(0, sqlFile.getName().indexOf("."));
        //去掉符号(空字符替换)
        //1.去掉INSERT INTO [F_Investment_Order]
        formaterSetting.getReplaceDic().put("INSERT INTO \\[" + tableName + "\\] VALUES ", "");
        //2.去掉括号
        //3.去掉'
        formaterSetting.getReplaceDic().put("[\\('(\\); )]", "");
        //替换
        formaterSetting.getReplaceDic().put("NULL", "’’");
        formaterSetting.getReplaceDic().put("[,]", formaterSetting.getColumnSeparate());
        String targetStr = targetStrBuffer.toString();
        for (Map.Entry<String, String> setting :
                formaterSetting.getReplaceDic().entrySet()) {
            targetStr = targetStr.replaceAll(setting.getKey(), setting.getValue());
        }
        reader.close();
        fileInputStream.close();
        return targetStr;
    }

    public int getRecordCount(String content){
        return content.split("\n").length;
    }

}
