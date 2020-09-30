package com.project.surpluspowermarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "UserDataCollection")
public class UserVO {
    @Id
    private String id;
    private String password;
    private String name;
    private String email;
    private String birthday;
    private String sex;
    private String phone;
    private String address;
    private String date;
    private int isEmployer;
}
