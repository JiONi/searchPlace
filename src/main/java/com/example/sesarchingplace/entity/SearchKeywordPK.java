package com.example.sesarchingplace.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
@Data
public class SearchKeywordPK implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String keyword;
}
