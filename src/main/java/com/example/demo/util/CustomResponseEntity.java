package com.example.demo.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatusCode;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;

public class CustomResponseEntity<T> extends HttpEntity<T> {
    private final Object status;

    public CustomResponseEntity(@Nullable T body, CustomHttpStatus status) {
        this(body, (MultiValueMap)null, (CustomHttpStatus)status);
    }

    public CustomResponseEntity(@Nullable T body, @Nullable MultiValueMap<String, String> headers, HttpStatusCode status) {
        this(body, headers, (Object)status);
    }

    public CustomResponseEntity(@Nullable T body, @Nullable MultiValueMap<String, String> headers, int rawStatus) {
        this(body, headers, (Object)rawStatus);
    }

    private CustomResponseEntity(@Nullable T body, @Nullable MultiValueMap<String, String> headers, Object status) {
        super(body, headers);
        Assert.notNull(status, "HttpStatusCode must not be null");
        this.status = status;
    }

}
