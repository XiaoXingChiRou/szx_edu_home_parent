package com.szx.controller;

import com.szx.pojo.Course;
import com.szx.pojo.CourseVO;
import com.szx.pojo.ResponseResult;
import com.szx.service.CourseService;
import com.szx.utils.UploadPictureUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //多条件课程查询
    @RequestMapping("/findCourseByCondition")
    public ResponseResult findCourseByCondition(@RequestBody CourseVO courseVO){
        //获取业务传递数据
        List<Course> list = courseService.findCourseByCondition(courseVO);
        //封装数据给前端返回
        ResponseResult responseResult = new ResponseResult(true,200,"响应成功",list);
        return responseResult;
    }

    //课程图片上传
    @RequestMapping("/courseUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        //调用托片上传方法
        Map<String, String> map = UploadPictureUtils.fileUpload(file, request);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", map);
        return responseResult;
    }

    //新增&修改课程及讲师信息
    @RequestMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVO courseVO){
        //判断是新增还是修改信息
        if (courseVO.getId() == null){
            //新增信息
            courseService.saveCourseOrTeacher(courseVO);
            //封装响应数据
            ResponseResult responseResult = new ResponseResult(true, 200, "新增成功", null);
            return responseResult;
        } else {
            //修改信息
            courseService.updateCourseOrTeacher(courseVO);
            //封装响应数据
            ResponseResult responseResult = new ResponseResult(true, 200, "修改成功", null);
            return responseResult;
        }
    }

    //根据课程id，查询课程信息及讲师信息
    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(Integer id){
        CourseVO courseVO = courseService.findCourseById(id);
        //封装响应数据
        ResponseResult responseResult = new ResponseResult(true, 200, "根据ID查询信息成功", courseVO);
        return responseResult;
    }

    //根据课程id需修改课程状态
    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(@RequestParam int id,@RequestParam int status){
        courseService.updateCourseStatus(id,status);
        HashMap<String, Object> map = new HashMap<>();
        map.put("status",status);
        ResponseResult responseResult = new ResponseResult(true,200,"响应成功",map);
        return responseResult;
    }

}
