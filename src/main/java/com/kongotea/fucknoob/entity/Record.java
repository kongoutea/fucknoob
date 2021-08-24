package com.kongotea.fucknoob.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    //导随记录
    private Integer recordId;
    private String recordUser;
    private String recordNumber;
    private String raidName;
    private String comment;
    private String userJob;
}
