package com.example.sesarchingplace.DAO;

import com.example.sesarchingplace.entity.SearchKeyword;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SearchKeywordRepository{

    @PersistenceContext
    private EntityManager em;

    public List<SearchKeyword> getTop10Keywords(){
        List<SearchKeyword> searchKeywordList = em.createNativeQuery("SELECT a.* FROM(SELECT SUM(sk.SEARCH_CNT) AS SEARCH_CNT , sk.KEYWORD FROM SEARCH_KEYWORD sk GROUP BY sk.KEYWORD ORDER BY SEARCH_CNT DESC) a WHERE ROWNUM < 11").getResultList();
        return searchKeywordList;
    }
}
