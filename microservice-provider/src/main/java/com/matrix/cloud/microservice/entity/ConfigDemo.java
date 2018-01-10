package com.matrix.cloud.microservice.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigDemo
{
    @Value( "${errorCode}" )
    private String errorCode;

    @Value( "${errorDesc}" )
    private String errorDesc;

    @Value( "${password}" )
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
