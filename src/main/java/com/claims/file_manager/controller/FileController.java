package com.claims.file_manager.controller;

import com.claims.file_manager.entity.FileEntity;
import com.claims.file_manager.response.ResponseMessage;
import com.claims.file_manager.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@AllArgsConstructor
@CrossOrigin("*")
public class FileController {

 private FileService fileService;

     @PostMapping("/upload/{content_type_file}/{id_claim}")
     public ResponseEntity<ResponseMessage> uploadFile(@RequestBody MultipartFile file,
                                                       @PathVariable String content_type_file,
                                                       @PathVariable Integer id_claim)throws IOException {

         fileService.files(file, content_type_file, id_claim);
         return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Archivo subido con +exito"));
     }

     @GetMapping("/files/{id}")
     public ResponseEntity<byte[]> getFile(@PathVariable Integer id)throws FileNotFoundException{

         FileEntity fileEntity = fileService.getFile(id).get();
         return ResponseEntity.status(HttpStatus.OK)
                 .header(HttpHeaders.CONTENT_TYPE, fileEntity.getType_file())
                 .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName()+"\"")
                 .body(fileEntity.getData());
     }

    @GetMapping("files/{claim_id}/{type_content}")
    public ResponseEntity<?>getFilesByClaimidAndTypeContent(@PathVariable Integer claim_id, @PathVariable String type_content){
            List<FileEntity> files = fileService.getFilesByClaimIdAndTypeContent(claim_id, type_content);
            return ResponseEntity.ok(files);
     }

}
