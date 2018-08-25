package com.bootdo.utils.sequnce.impl;

import com.bootdo.utils.sequnce.IdGeneratorConfig;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-08-24 22:42
 **/
public class DefaultIdGeneratorConfig implements IdGeneratorConfig {

    @Override
    public String getSplitString() {
        return "";
    }

    @Override
    public int getInitial() {
        return 1;
    }

    @Override
    public String getPrefix() {
        return "";
    }

    @Override
    public int getRollingInterval() {
        return 1;
    }

}
