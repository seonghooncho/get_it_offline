package com.selfProject.get_it_offline.service;

import com.selfProject.get_it_offline.dto.UserDTO;
import com.selfProject.get_it_offline.entity.UserEntity;
import com.selfProject.get_it_offline.repository.UserRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor//UserRepository에 값 넣어줌
public class UserService {
    private final UserRepository UserRepository;
    public void save(UserDTO UserDTO) {
        // 1. dto -> entity 변환
        // 2. repository의 save 메서드 호출
        UserEntity UserEntity = UserEntity.toUserEntity(UserDTO);
        UserRepository.save(UserEntity);
        // repository의 save메서드 호출 (조건. entity객체를 넘겨줘야 함)
    }

    public UserDTO login(UserDTO UserDTO) {
        /*
            1. 회원이 입력한 이메일로 DB에서 조회를 함
            2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
         */
        Optional<UserEntity> byUserEmail = UserRepository.findByUserEmail(UserDTO.getUserEmail());
        if (byUserEmail.isPresent()) {
            // 조회 결과가 있다(해당 이메일을 가진 회원 정보가 있다)
            UserEntity UserEntity = byUserEmail.get();
            if (UserEntity.getUserPassword().equals(UserDTO.getUserPassword())) {
                // 비밀번호 일치
                // entity -> dto 변환 후 리턴
                UserDTO dto = UserDTO.toUserDTO(UserEntity);
                return dto;
            } else {
                // 비밀번호 불일치(로그인실패)
                return null;
            }
        } else {
            // 조회 결과가 없다(해당 이메일을 가진 회원이 없다)
            return null;
        }
    }

    public List<UserDTO> findAll() {
        List<UserEntity> UserEntityList = UserRepository.findAll();
        List<UserDTO> UserDTOList = new ArrayList<>();
        for (UserEntity UserEntity: UserEntityList) {
            UserDTOList.add(UserDTO.toUserDTO(UserEntity));
        }
        return UserDTOList;
    }

    public UserDTO findById(Long id) {
        Optional<UserEntity> optionalUserEntity = UserRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            return UserDTO.toUserDTO(optionalUserEntity.get());
        } else {
            return null;
        }

    }

    public UserDTO updateForm(String myEmail) {
        Optional<UserEntity> optionalUserEntity = UserRepository.findByUserEmail(myEmail);
        if (optionalUserEntity.isPresent()) {
            return UserDTO.toUserDTO(optionalUserEntity.get());
        } else {
            return null;
        }
    }

    public void update(UserDTO UserDTO) {
        UserRepository.save(UserEntity.toUpdateUserEntity(UserDTO));
    }

    public void deleteById(Long id) {
        UserRepository.deleteById(id);
    }

    public String emailCheck(String UserEmail) {
        Optional<UserEntity> byUserEmail = UserRepository.findByUserEmail(UserEmail);
        if (byUserEmail.isPresent()) {
            // 조회결과가 있다 -> 사용할 수 없다.
            return null;
        } else {
            // 조회결과가 없다 -> 사용할 수 있다.
            return "ok";
        }
    }
}