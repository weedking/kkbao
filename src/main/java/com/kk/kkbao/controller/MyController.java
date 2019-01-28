package com.kk.kkbao.controller;

import com.kk.kkbao.pojo.SUser;
import com.kk.kkbao.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@EnableAutoConfiguration
public class MyController {
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    @ResponseBody
    public SUser toIndex(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        SUser sUser = this.userService.getUserById(userId);
        return sUser;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    @CrossOrigin
    public SUser addUser( @RequestParam(value = "name",required = false) String name,
                          @RequestParam(value = "gonghao",required = false) String gonghao,
                          @RequestParam(value = "userCode",required = false) String userCode,
                          @RequestParam(value = "roleId",required = false) Integer roleId,
                          @RequestParam(value = "roleName",required = false) String roleName,
                          @RequestParam(value = "phone",required = false) String phone,
                          @RequestParam(value = "openId",required = false) String openId,
                          @RequestParam(value = "keshiId",required = false) String keshiId,
                          @RequestParam(value = "keshiName",required = false) String keshiName){
        SUser record = new SUser();
        record.setName(name);
        record.setGonghao(gonghao);
        record.setUserCode(userCode);
        record.setRoleId(roleId);
        record.setRoleName(roleName);
        record.setPhone(phone);
        record.setOpenId(openId);
        record.setKeshiId(keshiId);
        record.setKeshiName(keshiName);
        this.userService.addUser(record);
        System.out.println(name+gonghao+userCode+roleId+roleName+phone+keshiId+keshiName);
        return record;
    }



}
