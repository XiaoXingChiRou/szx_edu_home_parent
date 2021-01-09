package com.szx.service.impl;

import com.szx.dao.CourseMapper;
import com.szx.pojo.Course;
import com.szx.pojo.CourseVO;
import com.szx.pojo.Teacher;
import com.szx.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    //多条件课程查询
    @Override
    public List<Course> findCourseByCondition(CourseVO courseVO) {
        return courseMapper.findCourseByCondition(courseVO);
    }

    //添加课程及讲师信息
    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) {
        //封装课程信息
        Course course = new Course();
        try {
            //利用jdk自带方法封装实体类
            BeanUtils.copyProperties(course,courseVO);
            //补全课程信息
            Date date = new Date();
            //创建时间
            course.setCreateTime(date);
            //修改时间
            course.setUpdateTime(date);
            System.out.println("CourseServiceImpl.saveCourseOrTeacher.course：" + course);
            //保存课程
            courseMapper.saveCourse(course);
            //获取课程心插入数据的ID值
            int courseId = course.getId();
            //封装teacher实体
            Teacher teacher = new Teacher();
            //利用jdk自带方法封装实体类
            BeanUtils.copyProperties(teacher,courseVO);
            //补全讲师信息
            //创建时间
            teacher.setCreateTime(date);
            //修改时间
            teacher.setUpdateTime(date);
            //讲师状态
            teacher.setIsDel(0);
            //课程id
            teacher.setCourseId(courseId);
            System.out.println("CourseServiceImpl.saveCourseOrTeacher.teacher：" + teacher);
            //保存讲师信息
            courseMapper.saveTeacher(teacher);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //根据课程id，查询课程信息及讲师信息
    @Override
    public CourseVO findCourseById(Integer id) {
        return courseMapper.findCourseById(id);
    }

    //修改课程信息及讲师信息，根据课程id修改
    @Override
    public void updateCourseOrTeacher(CourseVO courseVO) {
        //封装课程信息
        Course course = new Course();
        try {
            //利用jdk自带方法封装实体类
            BeanUtils.copyProperties(course,courseVO);
            //补全参数
            Date date = new Date();
            //更新时间
            course.setUpdateTime(date);
            //修改课程信息
            System.out.println("CourseServiceImpl.updateCourseOrTeacher.course：" + course);
            courseMapper.updateCourse(course);
            //封装teacher实体
            Teacher teacher = new Teacher();
            //利用jdk自带方法封装实体类
            BeanUtils.copyProperties(teacher,courseVO);
            //补全信息
            //跟新时间
            teacher.setUpdateTime(date);
            //课程id
            teacher.setCourseId(course.getId());
            //修改讲师信息
            System.out.println("CourseServiceImpl.updateCourseOrTeacher.teacher：" + teacher);
            courseMapper.updateTeacher(teacher);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //根据课程id修改课程状态
    @Override
    public void updateCourseStatus(int courseId,int status) {
        //补全修改时间
        Course course = new Course();
        course.setId(courseId);
        course.setStatus(status);
        course.setUpdateTime(new Date());
        courseMapper.updateCourseStatus(course);
    }


}
