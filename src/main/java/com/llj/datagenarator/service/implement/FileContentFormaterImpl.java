package com.llj.datagenarator.service.implement;

import com.llj.datagenarator.model.FormaterSetting;
import com.llj.datagenarator.service.FileContentFormater;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lanjiao.luo
 * @date 2019/5/10 17:37
 **/
public class FileContentFormaterImpl implements FileContentFormater {

    @Autowired
    private FormaterSetting formaterSetting;

    @Override
    public File formate(File sqlFile) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(sqlFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        int i = 0;
        StringBuffer targetStrBuffer = new StringBuffer();
        while (i <= 9) {
            if (reader.readLine() == "GO") {
                continue;
            }
            targetStrBuffer.append(reader.readLine());
            i++;
        }
        //去掉符号
        //1.去掉INSERT INTO [F_Investment_Order]
        //2.去掉括号
        //3.去掉'
        //4.逗号, 换成间隔符
//替换
      String  targetStr = targetStrBuffer.toString();
        for (Map.Entry<String,String> setting:
        formaterSetting.getReplaceDic().entrySet()) {
            targetStr.replaceAll(setting.getKey(),setting.getValue());
        }
        return null;
    }
}
