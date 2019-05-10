package com.llj.datagenarator.service;

import java.util.List;

/**
 * @author lanjiao.luo
 * @date 2019/5/10 16:55
 *
 **/
public interface DataFormater {
    <T>String formate(List<T> aa);
}
