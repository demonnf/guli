package com.demon.ossservice.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
@Service
public interface OssService {
    public String uploadfile(MultipartFile file) throws FileNotFoundException;
}
