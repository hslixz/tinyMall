package com.hslixz.mall.common.api;

/**
 * @author l
 * @version 0.1
 * @since 0.1
 */
public enum ResultCode implements IErrorCode {
    /** 操作成功 **/
    SUCCESS(200L, "操作成功"),
    /** 操作失败 **/
    FAILED(500L, "操作失败"),
    /** 参数检验失败 **/
    VALIDATA_FAILED(404L, "参数校验失败"),
    /** 未登录或token超时 **/
    UNAUTHORIZED(401L, "暂未登录或token已过期"),
    /** 无操作权限 **/
    FORBIDDEN(403L, "没有相关权限");

    private Long code;
    private String message;

    ResultCode(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
