package com.llj.datagenarator.config;

import com.llj.datagenarator.model.FormaterSetting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lanjiao.luo
 * @date 2019/5/13 11:50
 **/
@Configuration
public class FormatConfig {
    @Bean
    public FormaterSetting getFormaterSetting(){
        return new FormaterSetting();
    }
}
