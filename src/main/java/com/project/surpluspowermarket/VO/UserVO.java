package com.project.surpluspowermarket.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Lombok 플러그인 사용. Collection 매핑 어노테이션 사용.
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
