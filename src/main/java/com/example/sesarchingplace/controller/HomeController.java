package com.example.sesarchingplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value="/join/page", method=RequestMethod.GET)
    public String joinPage(){
        return "joinPage";
    }

    @RequestMapping(value="/search/page", method=RequestMethod.GET)
    public String searchPage() {
        return "index";
    }

    @RequestMapping(value="/search/mySearchHistory", method=RequestMethod.GET)
    public String mySearchHistory() {
        return "mySearchHistory";
    }

    @RequestMapping(value="/search/top10Keyword", method=RequestMethod.GET)
    public String top10Keyword() {
        return "top10Keyword";
    }
}
