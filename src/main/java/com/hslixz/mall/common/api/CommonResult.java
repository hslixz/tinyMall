package com.hslixz.mall.common.api;

/**
 * @author l
 * @description 通用返回对象
 * @time 2019/6/26 11:05
 */
public class CommonResult<T> {
    private Long code;
    private String message;
    private T data;

    public CommonResult() {
    }

    public CommonResult(Long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 参数校验失败结果
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> validFailed() {
        return failed(ResultCode.VALIDATA_FAILED);
    }

    /**
     * 参数校验失败结果
     * @param message
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> validFailed(String message) {
        return new CommonResult<>(ResultCode.VALIDATA_FAILED.getCode(), message, null);
    }

    /**
     * 未登录失败结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> unauthorizedFailed(T data) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权失败结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> forbiddenFaile(T data) {
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
