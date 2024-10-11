package ru.t1.java.transactionservice.utils;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.coyote.BadRequestException;

public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                return new BadRequestException("Bad request");
            case 404:
                return new ClassNotFoundException("Resource not found");
            default:
                return new Exception("Generic error");
        }
    }
}

