package com.matrix.cloud.microservice.entity;

import java.util.List;

import org.apache.solr.common.SolrDocument;

public class DocBody
{
    private long start;

    private long numFound;

    private List<SolrDocument> docs;

    public long getStart()
    {
        return start;
    }

    public void setStart( long start )
    {
        this.start = start;
    }

    public long getNumFound()
    {
        return numFound;
    }

    public void setNumFound( long numFound )
    {
        this.numFound = numFound;
    }

    public List<SolrDocument> getDocs()
    {
        return docs;
    }

    public void setDocs( List<SolrDocument> docs )
    {
        this.docs = docs;
    }

}
