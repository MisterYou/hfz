package com.hfz.userservice.exception;

/**
 * @author lwq
 * @date 2018/4/24
 * @comment 简单的消息提示异常
 */
public class MessageException extends RuntimeException {

    public MessageException() {
        super();
    }

    public MessageException(String message) {
        super(message);
    }

}
