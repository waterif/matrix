package com.matrix.cloud.microservice.entity;

import org.springframework.stereotype.Component;

@Component
public class ConfigDemo
{
    private String errorCode;

    private String errorDesc;

    private String password;

    public String getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode( String errorCode )
    {
        this.errorCode = errorCode;
    }

    public String getErrorDesc()
    {
        return errorDesc;
    }

    public void setErrorDesc( String errorDesc )
    {
        this.errorDesc = errorDesc;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

}
