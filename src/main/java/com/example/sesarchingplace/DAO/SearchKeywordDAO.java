package com.example.sesarchingplace.DAO;

import com.example.sesarchingplace.entity.SearchKeyword;
import com.example.sesarchingplace.entity.SearchKeywordPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SearchKeywordDAO extends JpaRepository<SearchKeyword, SearchKeywordPK>, CrudRepository<SearchKeyword,SearchKeywordPK> {
    public List<SearchKeyword> findSearchKeywordByPk_UserIdOrderByUdtDateDesc(String userId);
}
