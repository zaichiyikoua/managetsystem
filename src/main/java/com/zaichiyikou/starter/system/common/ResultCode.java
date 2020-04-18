package com.zaichiyikou.starter.system.common;

/*
 * 枚举API
 */

public enum ResultCode implements MyErrorCode{
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "没有认证"),
    FORBIDDEN(403, "没有相关权限");
    
    private long code;
    private String message;
    
    
    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Long getCode() {
        // TODO Auto-generated method stub
        return code;
    }

    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        return message;
    }

}
