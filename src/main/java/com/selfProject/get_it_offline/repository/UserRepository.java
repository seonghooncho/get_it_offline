package com.selfProject.get_it_offline.repository;

import com.selfProject.get_it_offline.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // 이메일로 회원 정보 조회 (select * from member_table where member_email=?)
    Optional<UserEntity> findByMemberEmail(String memberEmail);
}