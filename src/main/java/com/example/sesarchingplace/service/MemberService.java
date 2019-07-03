package com.example.sesarchingplace.service;

import com.example.sesarchingplace.DAO.MemberDAO;
import com.example.sesarchingplace.entity.MemberUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MemberService{

    @Autowired
    private MemberDAO memberDAO;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public MemberUser getMemberByUserId(String userId) {
        //MemberUser memberUser = memberDAO.getOne(userId);
        Optional<MemberUser> memberUserList = memberDAO.findById(userId);
        if(!memberUserList.isPresent()){
            return null;
        }else{
            return memberUserList.get();
        }
    }

    public void memberUserSave(MemberUser memberUser){
        memberUser.setUserPw(passwordEncoder.encode(memberUser.getUserPw()));
        memberDAO.save(memberUser);
    }
}
