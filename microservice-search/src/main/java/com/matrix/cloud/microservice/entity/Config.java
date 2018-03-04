package com.matrix.cloud.microservice.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config
{
    @Value( "${solrUrl}" )
    private String solrUrl;

    @Value( "${solr.time.wait.max}" )
    private long solrTimeout;

    public String getSolrUrl()
    {
        return solrUrl;
    }

    public void setSolrUrl( String solrUrl )
    {
        this.solrUrl = solrUrl;
    }

    public long getSolrTimeout()
    {
        return solrTimeout;
    }

    public void setSolrTimeout( long solrTimeout )
    {
        this.solrTimeout = solrTimeout;
    }

}
