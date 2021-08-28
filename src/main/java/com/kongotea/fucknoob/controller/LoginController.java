package com.kongotea.fucknoob.controller;

import com.kongotea.fucknoob.entity.User;
import com.kongotea.fucknoob.entity.Record;
import com.kongotea.fucknoob.mapper.RecordMapper;
import com.kongotea.fucknoob.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RecordMapper recordMapper;

    @RequestMapping("/login")
    public String login(
            @RequestParam("qqid") String qqid,
            @RequestParam("password") String password,
            Model model, HttpSession session) {
            //登陆
        User loginUser = userMapper.findById(qqid);

        if(loginUser == null) {
            model.addAttribute("msg","不存在该用户，你寄吧谁");
            return "index";
        }
        if(loginUser.getUserId().equals(qqid) && loginUser.getPassword().equals(password)) {
            model.addAttribute("username",loginUser.getUserName());
            session.setAttribute("username", loginUser.getUserName());

            List<Record> allUserRecord = recordMapper.findAllByUserName(loginUser.getUserName());
            model.addAttribute("leftmissiontimes",2000-allUserRecord.size());
            return "dashboard";
        }
        else{
            model.addAttribute("msg","密码错误，导随把你打弱智啦？.jpg");
            return "index";
        }
    }

    @RequestMapping("/regis")
    public String register(
            @RequestParam("qqid") String qqid,
            @RequestParam("name") String userName,
            @RequestParam("password") String password,
            Model model) {
        //注册
        User newUser = new User();
        newUser.setUserId(qqid);
        newUser.setUserName(userName);
        newUser.setPassword(password);
        List<User> allUsers = userMapper.findAll();
        for(User thisUser : allUsers) {
            if(thisUser.getUserId().equals(newUser.getUserId())) {
                model.addAttribute("msg","你已经注册过啦");
                return "register";
            }
        }
        if(userMapper.save(newUser) == 1) {
            model.addAttribute("msg","注册成功！可以登陆");
        }

        return "index";
    }


}
