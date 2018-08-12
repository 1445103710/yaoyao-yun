package com.yao.framework.web.service;

import com.yao.project.system.config.service.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * yao首创 html调用 thymeleaf 实现参数管理
 * 
 * @author yao
 */
@Service("config")
public class ConfigService
{
    @Autowired
    private IConfigService configService;

    /**
     * 根据键名查询参数配置信息
     * 
     * @param configName 参数名称
     * @return 参数键值
     */
    public String getKey(String configKey)
    {
        return configService.selectConfigByKey(configKey);
    }

}
