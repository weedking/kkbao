package com.kk.kkbao.dao;

import com.kk.kkbao.pojo.SUser;
import com.kk.kkbao.pojo.SUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SUserMapper {
    @SelectProvider(type=SUserSqlProvider.class, method="countByExample")
    int countByExample(SUserExample example);

    @DeleteProvider(type=SUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(SUserExample example);

    @Delete({
        "delete from s_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into s_user (id, name, ",
        "gonghao, user_code, ",
        "role_id, role_name, ",
        "phone, open_id, keshi_id, ",
        "keshi_name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{gonghao,jdbcType=VARCHAR}, #{userCode,jdbcType=VARCHAR}, ",
        "#{roleId,jdbcType=INTEGER}, #{roleName,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{openId,jdbcType=VARCHAR}, #{keshiId,jdbcType=VARCHAR}, ",
        "#{keshiName,jdbcType=VARCHAR})"
    })
    int insert(SUser record);

    @InsertProvider(type=SUserSqlProvider.class, method="insertSelective")
    int insertSelective(SUser record);

    @SelectProvider(type=SUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gonghao", property="gonghao", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_code", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="keshi_id", property="keshiId", jdbcType=JdbcType.VARCHAR),
        @Result(column="keshi_name", property="keshiName", jdbcType=JdbcType.VARCHAR)
    })
    List<SUser> selectByExample(SUserExample example);

    @Select({
        "select",
        "id, name, gonghao, user_code, role_id, role_name, phone, open_id, keshi_id, ",
        "keshi_name",
        "from s_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gonghao", property="gonghao", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_code", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="keshi_id", property="keshiId", jdbcType=JdbcType.VARCHAR),
        @Result(column="keshi_name", property="keshiName", jdbcType=JdbcType.VARCHAR)
    })
    SUser selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SUser record, @Param("example") SUserExample example);

    @UpdateProvider(type=SUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SUser record, @Param("example") SUserExample example);

    @UpdateProvider(type=SUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SUser record);

    @Update({
        "update s_user",
        "set name = #{name,jdbcType=VARCHAR},",
          "gonghao = #{gonghao,jdbcType=VARCHAR},",
          "user_code = #{userCode,jdbcType=VARCHAR},",
          "role_id = #{roleId,jdbcType=INTEGER},",
          "role_name = #{roleName,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "open_id = #{openId,jdbcType=VARCHAR},",
          "keshi_id = #{keshiId,jdbcType=VARCHAR},",
          "keshi_name = #{keshiName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SUser record);
}