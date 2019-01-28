package com.kk.kkbao.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.kk.kkbao.pojo.SUser;
import com.kk.kkbao.pojo.SUserExample.Criteria;
import com.kk.kkbao.pojo.SUserExample.Criterion;
import com.kk.kkbao.pojo.SUserExample;
import java.util.List;
import java.util.Map;

public class SUserSqlProvider {

    public String countByExample(SUserExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("s_user");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(SUserExample example) {
        BEGIN();
        DELETE_FROM("s_user");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(SUser record) {
        BEGIN();
        INSERT_INTO("s_user");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getGonghao() != null) {
            VALUES("gonghao", "#{gonghao,jdbcType=VARCHAR}");
        }
        
        if (record.getUserCode() != null) {
            VALUES("user_code", "#{userCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleId() != null) {
            VALUES("role_id", "#{roleId,jdbcType=INTEGER}");
        }
        
        if (record.getRoleName() != null) {
            VALUES("role_name", "#{roleName,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenId() != null) {
            VALUES("open_id", "#{openId,jdbcType=VARCHAR}");
        }
        
        if (record.getKeshiId() != null) {
            VALUES("keshi_id", "#{keshiId,jdbcType=VARCHAR}");
        }
        
        if (record.getKeshiName() != null) {
            VALUES("keshi_name", "#{keshiName,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(SUserExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("name");
        SELECT("gonghao");
        SELECT("user_code");
        SELECT("role_id");
        SELECT("role_name");
        SELECT("phone");
        SELECT("open_id");
        SELECT("keshi_id");
        SELECT("keshi_name");
        FROM("s_user");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SUser record = (SUser) parameter.get("record");
        SUserExample example = (SUserExample) parameter.get("example");
        
        BEGIN();
        UPDATE("s_user");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getGonghao() != null) {
            SET("gonghao = #{record.gonghao,jdbcType=VARCHAR}");
        }
        
        if (record.getUserCode() != null) {
            SET("user_code = #{record.userCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleId() != null) {
            SET("role_id = #{record.roleId,jdbcType=INTEGER}");
        }
        
        if (record.getRoleName() != null) {
            SET("role_name = #{record.roleName,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenId() != null) {
            SET("open_id = #{record.openId,jdbcType=VARCHAR}");
        }
        
        if (record.getKeshiId() != null) {
            SET("keshi_id = #{record.keshiId,jdbcType=VARCHAR}");
        }
        
        if (record.getKeshiName() != null) {
            SET("keshi_name = #{record.keshiName,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("s_user");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("gonghao = #{record.gonghao,jdbcType=VARCHAR}");
        SET("user_code = #{record.userCode,jdbcType=VARCHAR}");
        SET("role_id = #{record.roleId,jdbcType=INTEGER}");
        SET("role_name = #{record.roleName,jdbcType=VARCHAR}");
        SET("phone = #{record.phone,jdbcType=VARCHAR}");
        SET("open_id = #{record.openId,jdbcType=VARCHAR}");
        SET("keshi_id = #{record.keshiId,jdbcType=VARCHAR}");
        SET("keshi_name = #{record.keshiName,jdbcType=VARCHAR}");
        
        SUserExample example = (SUserExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(SUser record) {
        BEGIN();
        UPDATE("s_user");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getGonghao() != null) {
            SET("gonghao = #{gonghao,jdbcType=VARCHAR}");
        }
        
        if (record.getUserCode() != null) {
            SET("user_code = #{userCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleId() != null) {
            SET("role_id = #{roleId,jdbcType=INTEGER}");
        }
        
        if (record.getRoleName() != null) {
            SET("role_name = #{roleName,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenId() != null) {
            SET("open_id = #{openId,jdbcType=VARCHAR}");
        }
        
        if (record.getKeshiId() != null) {
            SET("keshi_id = #{keshiId,jdbcType=VARCHAR}");
        }
        
        if (record.getKeshiName() != null) {
            SET("keshi_name = #{keshiName,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(SUserExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}