package com.matrix.cloud.microservice.entity;

public class QueryParam
{
    private String keyword;

    private String queyrParam;

    private String filterParam;

    private String sortParam;

    private String sortOrder;

    private String groupField;

    private int start = 0;

    private int rows = 10;

    public String getKeyword()
    {
        return keyword;
    }

    public void setKeyword( String keyword )
    {
        this.keyword = keyword;
    }

    public String getQueyrParam()
    {
        return queyrParam;
    }

    public void setQueyrParam( String queyrParam )
    {
        this.queyrParam = queyrParam;
    }

    public String getFilterParam()
    {
        return filterParam;
    }

    public void setFilterParam( String filterParam )
    {
        this.filterParam = filterParam;
    }

    public String getSortParam()
    {
        return sortParam;
    }

    public void setSortParam( String sortParam )
    {
        this.sortParam = sortParam;
    }

    public int getStart()
    {
        return start;
    }

    public void setStart( int start )
    {
        this.start = start;
    }

    public int getRows()
    {
        return rows;
    }

    public void setRows( int rows )
    {
        this.rows = rows;
    }

    public String getSortOrder()
    {
        return sortOrder;
    }

    public void setSortOrder( String sortOrder )
    {
        this.sortOrder = sortOrder;
    }

    public String getGroupField()
    {
        return groupField;
    }

    public void setGroupField( String groupField )
    {
        this.groupField = groupField;
    }

}
