package com.example.sesarchingplace.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class SearchKeywordPK implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String keyword;

    public String getUserId(){
        return this.userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getKeyword(){
        return this.keyword;
    }

    public void setKeyword(String keyword){
        this.keyword = keyword;
    }
}
