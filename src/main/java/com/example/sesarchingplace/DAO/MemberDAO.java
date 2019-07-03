package com.example.sesarchingplace.DAO;

import com.example.sesarchingplace.entity.MemberUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MemberDAO extends JpaRepository<MemberUser,String>,CrudRepository<MemberUser,String> {
}
