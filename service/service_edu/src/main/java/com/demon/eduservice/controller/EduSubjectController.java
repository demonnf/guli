package com.demon.eduservice.controller;


import com.demon.Result;
import com.demon.eduservice.service.EduSubjectService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-12-21
 */
@Api(description = "课程分类")
@CrossOrigin
@RestController
@RequestMapping("/eduservice/edu-subject")
public class EduSubjectController {
    @Autowired
    EduSubjectService eduSubjectService;
   @PostMapping("/AddSubject")
    public Result AddSubject(@RequestBody MultipartFile file){
       eduSubjectService.AddSubject(file,eduSubjectService);
       return Result.ok();
   }
}

