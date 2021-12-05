package com.demon;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result {
    @ApiModelProperty(value = "状态码")
    private Integer Code;

    @ApiModelProperty(value = "返回信息")
    private String Message;

    @ApiModelProperty(value = "是否成功")
    private Boolean Success;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data=new HashMap<String, Object>();

    //私有无参数构造方法
    private Result() {
    }


    //成功方法
    public static Result ok() {
        Result result = new Result();
        result.setCode(ResultCode.Success_code);
        result.setMessage("操作成功");
        result.setSuccess(true);
        return result;
    }

    //失败方法
    public static Result error() {
        Result result = new Result();
        result.setCode(ResultCode.Error_code);
        result.setMessage("操作失败");
        result.setSuccess(false);
        return result;
    }

    public Result Message(String message) {
        this.setMessage(message);
        return this;
    }

    public Result success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }

    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Result data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}
