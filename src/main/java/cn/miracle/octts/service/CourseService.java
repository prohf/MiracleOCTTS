package cn.miracle.octts.service;


import cn.miracle.octts.dao.CourseDao;
import cn.miracle.octts.entity.Course;
import cn.miracle.octts.util.DateConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

/**
 * Created by Tony on 2017/6/27.
 */
@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    public Course findCourseById(Integer course_id) {
        return courseDao.findCourseById(course_id);
    }

    public HashMap<String, Object> course2Json(Course course) throws ParseException {

        HashMap<String, Object> data = new HashMap<String, Object>();

        data.put("course_id", course.getCourse_id());
        data.put("course_year", course.getCourse_year());
        data.put("course_status", course.getCourse_status());
        data.put("course_name", course.getCourse_name());
        data.put("course_start_time", DateConvert.date2String(course.getCourse_start_time()));
        data.put("course_hour", course.getCourse_hour());
        data.put("course_location", course.getCourse_location());
        data.put("course_credit", course.getCourse_credit());
        data.put("team_limit_information", course.getTeam_limit_information());
        data.put("teacher_information", course.getTeacher_information());
        data.put("course_information", course.getCourse_information());

        return data;
    }

    public Integer updateCourse(Course course, String uid) {
        Date currentTime = new Date(System.currentTimeMillis());
        course.setUpdatetime(currentTime);
        course.setUid(uid);
        return courseDao.updateCourse(course);
    }

    public Integer insertCourse(Course course, String uid) {
        Date currentTime = new Date(System.currentTimeMillis());
        course.setCreatetime(currentTime);
        course.setUpdatetime(currentTime);
        course.setUid(uid);
        return courseDao.insertCourse(course);
    }

    public List<Course> findAllCourse() {
        return courseDao.findAllCourse();
    }

    public Integer findCurrentCourse() {
        return courseDao.findCurrentCourse();
    }

    public Integer endAllCourse() {
        return courseDao.endAllCourse();
    }

    public Integer findMaxCourseId() {
        if (courseDao.findMaxCourseId() != null) {
            return courseDao.findMaxCourseId() + 1;
        } else {
            return new Integer(1);
        }
    }

    public List<HashMap<String, Object>> getCourseList() throws ParseException {
        List<HashMap<String, Object>> courseList = new ArrayList<HashMap<String, Object>>();

        List<Course> courseResult = findAllCourse();
        Iterator<Course> courseIter = courseResult.iterator();
        while (courseIter.hasNext()) {
            HashMap<String, Object> course = course2Json(courseIter.next());
            courseList.add(course);
        }
        return courseList;
    }
}
