package com.ink.hb.login.pojo;

public class Login {

    private int loginId;    //登录编号

    private String loginName;   //用户名

    private String loginPwd;    //密码

    private int loginPurview;  //标识

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public int getLoginPurview() {
        return loginPurview;
    }

    public void setLoginPurview(int loginPurview) {
        this.loginPurview = loginPurview;
    }
}
