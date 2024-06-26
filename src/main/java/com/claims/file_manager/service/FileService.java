package com.claims.file_manager.service;

import com.claims.file_manager.entity.FileEntity;
import com.claims.file_manager.response.ResponseFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FileService {
    //permite almacenar o cargar archivos a la BD
    FileEntity files(MultipartFile file, String content_type_file, Integer claim_id) throws IOException;

    Optional<FileEntity> getFile(Integer id) throws FileNotFoundException;

    List<FileEntity> getFilesByClaimIdAndTypeContent(Integer claim_id, String type_content);
}
