package com.szx.dao;

import com.szx.pojo.Course;
import com.szx.pojo.CourseVO;
import com.szx.pojo.Teacher;

import java.util.List;

public interface CourseMapper {

    //多条件课程查询
    public List<Course> findCourseByCondition(CourseVO courseVO);

    //新增课程信息
    public void saveCourse(Course course);

    //新增讲师信息
    public void saveTeacher(Teacher teacher);

    //根据课程id，查询课程信息及讲师信息
    public CourseVO findCourseById(Integer id);

    //根据id修改课程信息
    public void updateCourse(Course course);

    //根据课程id更新讲师信息
    public void updateTeacher(Teacher teacher);

    //根据课程id修改课程状态
    public void updateCourseStatus(Course course);

}
