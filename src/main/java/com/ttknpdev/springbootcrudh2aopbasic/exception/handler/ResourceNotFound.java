package com.ttknpdev.springbootcrudh2aopbasic.exception.handler;

public class ResourceNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ResourceNotFound(String details){
        super(details);
    }
}
