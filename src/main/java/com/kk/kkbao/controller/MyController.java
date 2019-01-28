package com.kk.kkbao.controller;

import com.kk.kkbao.pojo.SUser;
import com.kk.kkbao.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
