package com.demon.eduservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demon.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demon.eduservice.entity.VO.TeacherQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-11-16
 */
@Service
public interface EduTeacherService extends IService<EduTeacher> {

 }
