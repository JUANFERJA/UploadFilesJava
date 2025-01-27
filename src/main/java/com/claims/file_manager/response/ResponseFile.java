package com.claims.file_manager.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseFile {

    private String name;
    private String url;
    private String type;
    private long size;
}
