package com.bootdo.utils.baidu.face;

/**
 * @program: spring-cloud
 * @description:
 * @author: yaoyao_cmrpd
 * @create: 2018-08-07 23:50
 **/



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bootdo.utils.File.BaiduFile;
import com.bootdo.utils.baidu.GsonUtils;
import com.bootdo.utils.baidu.HttpUtil;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 人脸注册
 */
public class FaceControl {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
    private static final String accessToken = "24.112838fd0458ba6279aba73449573865.2592000.1536248258.282335-11645866";
    public static String add() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("image", "027d8308a2ec665acb1bdf63e513bcb9");
            map.put("group_id", "group_repeat");
            map.put("user_id", "user1");
            map.put("user_info", "abc");
            map.put("liveness_control", "NORMAL");
            map.put("image_type", "FACE_TOKEN");
            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);



            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Map<String, String> addCustFace(MultipartFile file,String userId) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
            Map<String, String> map = new HashMap<>();
//            String a = BaiduFile.getImageStr("D:\\data\\pic\\DSC_1359.jpg");
//            System.out.println(a);
            String a = BaiduFile.getCustImageStr(file);
            map.put("image",a);
            map.put("group_id", "yunke");
            map.put("user_id", userId);
            map.put("user_info", userId);
            map.put("liveness_control", "NORMAL");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            //String accessToken = "24.77ceb14917f12c1de52ff5567c104cce.2592000.1536652173.282335-11645866";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            JSONObject resultJson  = JSON.parseObject(result);
            if(resultJson==null){
                return null;
            }
            String code = String.valueOf(resultJson.get("error_code"));
            String msg = String.valueOf(resultJson.get("error_msg"));
            Map<String,String> resultMap = new HashMap<>();
            resultMap.put("code",code);
            resultMap.put("msg",msg);
            if("0".equals(code)){
                String log_id = resultJson.getString("log_id");
                JSONObject results = resultJson.getJSONObject("result");
                String face_token = results.getString("face_token");
                resultMap.put("log_id",log_id);
                resultMap.put("face_token",face_token);
            }
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String remove(String userId,String faceToken) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/face/delete";
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("user_id", userId);
            map.put("group_id", "yunke");
            map.put("face_token", faceToken);

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            //String accessToken = "[调用鉴权接口获取的token]";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        FaceControl.add();
    }
}