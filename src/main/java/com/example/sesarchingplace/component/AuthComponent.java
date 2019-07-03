package com.example.sesarchingplace.component;

import com.example.sesarchingplace.config.MyAuthentication;
import com.example.sesarchingplace.entity.MemberUser;
import com.example.sesarchingplace.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthComponent implements AuthenticationProvider {

    @Autowired
    MemberService memberService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = authentication.getName();
        String userPw = authentication.getCredentials().toString();
        return authenticate(userId, userPw);
    }

    private Authentication authenticate(String id, String pw) throws AuthenticationException {
        MemberUser memberUser = new MemberUser(id, pw);
        memberUser = memberService.getMemberByUserId(id);
        if(memberUser == null || !passwordEncoder.matches(pw, memberUser.getUserPw())){
            throw new AuthenticationCredentialsNotFoundException(id);

        }

        List<GrantedAuthority> auth = new ArrayList<>();
        auth.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new MyAuthentication(id, pw, auth, memberUser);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
