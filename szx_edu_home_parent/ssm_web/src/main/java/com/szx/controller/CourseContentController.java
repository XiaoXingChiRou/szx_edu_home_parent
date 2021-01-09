package com.szx.controller;

import com.szx.pojo.Course;
import com.szx.pojo.CourseSection;
import com.szx.pojo.ResponseResult;
import com.szx.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;

    //根据课程ID查询关联的章节信息及关联的课时信息
    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLesson(@RequestParam Integer courseId) {
        List<CourseSection> list = courseContentService.findSectionAndLessonByCourseId(courseId);
        //封装返回信息
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", list);
        return responseResult;
    }

    //查询课程信息，根据课程Id
    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(@RequestParam Integer courseId){
        Course course = courseContentService.findCourseByCourseId(courseId);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", course);
        return responseResult;
    }

    //新建&修改章节信息
    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection courseSection) {
        //判断是修改还是新增
        if (courseSection.getId() == null){
            //新增章节信息
            courseContentService.saveSection(courseSection);
            //封装返回信息
            ResponseResult responseResult = new ResponseResult(true, 200, "新增成功", null);
            return responseResult;
        } else {
            //修改章节信息
            courseContentService.updateSection(courseSection);
            //封装返回信息
            ResponseResult responseResult = new ResponseResult(true, 200, "修改成功", null);
            return responseResult;
        }
    }

    //修改章节状态
    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(@RequestParam Integer id,@RequestParam Integer status){
        courseContentService.updateSectionStatus(id, status);
        //封装返回信息
        HashMap<Object, Object> map = new HashMap<>();
        map.put("status",status);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", map);
        return responseResult;
    }

}
