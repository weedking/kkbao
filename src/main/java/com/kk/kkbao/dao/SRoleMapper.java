package com.kk.kkbao.dao;

import com.kk.kkbao.pojo.SRole;
import com.kk.kkbao.pojo.SRoleExample;
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

public interface SRoleMapper {
    @SelectProvider(type=SRoleSqlProvider.class, method="countByExample")
    int countByExample(SRoleExample example);

    @DeleteProvider(type=SRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(SRoleExample example);

    @Delete({
        "delete from s_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into s_role (id, name, ",
        "bak)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{bak,jdbcType=VARCHAR})"
    })
    int insert(SRole record);

    @InsertProvider(type=SRoleSqlProvider.class, method="insertSelective")
    int insertSelective(SRole record);

    @SelectProvider(type=SRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="bak", property="bak", jdbcType=JdbcType.VARCHAR)
    })
    List<SRole> selectByExample(SRoleExample example);

    @Select({
        "select",
        "id, name, bak",
        "from s_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="bak", property="bak", jdbcType=JdbcType.VARCHAR)
    })
    SRole selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SRole record, @Param("example") SRoleExample example);

    @UpdateProvider(type=SRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SRole record, @Param("example") SRoleExample example);

    @UpdateProvider(type=SRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SRole record);

    @Update({
        "update s_role",
        "set name = #{name,jdbcType=VARCHAR},",
          "bak = #{bak,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SRole record);
}