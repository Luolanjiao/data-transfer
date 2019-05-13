package com.llj.datagenarator.model;

import org.springframework.beans.factory.annotation.Value;

import java.util.TreeMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author lanjiao.luo
 * @date 2019/5/10 17:19
 **/
public class FormaterSetting {
   @Value("${dataformat.record.count}")
    private int RecordCount;
    @Value("${dataformat.column.separate}")
    private String ColumnSeparate;
   @Value("${dataformat.record.separate}")
    private String RecordSeparate;

    public int getRecordCount() {
        return RecordCount;
    }

    public void setRecordCount(int recordCount) {
        RecordCount = recordCount;
    }
    public FormaterSetting(){
      /* RecordCount = 5;
        ColumnSeparate = "\u0001";
        RecordSeparate = "\n";*/
        this.replaceDic = new TreeMap<String,String>();
        this.outFileSuffix = outFileSuffix;
    }
    public FormaterSetting(int recordCount, String columnSeparate, String recordSeparate, TreeMap<String, String> replaceDic, String outFileFuffix) {
        RecordCount = recordCount;
        ColumnSeparate = columnSeparate;
        RecordSeparate = recordSeparate;
        //this.replaceDic = replaceDic;
        this.outFileSuffix = outFileSuffix;
    }

    public String getColumnSeparate() {
        return ColumnSeparate;
    }

    public void setColumnSeparate(String columnSeparate) {
        ColumnSeparate = columnSeparate;
    }

    public String getRecordSeparate() {
        return RecordSeparate;
    }

    public void setRecordSeparate(String recordSeparate) {
        RecordSeparate = recordSeparate;
    }

    public TreeMap<String, String> getReplaceDic() {
        return replaceDic;
    }

    public void setReplaceDic(TreeMap<String, String> replaceDic) {
        this.replaceDic = replaceDic;
    }

    public String getOutFileSuffix() {
        return outFileSuffix;
    }

    public void setOutFileSuffix(String outFileSuffix) {
        this.outFileSuffix = outFileSuffix;
    }

    private TreeMap<String, String> replaceDic;
    private String outFileSuffix;
}
