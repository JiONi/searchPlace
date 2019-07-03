package com.example.sesarchingplace.entity;

import com.example.sesarchingplace.config.LocalDateTimeAttributeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="SEARCH_KEYWORD")
public class SearchKeyword {

    @EmbeddedId
    private SearchKeywordPK pk = new SearchKeywordPK();

    // 검색 일시
    @Column(nullable = false)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime udtDate = LocalDateTime.now();

    @Column(nullable = false)
    private int searchCnt;

    public String getUserId(){
        return pk.getUserId();
    }
    public void setUserId(String userId){
        pk.setUserId(userId);
    }

    public String getKeyword(){
        return pk.getKeyword();
    }
    public void setKeyword(String keyword){
        pk.setKeyword(keyword);
    }

    public LocalDateTime getUdtDate(){
        return this.udtDate;
    }

    public int getSearchCnt(){
        return this.searchCnt;
    }
    public void setSearchCnt(int searchCnt){
        this.searchCnt = searchCnt;
    }
}
