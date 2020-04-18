package com.zaichiyikou.starter.system.common;

import lombok.Data;

/*
 * 通用返回对象
 */
@Data
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    // 构造器
    protected CommonResult() {
        super();
    }

    protected CommonResult(Long code, String message, T data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 静态方法*********************开始

    /*
     * 成功返回
     * 
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /*
     * 成功返回
     * 
     * @param data 获取的数据
     * 
     * @param message 成功信息
     * 
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /*
     * 失败返回
     * 
     * @param errorCode 错误码
     * 
     */
    public static <T> CommonResult<T> failed(MyErrorCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /*
     * 失败返回
     * 
     * @param errorCode 错误码
     * 
     * @param message 错误信息
     * 
     */
    public static <T> CommonResult<T> failed(MyErrorCode errorCode, String message) {
        return new CommonResult<T>(errorCode.getCode(), message, null);
    }

    /*
     * 失败返回
     * 
     * @param message 错误信息
     * 
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /*
     * 失败返回
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /*
     * 参数验证失败
     */
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /*
     * 参数验证失败
     * 
     * @param message 错误信息
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /*
     * 未登录
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /*
     * 未授权
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }
    // 静态方法*********************结束
}
