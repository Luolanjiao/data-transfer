package com.llj.datagenarator.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lanjiao.luo
 * @date 2019/5/10 17:19
 **/
public class FormaterSetting {
    private int RecordCount;
    private String ColumnSeparate;
    private String RecordSeparate;

    public int getRecordCount() {
        return RecordCount;
    }

    public void setRecordCount(int recordCount) {
        RecordCount = recordCount;
    }
    public FormaterSetting(){
        RecordCount = 5;
        ColumnSeparate = "Ox01";
        RecordSeparate = "\n";
        this.replaceDic = new HashMap<String,String>();
       // this.replaceDic.put("","");
        this.outFileFuffix = outFileFuffix;
    }
    public FormaterSetting(int recordCount, String columnSeparate, String recordSeparate, HashMap<String, String> replaceDic, String outFileFuffix) {
        RecordCount = recordCount;
        ColumnSeparate = columnSeparate;
        RecordSeparate = recordSeparate;
        //this.replaceDic = replaceDic;
        this.outFileFuffix = outFileFuffix;
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

    public HashMap<String, String> getReplaceDic() {
        return replaceDic;
    }

    public void setReplaceDic(HashMap<String, String> replaceDic) {
        this.replaceDic = replaceDic;
    }

    public String getOutFileFuffix() {
        return outFileFuffix;
    }

    public void setOutFileFuffix(String outFileFuffix) {
        this.outFileFuffix = outFileFuffix;
    }

    private HashMap<String, String> replaceDic;
    private String outFileFuffix;
}
