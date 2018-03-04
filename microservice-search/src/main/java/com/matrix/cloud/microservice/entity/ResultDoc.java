package com.matrix.cloud.microservice.entity;

import java.util.Map;

public class ResultDoc
{
    private DocHeader responseHeader;

    private Map<String, FacetDoc> grouped;

    public DocHeader getResponseHeader()
    {
        return responseHeader;
    }

    public void setResponseHeader( DocHeader responseHeader )
    {
        this.responseHeader = responseHeader;
    }

    public Map<String, FacetDoc> getGrouped()
    {
        return grouped;
    }

    public void setGrouped( Map<String, FacetDoc> grouped )
    {
        this.grouped = grouped;
    }

}
