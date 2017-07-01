package cn.miracle.octts.service;


import cn.miracle.octts.dao.CourseDao;
import cn.miracle.octts.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tony on 2017/6/27.
 */
@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    private Date currentTime = new Date(System.currentTimeMillis());

    public Course findCourseById(Integer course_id) {
        return courseDao.findCourseById(course_id);
    }

    //导出教务课程信息
    public HashMap<String, Object> adminCourse2Json(Course course) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String course_start_date = sdf.format(course.getCourse_start_time());

        HashMap<String, Object> data = new HashMap<>();

        data.put("course_id", course.getCourse_id());
        data.put("course_year", course.getCourse_year());
        data.put("course_status",course.getCourse_status());
        data.put("course_name",course.getCourse_name());
        data.put("course_start_time",course_start_date);
        data.put("course_hour",course.getCourse_hour());
        data.put("course_location",course.getCourse_hour());
        data.put("course_credit",course.getCourse_credit());
        data.put("teacher_information",course.getTeacher_information());

        return data;
    }

    public HashMap<String, Object> teacherCourse2Json(Course course) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return adminCourse2Json(course);

        //TODO 以后改

        //return data;
    }

    public int updateCourse(Course course, String uid) {
        course.setUpdatetime(currentTime);
        course.setUid(uid);
        return courseDao.updateCourse(course);
    }

    public int insertCourse(Course course, String uid) {
        course.setCreatetime(currentTime);
        course.setUpdatetime(currentTime);
        course.setUid(uid);
        return courseDao.insertCourse(course);
    }

    public List<Course> findAllCourse(){
        return courseDao.selectAllCourse();
    }
}
