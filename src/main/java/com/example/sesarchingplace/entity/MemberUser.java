package com.example.sesarchingplace.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="USER")
public class MemberUser {
    @Id
    private String userId;

    @Column
    private String userPw;

}
