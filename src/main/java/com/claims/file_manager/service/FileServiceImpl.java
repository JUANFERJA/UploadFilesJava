package com.claims.file_manager.service;

import com.claims.file_manager.entity.FileEntity;
import com.claims.file_manager.repository.FileRepository;
import com.claims.file_manager.response.ResponseFile;
import jakarta.servlet.Servlet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FileServiceImpl implements FileService{

    private FileRepository fileRepository;
    @Override
    public FileEntity files(MultipartFile file, String type_content_file, Integer cliam_id) throws IOException {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileEntity fileEntity = FileEntity.builder()
                .name(fileName)
                .type_file(file.getContentType())
                .data(file.getBytes())
                .content_file_type(type_content_file)
                .claim_id(cliam_id)
                .build();
        return fileRepository.save(fileEntity);
    }



    @Override
    public Optional<FileEntity> getFile(Integer id) throws FileNotFoundException {
        Optional<FileEntity> file = fileRepository.findById(id);
        if(file.isPresent()){
            return file;
        }
        throw new FileNotFoundException();
    }

    @Override
    public List<FileEntity> getFilesByClaimIdAndTypeContent(Integer claim_id, String type_content) {
        return fileRepository.getFilesByClaimIdAndTypeContetn(claim_id, type_content);
    }


}
