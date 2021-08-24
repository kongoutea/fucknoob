package com.kongotea.fucknoob.controller;

import com.alibaba.fastjson.JSONObject;
import com.kongotea.fucknoob.entity.User;
import com.kongotea.fucknoob.entity.Record;
import com.kongotea.fucknoob.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
public class RecordController {

    @Autowired
    private RecordMapper recordMapper;

    @RequestMapping("/record.html")
    public String recordView(HttpSession session, Model model) {
        //导随全纪录

        String userName = session.getAttribute("username").toString();
        model.addAttribute(model.addAttribute("username",userName));
        List<Record> allRecords = recordMapper.findAllByUserName(userName);
        Collections.reverse(allRecords);
        model.addAttribute("recs", allRecords);
        return "record";
    }



    @PostMapping("/add")
    public String addRecord(Record newRecord, HttpSession session, Model model) {
        //新增导随记录
        String userName = session.getAttribute("username").toString();
        List<Record> allRecords = recordMapper.findAllByUserName(userName);
        Integer recordNumber = allRecords.size()+1;
        newRecord.setRecordNumber(recordNumber.toString());
        newRecord.setRecordUser(userName);
        recordMapper.save(newRecord);

        return "redirect:/record.html";
    }

}
