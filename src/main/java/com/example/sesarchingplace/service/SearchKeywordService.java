package com.example.sesarchingplace.service;

import com.example.sesarchingplace.DAO.SearchKeywordDAO;
import com.example.sesarchingplace.DAO.SearchKeywordRepository;
import com.example.sesarchingplace.entity.SearchKeyword;
import com.example.sesarchingplace.entity.SearchKeywordPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchKeywordService {

    @Autowired
    SearchKeywordDAO searchKeywordDAO;

    @Autowired
    SearchKeywordRepository searchKeywordRepository;

    // 나의 검색 히스토리 조회
    public List<SearchKeyword> mySearchHistoryList(Authentication authentication){
        List<SearchKeyword> searchKeywordList = searchKeywordDAO.findSearchKeywordByPk_UserIdOrderByUdtDateDesc(authentication.getName());
        return searchKeywordList;
    }

    // 인기 키워드 목록 조회
    public List<SearchKeyword> top10Keywords(){
        List<SearchKeyword> searchKeywordList = searchKeywordRepository.getTop10Keywords();
        return searchKeywordList;
    }

    public void searchKeywordSave(Authentication authentication, String keyword){
        SearchKeywordPK pk = new SearchKeywordPK();
        pk.setUserId(authentication.getName());
        pk.setKeyword(keyword);

        Optional<SearchKeyword> searchKeyword = searchKeywordDAO.findById(pk);

        SearchKeyword nowSearchKeyword = new SearchKeyword();
        nowSearchKeyword.setKeyword(keyword);
        nowSearchKeyword.setUserId(authentication.getName());

        if(searchKeyword.isPresent()){  // 검색이력이 존재하면 검색 수 +1
            nowSearchKeyword.setSearchCnt(searchKeyword.get().getSearchCnt()+1);
        }else{  // 검색 이력 존재하지 않으면 검색 수 1로 insert
            nowSearchKeyword.setSearchCnt(1);
        }

        searchKeywordDAO.save(nowSearchKeyword);
    }

}
