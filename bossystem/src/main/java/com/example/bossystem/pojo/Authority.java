package com.example.bossystem.pojo;

//权限表
public class Authority {
    private Integer id;


    private Integer uerid;

    //为1表示管理员权限，为0表示用户权限
    private Integer Auth;


    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", uid=" + uerid +
                ", Auth=" + Auth +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uerid;
    }

    public void setUid(Integer uid) {
        this.uerid = uid;
    }

    public Integer getAuth() {
        return Auth;
    }

    public void setAuth(Integer auth) {
        Auth = auth;
    }
}
