package com.example.sesarchingplace.entity;

import com.example.sesarchingplace.config.LocalDateTimeAttributeConverter;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
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

}
