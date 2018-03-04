package com.matrix.cloud.microservice.entity;

import java.util.List;

public class FacetDoc
{
    private long matches;

    private List<GroupDoc> groups;

    public long getMatches()
    {
        return matches;
    }

    public void setMatches( long matches )
    {
        this.matches = matches;
    }

    public List<GroupDoc> getGroups()
    {
        return groups;
    }

    public void setGroups( List<GroupDoc> groups )
    {
        this.groups = groups;
    }

}
