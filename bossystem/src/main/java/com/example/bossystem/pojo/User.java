package com.example.bossystem.pojo;

/*
*
* 使用lombok
* @Data
* @AllArgsConstructor全参构造器
* @NoArgsConstructor无参构造器
* */

import org.springframework.stereotype.Component;

@Component
public class User {
    private Integer uid;
    private String uname;//用户名
    private String upwd;//用户密码
    private String utel;//用户联系电话
    private String uemail;//用户Email
    private String uaddress;//用户地址
    private String upostcode;//用户邮编

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public String getUpostcode() {
        return upostcode;
    }

    public void setUpostcode(String upostcode) {
        this.upostcode = upostcode;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", utel='" + utel + '\'' +
                ", uemail='" + uemail + '\'' +
                ", uaddress='" + uaddress + '\'' +
                ", upostcode='" + upostcode + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public String getUname() {
        return uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public String getUtel() {
        return utel;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public void setUtel(String utel) {
        this.utel = utel;
    }

}
