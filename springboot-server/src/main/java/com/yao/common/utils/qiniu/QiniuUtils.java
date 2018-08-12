package com.yao.common.utils.qiniu;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-08-11 21:44
 **/
public class QiniuUtils {

    public static final String accessKey = "r8YtNQ4cuhx9VE7qDM7wbuLtJYTLsifcSO351Zs-";
    public static final String secretKey = "4M6XlPV4Mofgs5mmCwoVYWLSjrxw0cM9auL0WvHb";
    public static final String bucket = "yun-cloud";

    public static void putFile(){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //如果是Windows情况下，格式是 D:\\qiniu\\test.png
        String localFilePath = "F:\\data\\qiniu\\profile.jpg";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }
    public static void main(String[] args){
        putFile();
    }
}
