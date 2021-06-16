package com.gdou.gms.pojo;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private String userid;

    private String username;

    private String gender;

    private String mail;

    private String phone;

    private Integer roleid;

    private static final long serialVersionUID = 1L;

    public UserInfo()
    {
    }

    public UserInfo(String userid, String username, String gender, String mail, String phone, Integer roleid)
    {
        this.userid = userid;
        this.username = username;
        this.gender = gender;
        this.mail = mail;
        this.phone = phone;
        this.roleid = roleid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", username=").append(username);
        sb.append(", gender=").append(gender);
        sb.append(", mail=").append(mail);
        sb.append(", phone=").append(phone);
        sb.append(", roleid=").append(roleid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}