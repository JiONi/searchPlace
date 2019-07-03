package com.example.sesarchingplace.config;

import com.example.sesarchingplace.entity.MemberUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class MyAuthentication extends UsernamePasswordAuthenticationToken{
    private static final long serialVersionUID = 1L;

    MemberUser member;

    public MyAuthentication(String id, String pw, List<GrantedAuthority> authList, MemberUser member) {
        super(id, pw, authList);
        this.member = member;
    }
}