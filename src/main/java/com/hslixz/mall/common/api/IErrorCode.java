package com.hslixz.mall.common.api;

/**
 * 封装错误信息接口
 * @author l
 * @version 0.1
 * @since 0.1
 */
public interface IErrorCode {
    /**
     * 返回错误码
     * @return 错误码
     */
    Long getCode();

    /**
     * 返回错误信息
     * @return 错误信息
     */
    String getMessage();
}
