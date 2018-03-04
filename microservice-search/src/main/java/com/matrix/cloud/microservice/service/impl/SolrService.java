package com.matrix.cloud.microservice.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrix.cloud.microservice.entity.Config;
import com.matrix.cloud.microservice.entity.DocBody;
import com.matrix.cloud.microservice.entity.QueryParam;
import com.matrix.cloud.microservice.service.IndexerService;

/**
 * @Description: 调用solr服务
 * 
 * @author matrix
 * @date 2018-02-27 17:31:36
 *
 * @Copyright: 2018 www.matrix.com Inc. All rights reserved.
 */
@Service
public class SolrService implements IndexerService
{

    private static Logger logger = LoggerFactory.getLogger( SolrService.class );
    
    @Autowired
    private Config config;

    // 定义http的solr服务
    private HttpSolrServer httpSolrServer;

    public SolrService()
    {
    }
    
    public SolrService( String solrUrl )
    {
        httpSolrServer = new HttpSolrServer( solrUrl );
    }

    @Override
    public boolean addDoc( String docId, Map<String, String> docFields )
    {
        SolrInputDocument document = new SolrInputDocument();

        document.addField( "solr_docid", docId );

        if ( null != docFields && !docFields.isEmpty() )
        {
            for ( Map.Entry<String, String> entry : docFields.entrySet() )
            {
                document.addField( entry.getKey(), entry.getValue() );
            }
        }

        try
        {
            UpdateResponse response = httpSolrServer.add( document );

            httpSolrServer.commit();

            return true;
        }
        catch ( SolrServerException e )
        {
            logger.error( e.getMessage(), e );
        }
        catch ( IOException e )
        {
            logger.error( e.getMessage(), e );
        }
        return false;
    }

    @Override
    public boolean deleteDoc( String docId )
    {
        try
        {
            httpSolrServer.deleteById( docId );

            httpSolrServer.commit( true, true );

            return true;
        }
        catch ( SolrServerException e )
        {
            logger.error( e.getMessage(), e );
        }
        catch ( IOException e )
        {
            logger.error( e.getMessage(), e );
        }

        return false;
    }

    @Override
    public boolean updateDoc( String docId, Map<String, String> docFields )
    {
        SolrQuery solrQuery = new SolrQuery(); // 构造搜索条件

        solrQuery.setQuery( "solr_docid:" + docId );

        QueryResponse res = null;

        try
        {
            res = httpSolrServer.query( solrQuery );
        }
        catch ( SolrServerException e )
        {
            logger.error( e.getMessage(), e );
        }

        Map<String, String> doc = new HashMap<String, String>();

        if ( res != null )
        {
            Map<String, String> docResult = res.getExplainMap();

            if ( null != docResult )
            {
                doc.putAll( docResult );

                if ( null != docFields )
                {
                    doc.putAll( docFields );
                }
            }
        }

        return addDoc( docId, doc );

    }

    @Override
    public DocBody searchDoc( QueryParam queryParam )
    {
        SolrQuery solrQuery = new SolrQuery(); // 构造搜索条件
        
        httpSolrServer = new HttpSolrServer( config.getSolrUrl() );
        
        if ( null != queryParam )
        {
            solrQuery.setQuery( queryParam.getQueyrParam() );
        }
        else
        {
            solrQuery.setQuery( "*:*" );
        }

        if ( null != queryParam.getSortParam() )
        {
            solrQuery.setSort( queryParam.getSortParam(), ORDER.valueOf( queryParam.getSortOrder() ) );
        }

        if ( null != queryParam.getFilterParam() )
        {
            solrQuery.setFilterQueries( queryParam.getFilterParam() );
        }

        if ( null != queryParam.getGroupField() )
        {
            solrQuery.addFacetField( queryParam.getGroupField() );
        }

        solrQuery.setStart( queryParam.getStart() );
        solrQuery.setRows( queryParam.getRows() );

        DocBody docBody = null;

        try
        {
            QueryResponse res = httpSolrServer.query( solrQuery );

            SolrDocumentList docList = res.getResults();

            if ( null != docList )
            {
                docBody = new DocBody();

                docBody.setDocs( docList );
                docBody.setStart( docList.getStart() );
                docBody.setNumFound( docList.getNumFound() );
            }
        }
        catch ( SolrServerException e )
        {
            logger.error( e.getMessage(), e );
        }

        return docBody;
    }

}
