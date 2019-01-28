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
                          @RequestParam(value = "user_code",required = false) String user_code,
                          @RequestParam(value = "role_id",required = false) Integer role_id,
                          @RequestParam(value = "role_name",required = false) String role_name,
                          @RequestParam(value = "phone",required = false) String phone,
                          @RequestParam(value = "open_id",required = false) String open_id,
                          @RequestParam(value = "keshi_id",required = false) String keshi_id,
                          @RequestParam(value = "keshi_name",required = false) String keshi_name){
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
//        System.out.println(name+gonghao+user_code+role_id+role_name+phone+keshi_id+keshi_name);
        return record;
    }



}
