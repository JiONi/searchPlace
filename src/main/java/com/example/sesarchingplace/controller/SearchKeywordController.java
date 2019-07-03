package com.example.sesarchingplace.controller;

import com.example.sesarchingplace.DAO.SearchKeywordDAO;
import com.example.sesarchingplace.DAO.SearchKeywordRepository;
import com.example.sesarchingplace.entity.SearchKeyword;
import com.example.sesarchingplace.entity.SearchKeywordPK;
import com.example.sesarchingplace.service.SearchKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class SearchKeywordController {
    @Autowired
    SearchKeywordService searchKeywordService;

    @RequestMapping(value="/search/getMySearchHistory.json", method= RequestMethod.POST)
    public ModelAndView getMySearchHistory(Authentication authentication) throws Exception {

        List<SearchKeyword> searchKeywordList = searchKeywordService.mySearchHistoryList(authentication);

        ModelAndView mv = new ModelAndView("jsonView");
        mv.addObject("searchKeywordList", searchKeywordList);

        return mv;
    }

    @RequestMapping(value="/search/top10Keywords.json", method=RequestMethod.GET)
    public ModelAndView top10Keywords() {
        List<SearchKeyword> searchKeywordList = searchKeywordService.top10Keywords();

        ModelAndView mv = new ModelAndView("jsonView");
        mv.addObject("top10KeywordList", searchKeywordList);

        return mv;
    }

    @RequestMapping(value="/search/saveSearchKeyword.json", produces = "application/json", method=RequestMethod.POST)
    @ResponseBody
    public void saveSearchKeyword(Authentication authentication, @RequestParam(value="keyword") String keyword) throws Exception{

        searchKeywordService.searchKeywordSave(authentication, keyword);
    }
}
