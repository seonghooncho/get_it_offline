package com.selfProject.get_it_offline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileService {

    private final Path rootLocation = Paths.get("upload-dir");

    @Autowired
    private FileRepository fileRepository;

    public FileEntity store(MultipartFile file) throws IOException {
        // 업로드된 파일을 서버에 저장
        String originalFileName = file.getOriginalFilename();
        String storedFileName = UUID.randomUUID().toString() + "_" + originalFileName;
        Path destinationFile = this.rootLocation.resolve(Paths.get(storedFileName)).normalize().toAbsolutePath();

        Files.copy(file.getInputStream(), destinationFile);

        // 파일 정보를 데이터베이스에 저장
        FileEntity fileEntity = new FileEntity(
                originalFileName,
                storedFileName,
                file.getContentType(),
                file.getSize()
        );

        return fileRepository.save(fileEntity);
    }

    public FileEntity getFile(Long fileId) {
        return fileRepository.findById(fileId).orElse(null);
    }
}

