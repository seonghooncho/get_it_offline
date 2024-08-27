package com.selfProject.get_it_offline.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileID;

    private String originalFileName; // 사용자가 업로드한 원본 파일명
    private String storedFileName;   // 서버에 저장된 파일명 (고유값으로 설정)
    private String fileType;         // 파일 형식 (예: image/jpeg)
    private Long fileSize;           // 파일 크기 (바이트 단위)

    public FileEntity(String originalFileName, String storedFileName, String fileType, Long fileSize) {
        this.originalFileName = originalFileName;
        this.storedFileName = storedFileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }
}
