package com.yao.utils.baidu.face;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-08-07 23:50
 **/

import com.yao.utils.File.BaiduFile;
import com.yao.utils.baidu.GsonUtils;
import com.yao.utils.baidu.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 人脸注册
 */
public class FaceAdd {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String add() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
            Map<String, String> map = new HashMap<>();
            String a = BaiduFile.getImageStr("D:\\data\\pic\\DSC_1359.jpg");
            System.out.println(a);
            map.put("image",a);
            map.put("group_id", "yunke");
            map.put("user_id", "user1");
            map.put("user_info", "姚尧|18|男|19940708");
            map.put("liveness_control", "NORMAL");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.77ceb14917f12c1de52ff5567c104cce.2592000.1536652173.282335-11645866";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        FaceAdd.add();
    }
}