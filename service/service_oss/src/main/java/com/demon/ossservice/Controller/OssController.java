package com.demon.ossservice.Controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.demon.Result;
import com.demon.ossservice.Service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/OssService")
@CrossOrigin
@Api("OSS传输文件接口")
public class OssController {
    @Autowired
    private OssService ossService;

    @ApiOperation("OSS上传文件")
    @PostMapping("uploadfile")
    public Result uploadfiles(@RequestParam MultipartFile file) throws FileNotFoundException {
        String url = ossService.uploadfile(file);
        return Result.ok().data("url",url);

    }
}
