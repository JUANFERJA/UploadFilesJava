package com.claims.file_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Table(name="files")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  name;
    private String  type_file;
    private Integer claim_id;
    private String  content_file_type;
    @Lob
    @Column(length = 65555)
    private byte[] data;

}
