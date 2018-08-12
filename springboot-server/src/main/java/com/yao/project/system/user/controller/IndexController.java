package com.yao.project.system.user.controller;

import com.yao.framework.config.YaoConfig;
import com.yao.framework.web.controller.BaseController;
import com.yao.project.system.menu.domain.Menu;
import com.yao.project.system.menu.service.IMenuService;
import com.yao.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 首页 业务处理
 * 
 * @author yao
 */
@Controller
public class IndexController extends BaseController
{
    @Autowired
    private IMenuService menuService;

    @Autowired
    private YaoConfig YaoConfig;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        User user = getUser();
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUserId(user.getUserId());
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", YaoConfig.getCopyrightYear());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        mmap.put("version", YaoConfig.getVersion());
        return "main";
    }

}
