package com.kongotea.fucknoob.util;

import java.util.ArrayList;

public class RecordClassify {

    public static boolean isExist(String ele, ArrayList<String> allEle) {

        for(String r : allEle) {
            if(r.equals(ele)) {
                return true;
            }
            else{
                return false;
            }
        }

        return false;
    }

}
