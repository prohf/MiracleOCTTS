package cn.miracle.octts.dao;

import cn.miracle.octts.common.base.BaseMapper;
import cn.miracle.octts.entity.GroupApply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by hf on 2017/7/1.
 */
public interface GroupApplyDao extends BaseMapper<GroupApply> {

    @Select("SELECT GROUP_APPLY_OWNER_ID FROM GROUP_APPLY")
    List<String> findGroupApplyOwner();

    @Select("SELECT gmt_create, gmt_modified, uid, group_apply_id, course_id, group_apply_name, group_apply_owner_id " +
            "FROM group_apply " +
            "WHERE group_apply_id = #{group_apply_id}")
    @ResultMap("cn.miracle.octts.dao.GroupApplyDao.GroupApplyDetail")
    GroupApply findGroupApplyById(Integer group_apply_id);

    @Select("SELECT gmt_create, gmt_modified, uid, group_apply_id, course_id, group_apply_name, group_apply_owner_id " +
            "FROM group_apply " +
            "WHERE course_id = #{course_id}")
    @ResultMap("cn.miracle.octts.dao.GroupApplyDao.GroupApplyDetail")
    List<GroupApply> findGroupApplyByCourseId(Integer course_id);

    @Delete("DELETE FROM group_apply WHERE group_apply_id = #{group_apply_id}")
    Integer deleteGroupApplyById(Integer group_apply_id);

}
