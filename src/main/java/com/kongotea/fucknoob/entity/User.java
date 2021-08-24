package com.kongotea.fucknoob.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //用户
    private String userId;
    private String userName;
    private String password;
}
