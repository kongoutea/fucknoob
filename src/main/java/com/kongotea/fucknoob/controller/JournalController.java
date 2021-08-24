package com.kongotea.fucknoob.controller;

import com.kongotea.fucknoob.entity.Record;
import com.kongotea.fucknoob.util.RecordClassify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.kongotea.fucknoob.mapper.RecordMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class JournalController {

    @Autowired
    private RecordMapper recordMapper;

    @RequestMapping("/journal.html")
    public String Journal(HttpSession session, Model model) {
        //绘制导随记录表格的数据传递
        String userName = session.getAttribute("username").toString();
        List<Record> userRecord = recordMapper.findAllByUserName(userName);
        ArrayList<String> allRaidNames = new ArrayList<>();
        ArrayList<Integer> allRaidTimes = new ArrayList<>();
        for(Record record : userRecord) {

            if(!RecordClassify.isExist(record.getRaidName(), allRaidNames)) {
                allRaidNames.add(record.getRaidName());
            }

            int index = userRecord.indexOf(record);
            allRaidTimes.add(index,allRaidTimes.get(index)+1);
        }
        model.addAttribute("allrn",allRaidNames);
        model.addAttribute("allrt",allRaidTimes);

        ArrayList<String> allJobNames = new ArrayList<>();
        ArrayList<Integer> allJobTimes = new ArrayList<>();
        for(Record record : userRecord) {

            if(!RecordClassify.isExist(record.getUserJob(), allJobNames)) {
                allJobNames.add(record.getUserJob());
            }

            int index = userRecord.indexOf(record);
            allJobTimes.add(index, allJobTimes.get(index)+1);

        }
        model.addAttribute("alljn",allJobNames);
        model.addAttribute("alljt",allJobTimes);

        System.out.println(allRaidNames);
        System.out.println(allRaidTimes);
        System.out.println(allJobNames);
        System.out.println(allJobTimes);


        return "journal";
    }

}
