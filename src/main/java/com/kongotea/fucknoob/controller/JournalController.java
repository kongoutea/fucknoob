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
        model.addAttribute("username", userName);
        List<Record> userRecord = recordMapper.findAllByUserName(userName);
        //传递全副本次数给前端
        ArrayList<String> allRaidNames = new ArrayList<>();
        ArrayList<Integer> allRaidTimes = new ArrayList<>();
        for(Record record : userRecord) {
            if(!RecordClassify.isExist(record.getRaidName(), allRaidNames)) {
                allRaidNames.add(record.getRaidName());
                allRaidTimes.add(1);
            }
            else{
                int index = allRaidNames.indexOf(record.getRaidName());
                allRaidTimes.set(index, allRaidTimes.get(index)+1);
            }
        }
        model.addAttribute("allrn",allRaidNames);
        model.addAttribute("allrt",allRaidTimes);
        //传递全职业次数给前端
        ArrayList<String> allJobNames = new ArrayList<>();
        ArrayList<Integer> allJobTimes = new ArrayList<>();
        for(Record record : userRecord) {

            if(!RecordClassify.isExist(record.getUserJob(), allJobNames)) {
                allJobNames.add(record.getUserJob());
                allJobTimes.add(1);
            }
            else{
                int index = allJobNames.indexOf(record.getUserJob());
                allJobTimes.set(index, allJobTimes.get(index)+1);
            }
        }
        model.addAttribute("alljn",allJobNames);
        model.addAttribute("alljt",allJobTimes);
        //职业颜色
        ArrayList<String> jobColors = new ArrayList<>();
        for(String thisJob : allJobNames) {
            if(thisJob.equals("骑士")) {
                jobColors.add("#151C64");
            }
            else if(thisJob.equals("战士")) {
                jobColors.add("#991717");
            }
            else if(thisJob.equals("绝枪")||thisJob.equals("枪刃")) {
                jobColors.add("#4E3831");
            }
            else if(thisJob.equals("黑骑")) {
                jobColors.add("#880E4F");
            }
            else if(thisJob.equals("忍者")) {
                jobColors.add("#D32F2F");
            }
            else if(thisJob.equals("龙骑")) {
                jobColors.add("#3F51B5");
            }
            else if(thisJob.equals("武士")) {
                jobColors.add("#FFCA28");
            }
            else if(thisJob.equals("武僧")) {
                jobColors.add("#FF9800");
            }
            else if(thisJob.equals("机工")) {
                jobColors.add("#0097A7");
            }
            else if(thisJob.equals("舞者")) {
                jobColors.add("#F48FB1");
            }
            else if(thisJob.equals("诗人")) {
                jobColors.add("#9E9D24");
            }
            else if(thisJob.equals("白魔")) {
                jobColors.add("#757575");
            }
            else if(thisJob.equals("学者")) {
                jobColors.add("#7986E6");
            }
            else if(thisJob.equals("占星")) {
                jobColors.add("#795548");
            }
            else if(thisJob.equals("召唤")) {
                jobColors.add("#2E7D32");
            }
            else if(thisJob.equals("黑魔")) {
                jobColors.add("#7E57C2");
            }
            else if(thisJob.equals("赤魔")) {
                jobColors.add("#E91E63");
            }
            else {
                jobColors.add("#8DEEEE");
            }
        }
        model.addAttribute("jobcolor", jobColors);

        //波波饼图


        //职业饼图

        return "journal";
    }

}
