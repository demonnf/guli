package com.demon.eduservice.controller;

import com.demon.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
@Api("登陆管理")
@CrossOrigin
@RestController
@RequestMapping("/eduservice/Edulogin")
public class EduLoginController {
    @ApiOperation("登陆")
    @PostMapping("/login")
    public Result login() {
        return Result.ok().data("token", "adminUser");
    }
    @ApiOperation("获得info信息")
    @GetMapping("/getinfo")
    public Result getinfo() {
        return Result.ok().data("roles", "adminUser").data("name", "name").data("avatar", "admin");
    }
}
