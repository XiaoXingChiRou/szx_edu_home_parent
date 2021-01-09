package com.szx.dao;

import com.szx.pojo.Course;
import com.szx.pojo.CourseSection;

import java.util.List;

public interface CourseContentMapper {

    //根据课程ID查询关联的章节信息及关联的课时信息
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);

    //查询课程信息，根据课程Id
    public Course findCourseByCourseId(Integer courseId);

    //新建章节信息
    public void saveSection(CourseSection courseSection);

    //修改章节信息，根据Id
    public void updateSection(CourseSection courseSection);

    //修改章节状态
    public void updateSectionStatus(CourseSection courseSection);

}
