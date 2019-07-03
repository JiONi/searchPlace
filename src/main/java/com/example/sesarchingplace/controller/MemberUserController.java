package com.example.sesarchingplace.controller;

import com.example.sesarchingplace.entity.MemberUser;
import com.example.sesarchingplace.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class MemberUserController {
    @Autowired
    MemberService memberService;

    @RequestMapping(value="/join/process.json", produces = "application/json", method= RequestMethod.POST)
    @ResponseBody
    public void joinMember(@RequestParam(value="userId") String userId, @RequestParam(value="userPw") String userPw){
        MemberUser memberUser = new MemberUser(userId, userPw);
        memberService.memberUserSave(memberUser);
    }

    @RequestMapping(value="/join/idDupCheck.json", method=RequestMethod.POST)
    @ResponseBody
    public int idDupCheck(@RequestParam(value="userId") String userId){
        int result = 0;

        MemberUser memberUser = memberService.getMemberByUserId(userId);

        if(memberUser != null){
            result = 1;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("result", result);

        return result;
    }
}
