package com.demon.eduservice.service;

import com.demon.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-12-21
 */
public interface EduSubjectService extends IService<EduSubject> {

    void AddSubject(MultipartFile file, EduSubjectService eduSubjectService);
}
