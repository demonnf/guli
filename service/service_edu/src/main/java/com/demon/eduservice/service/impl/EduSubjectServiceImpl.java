package com.demon.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.demon.eduservice.Util.SubjectExcelListen;
import com.demon.eduservice.entity.EduSubject;
import com.demon.eduservice.entity.SubjectData;
import com.demon.eduservice.mapper.EduSubjectMapper;
import com.demon.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-12-21
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void AddSubject(MultipartFile file, EduSubjectService eduSubjectService) {
        try {
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, SubjectData.class,new SubjectExcelListen(eduSubjectService)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
