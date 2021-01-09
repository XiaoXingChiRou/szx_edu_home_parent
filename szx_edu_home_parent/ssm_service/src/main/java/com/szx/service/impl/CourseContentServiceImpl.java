package com.szx.service.impl;

import com.szx.dao.CourseContentMapper;
import com.szx.pojo.Course;
import com.szx.pojo.CourseSection;
import com.szx.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("courseContentService")
public class CourseContentServiceImpl implements CourseContentService {

    @Autowired
    private CourseContentMapper courseContentMapper;

    //根据课程ID查询关联的章节信息及关联的课时信息
    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId) {
        return courseContentMapper.findSectionAndLessonByCourseId(courseId);
    }

    //查询课程信息，根据课程Id
    @Override
    public Course findCourseByCourseId(Integer courseId) {
        return courseContentMapper.findCourseByCourseId(courseId);
    }

    //新建章节信息
    @Override
    public void saveSection(CourseSection courseSection) {
        //补全信息
        Date date = new Date();
        //新增时间
        courseSection.setCreateTime(date);
        //修改时间
        courseSection.setUpdateTime(date);
        courseContentMapper.saveSection(courseSection);
    }

    //修改章节信息，根据Id
    @Override
    public void updateSection(CourseSection courseSection) {
        //补全信息
        courseSection.setUpdateTime(new Date());
        courseContentMapper.updateSection(courseSection);
    }

    //修改章节状态
    @Override
    public void updateSectionStatus(Integer id, Integer status) {
        //封装修改信息
        CourseSection courseSection = new CourseSection();
        courseSection.setId(id);
        courseSection.setStatus(status);
        courseSection.setUpdateTime(new Date());
        courseContentMapper.updateSectionStatus(courseSection);
    }


}
