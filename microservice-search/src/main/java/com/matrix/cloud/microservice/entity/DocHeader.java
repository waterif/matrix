package com.matrix.cloud.microservice.entity;

import java.util.HashMap;
import java.util.Map;

public class DocHeader
{
    private int status;

    private long QTime;

    private Map<String, String> params;

    public int getStatus()
    {
        return status;
    }

    public void setStatus( int status )
    {
        this.status = status;
    }

    public long getQTime()
    {
        return QTime;
    }

    public void setQTime( long qTime )
    {
        QTime = qTime;
    }

    public Map<String, String> getParams()
    {
        if ( null == params)
        {
            return new HashMap<String, String>();
        }
        
        return params;
    }

    public void setParams( Map<String, String> params )
    {
        this.params = params;
    }

}
