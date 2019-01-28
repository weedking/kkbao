package com.kk.kkbao.pojo;

import javax.persistence.Id;
import java.io.Serializable;

public class SUser implements Serializable {
    @Id
    private Integer id;

    private String name;

    private String gonghao;

    private String userCode;

    private Integer roleId;

    private String roleName;

    private String phone;

    private String openId;

    private String keshiId;

    private String keshiName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGonghao() {
        return gonghao;
    }

    public void setGonghao(String gonghao) {
        this.gonghao = gonghao == null ? null : gonghao.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getKeshiId() {
        return keshiId;
    }

    public void setKeshiId(String keshiId) {
        this.keshiId = keshiId == null ? null : keshiId.trim();
    }

    public String getKeshiName() {
        return keshiName;
    }

    public void setKeshiName(String keshiName) {
        this.keshiName = keshiName == null ? null : keshiName.trim();
    }
}