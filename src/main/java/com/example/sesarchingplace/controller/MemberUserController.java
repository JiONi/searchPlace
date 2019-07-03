package com.example.sesarchingplace.controller;

import com.example.sesarchingplace.entity.MemberUser;
import com.example.sesarchingplace.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@Slf4j
public class MemberUserController {
    @Autowired
    MemberService memberService;

    @RequestMapping(value="/join/process.json", produces = "application/json", method= RequestMethod.POST)
    @ResponseBody
    public void joinMember(@RequestParam(value="userId") String userId, @RequestParam(value="userPw") String userPw){
        memberService.memberUserSave(userId, userPw);
    }

    @RequestMapping(value="/join/idDupCheck.json", method=RequestMethod.POST)
    @ResponseBody
    public int idDupCheck(@RequestParam(value="userId") String userId){
        int result = 0;

        MemberUser memberUser = memberService.getMemberByUserId(userId);

        if(memberUser != null){
            log.info("중복된 아이디 존재 : "+userId);
            result = 1;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("result", result);

        return result;
    }
}
