package com.llj.datagenarator.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * @author lanjiao.luo
 * @date 2019/5/10 16:51
 **/
@Service
public interface DataExport {
   // void export(File file, String outFilePath) throws IOException;
    void export(File file) throws IOException;
}
