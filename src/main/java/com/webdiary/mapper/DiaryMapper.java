package com.webdiary.mapper;

import com.webdiary.entity.Diary;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface DiaryMapper {
    @Delete({
        "delete from diary",
        "where diary_id = #{diaryId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer diaryId);

    @Insert({
        "insert into diary (diary_title, customer_id, ",
        "create_time, diary_content)",
        "values (#{diaryTitle,jdbcType=VARCHAR}, #{customerId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{diaryContent,jdbcType=LONGVARBINARY})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="diaryId", before=false, resultType=Integer.class)
    int insert(Diary record);

    @Select({
        "select",
        "diary_id, diary_title, customer_id, create_time, diary_content",
        "from diary",
        "where diary_id = #{diaryId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="diary_id", property="diaryId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="diary_title", property="diaryTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="diary_content", property="diaryContent", jdbcType=JdbcType.LONGVARBINARY)
    })
    Diary selectByPrimaryKey(Integer diaryId);

    @Select({
        "select",
        "diary_id, diary_title, customer_id, create_time, diary_content",
        "from diary"
    })
    @Results({
        @Result(column="diary_id", property="diaryId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="diary_title", property="diaryTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="diary_content", property="diaryContent", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<Diary> selectAll();

    @Update({
        "update diary",
        "set diary_title = #{diaryTitle,jdbcType=VARCHAR},",
          "customer_id = #{customerId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "diary_content = #{diaryContent,jdbcType=LONGVARBINARY}",
        "where diary_id = #{diaryId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Diary record);
}