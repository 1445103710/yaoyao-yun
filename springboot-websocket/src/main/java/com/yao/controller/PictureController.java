package com.yao.controller;

import com.yao.utils.ImgUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-08-26 00:38
 **/
@Controller
@RequestMapping("/pic")
public class PictureController {
    /**
     * 根据图片的地址，来获取图片
     * @param addr
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/getImg" ,method = RequestMethod.GET)
    public void getImg(@RequestParam("addr")String addr, HttpServletResponse response){
        BufferedImage img = new BufferedImage(300, 150, BufferedImage.TYPE_INT_RGB);
        System.out.println("文件名"+addr);
        img = ImgUtil.getInputStream(addr);
        if(img==null){
            throw new RuntimeException("打印图片异常：com.controller.Business_Ctrl.getImg(String, HttpServletResponse)");
        }
        if(img!=null){
            try {
                ImageIO.write(img, "JPEG", response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("打印异常:com.controller.Business_Ctrl.getImg(String, HttpServletResponse)");
            }
        }
    }

}
