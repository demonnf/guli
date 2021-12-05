package com.demon.eduservice.entity.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Teacher查询对象", description = "讲师查询对象封装")
public class TeacherQuery {
    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;


    @ApiModelProperty(value = "创建时间")
    private String begin;

    @ApiModelProperty(value = "结束时间")
    private String end;

}
