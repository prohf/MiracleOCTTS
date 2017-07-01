package cn.miracle.octts.dao;

import cn.miracle.octts.common.base.BaseMapper;
import cn.miracle.octts.entity.Homework;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by hf on 2017/6/28.
 */
public interface HomeworkDao extends BaseMapper<Homework> {
    @Select("SELECT homework_id, course_id, teacher_id, homework_score, homework_status, homework_title, homework_message, homework_start_time, homework_end_time, resubmit_limit " +
            "FROM homework " +
            "WHERE homework_id = #{homework_id}")
    @ResultMap("cn.miracle.octts.dao.HomeworkDao.HomeworkInformation")
    Homework findHomeworkById(Integer homework_id);

    @Select("SELECT homework_id, course_id, teacher_id, homework_score, homework_status, homework_title, homework_message, homework_start_time, homework_end_time, resubmit_limit " +
            "FROM homework " +
            "WHERE homework_id = #{course_id}")
    @ResultMap("cn.miracle.octts.dao.HomeworkDao.HomeworkInformation")
    List<Homework> findHoweworkByCourseId(Integer course_id);

    @Insert("INSERT INTO homework(gmt_create, gmt_modified, uid, homework_id, course_id, teacher_id, homework_score, homework_title, homework_message, homework_start_time, homework_end_time, resubmit_limit)" +
            "VALUES(#{createtime},#{updatetime},#{uid},#{homework_id},#{course_id},#{teacher_id},#{homework_score},#{homework_title},#{homework_message},#{homework_start_time},#{homework_end_time},#{resubmit_limit})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void InsertHomework(Homework homework);

    @Select("SELECT max(homework_id) FROM homework")
    Integer findMaxHomeworkId();
}
