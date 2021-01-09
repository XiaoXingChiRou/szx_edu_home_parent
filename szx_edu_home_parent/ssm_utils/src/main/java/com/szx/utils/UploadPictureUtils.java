package com.szx.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片上传工具类
 */
public class UploadPictureUtils {

    public static Map<String, String> fileUpload(MultipartFile file, HttpServletRequest request){
        //判断上传文件是否为空
        if (file.isEmpty()){
            throw  new RuntimeException();
        }
        //获取项目部署路径
        String realPath = request.getServletContext().getRealPath("/");
        //截取目录
        String substring = realPath.substring(0, realPath.indexOf("ssm_web"));
        //获取原始文件名
        String originalFilename = file.getOriginalFilename();
        //生成存储文件名
        //当前时间戳 + 原始文件名后缀
        String newFileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.indexOf("."));
        //文件上传
        //文件存储路径
        String uploadPath = substring + "upload\\";
        File filePath = new File(uploadPath, newFileName);
        //判断目录是否存在
        if (!filePath.getParentFile().exists()){
            //文件目录不存在则创建
            filePath.getParentFile().mkdirs();
            System.out.println("创建文件存储目录：" + filePath);
        }
        try {
            //图片真正上传
            file.transferTo(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //响应文件名及路径给前端
        Map<String, String> map = new HashMap<>();
        map.put("fileName",newFileName);
        map.put("filePath","http://localhost:8080/upload/" + newFileName);
        return map;
    }

}
