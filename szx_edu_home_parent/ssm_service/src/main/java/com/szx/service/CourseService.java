package com.szx.service;

import com.szx.pojo.Course;
import com.szx.pojo.CourseVO;
import com.szx.pojo.Teacher;

import java.util.List;

public interface CourseService {

    //多条件课程查询
    public List<Course> findCourseByCondition(CourseVO courseVO);

    //添加课程及讲师信息
    public void saveCourseOrTeacher(CourseVO courseVO);

    //根据课程id，查询课程信息及讲师信息
    public CourseVO findCourseById(Integer id);

    //修改课程信息及讲师信息，根据课程id修改
    public void updateCourseOrTeacher(CourseVO courseVO);

    //根据课程id修改课程状态
    public void updateCourseStatus(int courseId,int status);

}
