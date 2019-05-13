package com.llj.datagenarator.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * @author lanjiao.luo
 * @date 2019/5/10 17:02
 * 文件内容转换
 **/
@Service
public interface FileContentFormater {
    String formate (File sqlFile) throws IOException;
   // File formate (File sqlFile, int RecordCount, String ColumnSeparate, String RecordSeparate, Map<String,String> replaceDic,String outFileFuffix);
}
