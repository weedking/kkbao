package com.kk.kkbao.controller;

import com.kk.kkbao.dao.SUserMapper;
import com.kk.kkbao.pojo.SUser;
import com.kk.kkbao.service.UserService;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class MyController {
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")//查询用户
    @ResponseBody
    @CrossOrigin
    public ModelAndView showUser(HttpServletRequest request, ModelAndView mv, ModelMap modelMap) {
        int userId = Integer.parseInt(request.getParameter("userName"));
        SUser sUser = this.userService.getUserById(userId);
        mv.setViewName("/temShowUser");
        mv.addObject("title","欢迎使用Thymeleaf!");
        modelMap.put("user1",sUser);
        return mv;
    }

    @RequestMapping("/oldShowUser")//查询用户
    @ResponseBody
    @CrossOrigin
    public SUser toIndex(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        SUser sUser = this.userService.getUserById(userId);
        return sUser;
    }

    @RequestMapping("/addUser")//增加新用户
    @ResponseBody
    @CrossOrigin
    public SUser addUser(@RequestParam(value = "name", required = false) String name,
                         @RequestParam(value = "gonghao", required = false) String gonghao,
                         @RequestParam(value = "user_code", required = false) String user_code,
                         @RequestParam(value = "role_id", required = false) Integer role_id,
                         @RequestParam(value = "role_name", required = false) String role_name,
                         @RequestParam(value = "phone", required = false) String phone,
                         @RequestParam(value = "open_id", required = false) String open_id,
                         @RequestParam(value = "keshi_id", required = false) String keshi_id,
                         @RequestParam(value = "keshi_name", required = false) String keshi_name) {
        SUser record = new SUser();
        record.setName(name);
        record.setGonghao(gonghao);
        record.setUserCode(user_code);
        record.setRoleId(role_id);
        record.setRoleName(role_name);
        record.setPhone(phone);
        record.setOpenId(open_id);
        record.setKeshiId(keshi_id);
        record.setKeshiName(keshi_name);
        this.userService.addUser(record);
        System.out.println(name+gonghao+user_code+role_id+role_name+phone+keshi_id+keshi_name);
        return record;
    }

    @RequestMapping("/updateuser")//修改用户。注意updateuser是小写。
    @ResponseBody
    @CrossOrigin
    public SUser up( HttpServletRequest request,
                    @RequestParam(value = "id",required = false) String id,
                    @RequestParam(value = "name", required = false) String name,
                    @RequestParam(value = "gonghao", required = false) String gonghao,
                    @RequestParam(value = "user_code", required = false) String user_code,
                    @RequestParam(value = "role_id", required = false) Integer role_id,
                    @RequestParam(value = "role_name", required = false) String role_name,
                    @RequestParam(value = "phone", required = false) String phone,
                    @RequestParam(value = "open_id", required = false) String open_id,
                    @RequestParam(value = "keshi_id", required = false) String keshi_id,
                    @RequestParam(value = "keshi_name", required = false) String keshi_name){

        int userId = Integer.parseInt(request.getParameter("id"));
        SUser sUser = this.userService.getUserById(userId);//获得该id的记录
//        String ss = this.userService.getUserById(userId).getName();
        sUser.setName(name);//对该记录进行更新。去掉重复代码提示。
        sUser.setGonghao(gonghao);
        sUser.setUserCode(user_code);
        sUser.setRoleId(role_id);
        sUser.setRoleName(role_name);
        sUser.setPhone(phone);
        sUser.setOpenId(open_id);
        sUser.setKeshiId(keshi_id);
        sUser.setKeshiName(keshi_name);
        this.userService.updateUser(sUser);//更新

        SUser sUser1 = this.userService.getUserById(userId);//为了显示改过之后完整的记录
        return sUser1;
    }

    @RequestMapping("/deleteUser")//删除用户
    @ResponseBody
    @CrossOrigin
    public int deleteUser(HttpServletRequest request,
                             @RequestParam(value = "id",required = false) String id){
        int userId = Integer.parseInt(request.getParameter("id"));
        this.userService.deleteUser(userId);
        return userId;//返回删除的行数
    }
}


