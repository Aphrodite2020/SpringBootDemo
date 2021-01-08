package com.webdiary.mapper;

import com.webdiary.entity.unfinishedWork;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface unfinishedWorkMapper {
    @Delete({
        "delete from unfinished_work",
        "where unfinished_id = #{unfinishedId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer unfinishedId);

    @Insert({
        "insert into unfinished_work (unfinished_title, create_time, ",
        "deadline, customer_id, ",
        "unfinished_content)",
        "values (#{unfinishedTitle,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{deadline,jdbcType=TIMESTAMP}, #{customerId,jdbcType=INTEGER}, ",
        "#{unfinishedContent,jdbcType=LONGVARBINARY})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="unfinishedId", before=false, resultType=Integer.class)
    int insert(unfinishedWork record);

    @Select({
        "select",
        "unfinished_id, unfinished_title, create_time, deadline, customer_id, unfinished_content",
        "from unfinished_work",
        "where unfinished_id = #{unfinishedId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="unfinished_id", property="unfinishedId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="unfinished_title", property="unfinishedTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deadline", property="deadline", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER),
        @Result(column="unfinished_content", property="unfinishedContent", jdbcType=JdbcType.LONGVARBINARY)
    })
    unfinishedWork selectByPrimaryKey(Integer unfinishedId);

    @Select({
        "select",
        "unfinished_id, unfinished_title, create_time, deadline, customer_id, unfinished_content",
        "from unfinished_work"
    })
    @Results({
        @Result(column="unfinished_id", property="unfinishedId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="unfinished_title", property="unfinishedTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deadline", property="deadline", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER),
        @Result(column="unfinished_content", property="unfinishedContent", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<unfinishedWork> selectAll();

    @Update({
        "update unfinished_work",
        "set unfinished_title = #{unfinishedTitle,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "deadline = #{deadline,jdbcType=TIMESTAMP},",
          "customer_id = #{customerId,jdbcType=INTEGER},",
          "unfinished_content = #{unfinishedContent,jdbcType=LONGVARBINARY}",
        "where unfinished_id = #{unfinishedId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(unfinishedWork record);
}