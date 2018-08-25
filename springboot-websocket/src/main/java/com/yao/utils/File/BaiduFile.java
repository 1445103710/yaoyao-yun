package com.yao.utils.File;

import com.yao.utils.baidu.Base64Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-08-12 15:04
 **/
@Slf4j
public class BaiduFile {
    public static File[] getFiles(){
        String path = "D://data//pic";
        File file = new File(path);
        File[] tempList = file.listFiles();
        System.out.println("该目录下对象个数："+tempList.length);
        for(int i = 0;i<tempList.length;i++)
        {
            if (tempList[i].isFile()) {
                System.out.println("文     件：" + tempList[i]);
                System.out.println(tempList[i].toString());
            }
            if (tempList[i].isDirectory()) {
                System.out.println("文件夹：" + tempList[i]);
            }
        }
        return tempList;
    }
    public static List<String> getFileNames(File[] files){
        List<String> fileList = new ArrayList<>();
        for(int i = 0;i<files.length;i++)
        {
            if (files[i].isFile()) {
                fileList.add(files[i].toString());
            }
            if (files[i].isDirectory()) {

            }
        }
        return fileList;
    }
    /**
     * @Description: 根据图片地址转换为base64编码字符串
     * @Author:
     * @CreateTime:
     * @return
     */
    public static String getImageStr(String imgFile) {
        System.out.println("base64照片转码");
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        return Base64Util.encode(data);
    }
    public static String getImageStr(MultipartFile file) {
        System.out.println("base64照片转码");
        InputStream inputStream = null;
        byte[] data = null;
        try {
            data = file.getBytes();
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        return Base64Util.encode(data);
    }
    public static void main(String[] args){
        getFiles();
    }
}
