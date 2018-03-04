package com.matrix.cloud.microservice.entity;

public class GroupDoc
{
    private int groupValue;

    private DocBody doclist;

    public int getGroupValue()
    {
        return groupValue;
    }

    public void setGroupValue( int groupValue )
    {
        this.groupValue = groupValue;
    }

    public DocBody getDoclist()
    {
        return doclist;
    }

    public void setDoclist( DocBody doclist )
    {
        this.doclist = doclist;
    }

}
