package com.kongotea.fucknoob.controller;

import com.kongotea.fucknoob.entity.Record;
import com.kongotea.fucknoob.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private RecordMapper recordMapper;

    @RequestMapping("/dashboard.html")
    public String dashboard(HttpSession session, Model model) {
        String userName = session.getAttribute("username").toString();
        model.addAttribute("username",userName);
        List<Record> allUserRecord = recordMapper.findAllByUserName(userName);
        model.addAttribute("leftmissiontimes",2000-allUserRecord.size());

        return "dashboard";
    }

}
