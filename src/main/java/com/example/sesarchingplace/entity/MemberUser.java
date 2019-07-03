package com.example.sesarchingplace.entity;


import javax.persistence.*;

@Entity
@Table(name="USER")
public class MemberUser {
    @Id
    private String userId;

    @Column
    private String userPw;

    public String getUserId(){
        return userId;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserPw(){
        return userPw;
    }
    public void setUserPw(String userPw){
        this.userPw = userPw;
    }

    public MemberUser(String userId, String userPw){
        super();
        this.userId = userId;
        this.userPw = userPw;
    }
    public MemberUser(){}
}
