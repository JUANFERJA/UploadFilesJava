package com.claims.file_manager.repository;

import com.claims.file_manager.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Integer> {

    @Query("select c from FileEntity c where c.claim_id=:claim_id and c.content_file_type=:type_content")
    public List<FileEntity> getFilesByClaimIdAndTypeContetn(Integer claim_id, String type_content);
}
