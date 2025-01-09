package com.tiffin.foodDelivery.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tiffin.foodDelivery.exceptions.common.BaseException;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemNotFoundException extends BaseException {
    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(String message, String errorCode) {
        super(message, errorCode);
    }

    public ItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemNotFoundException(String message, Throwable cause, String errorCode) {
        super(message, cause, errorCode);
    }
}
