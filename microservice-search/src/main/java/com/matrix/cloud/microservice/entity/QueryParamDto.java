package com.matrix.cloud.microservice.entity;

import java.util.List;

public class QueryParamDto
{
    private Long start;

    private Long rows;

    private String sort;

    private Long groupLimit;

    private Long groupOffset;

    private String userId;

    private List<String> scope;

    private String keyword;

    private String customerCode;

    private String siteId;

    private String category;

    private String boardId;

    private String orgId;

    private String orgIds;

    private String conversation;

    private String complete;

    private String fromTime;

    private String toTime;

    public Long getStart()
    {
        return start;
    }

    public void setStart( Long start )
    {
        this.start = start;
    }

    public Long getRows()
    {
        return rows;
    }

    public void setRows( Long rows )
    {
        this.rows = rows;
    }

    public String getSort()
    {
        return sort;
    }

    public void setSort( String sort )
    {
        this.sort = sort;
    }

    public Long getGroupLimit()
    {
        return groupLimit;
    }

    public void setGroupLimit( Long groupLimit )
    {
        this.groupLimit = groupLimit;
    }

    public Long getGroupOffset()
    {
        return groupOffset;
    }

    public void setGroupOffset( Long groupOffset )
    {
        this.groupOffset = groupOffset;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId( String userId )
    {
        this.userId = userId;
    }

    public List<String> getScope()
    {
        return scope;
    }

    public void setScope( List<String> scope )
    {
        this.scope = scope;
    }

    public String getKeyword()
    {
        return keyword;
    }

    public void setKeyword( String keyword )
    {
        this.keyword = keyword;
    }

    public String getCustomerCode()
    {
        return customerCode;
    }

    public void setCustomerCode( String customerCode )
    {
        this.customerCode = customerCode;
    }

    public String getSiteId()
    {
        return siteId;
    }

    public void setSiteId( String siteId )
    {
        this.siteId = siteId;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory( String category )
    {
        this.category = category;
    }

    public String getBoardId()
    {
        return boardId;
    }

    public void setBoardId( String boardId )
    {
        this.boardId = boardId;
    }

    public String getOrgId()
    {
        return orgId;
    }

    public void setOrgId( String orgId )
    {
        this.orgId = orgId;
    }

    public String getOrgIds()
    {
        return orgIds;
    }

    public void setOrgIds( String orgIds )
    {
        this.orgIds = orgIds;
    }

    public String getConversation()
    {
        return conversation;
    }

    public void setConversation( String conversation )
    {
        this.conversation = conversation;
    }

    public String getComplete()
    {
        return complete;
    }

    public void setComplete( String complete )
    {
        this.complete = complete;
    }

    public String getFromTime()
    {
        return fromTime;
    }

    public void setFromTime( String fromTime )
    {
        this.fromTime = fromTime;
    }

    public String getToTime()
    {
        return toTime;
    }

    public void setToTime( String toTime )
    {
        this.toTime = toTime;
    }

}
