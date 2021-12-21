package com.demon.eduservice.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class SubjectData {
    @ExcelProperty(index = 0)
    public String OneSubjectName;
    @ExcelProperty(index = 1)
    public String TwoSubjectName;
}
