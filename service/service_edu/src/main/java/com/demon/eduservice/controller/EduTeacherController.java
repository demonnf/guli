package com.demon.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demon.Result;
import com.demon.eduservice.entity.EduTeacher;
import com.demon.eduservice.entity.VO.TeacherQuery;
import com.demon.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-11-16
 */
@CrossOrigin
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {
    @Autowired
    EduTeacherService eduTeacherService;

    /*查询所有*/
    @ApiOperation("查询所有讲师")
    @GetMapping("findAll")
    public Result findAll() {
        List<EduTeacher> list = eduTeacherService.list(null);
        return Result.ok().data("item", list);
    }

    /*逻辑删除*/
    @ApiOperation("根据ID删除讲师")
    @DeleteMapping("{id}")
    public Result deletebyid(@PathVariable Integer id) {
        boolean boo = eduTeacherService.removeById(id);
        if (boo) {
            return Result.ok();
        } else {
            return Result.error();

        }

    }

    @ApiOperation("查询教师分页")
    @ResponseBody
    @GetMapping("pageteacher/{page}/{limit}")
    public Result getTeacherpageList(@PathVariable Integer page, @PathVariable Integer limit) {
        Page<EduTeacher> pages = new Page<EduTeacher>(page, limit);
        eduTeacherService.page(pages, null);
        long total = pages.getTotal();
        List<EduTeacher> records = pages.getRecords();
        return Result.ok().data("total", total).data("teacherlist", records);
    }

    @ApiOperation("根据讲师条件查询")
    @PostMapping("pageTeacherCondition/{page}/{limit}")
    public Result pageTeacherCondition(
            @PathVariable Integer page, @PathVariable Integer limit, @RequestBody(required = false) TeacherQuery teacherQuery
    ) {
        Page<EduTeacher> pages = new Page<EduTeacher>(page, limit);
        QueryWrapper queryWrapper = new QueryWrapper();

        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }
        if (!(level == null)) {
            queryWrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("gmt_create", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("gmt_create", end);
        }
        eduTeacherService.page(pages, queryWrapper);
        List records = pages.getRecords();
        long total = pages.getTotal();
        return Result.ok().data("tatol", total).data("teacherlist", records);
    }

    @ApiOperation("添加讲师")
    @PostMapping("addteacher")
    public Result addTeacher(@RequestBody(required = false) EduTeacher eduTeacher) {
        boolean save = eduTeacherService.save(eduTeacher);
        if (save) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    @ApiOperation("根据ID获得讲师")
    @GetMapping("findteacher/{id}")
    public Result findTeacherbyid(@PathVariable Integer id) {
        EduTeacher byId = eduTeacherService.getById(id);
        return Result.ok().data("item", byId);

    }

    @ApiOperation("更新讲师")
    @PostMapping("updateteacher")
    public Result updateTeacher(@RequestBody(required = false) EduTeacher eduTeacher) {
        boolean update = eduTeacherService.update(eduTeacher, null);
        if (update) {
            return Result.ok();
        } else {
            return Result.error();
        }

    }
}

