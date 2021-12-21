package com.demon.eduservice.Util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.demon.eduservice.entity.SubjectData;
import com.demon.eduservice.service.EduSubjectService;

public class SubjectExcelListen extends AnalysisEventListener<SubjectData>{
EduSubjectService eduSubjectService;
    public SubjectExcelListen(){};
    public SubjectExcelListen(EduSubjectService eduSubjectService) {
        this.eduSubjectService=eduSubjectService;
    }

    @Override
    //一行一行读取文件内容
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
