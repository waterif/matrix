package com.matrix.cloud.microservice.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrix.cloud.microservice.entity.Config;
import com.matrix.cloud.microservice.entity.DocBody;
import com.matrix.cloud.microservice.entity.DocHeader;
import com.matrix.cloud.microservice.entity.FacetDoc;
import com.matrix.cloud.microservice.entity.GroupDoc;
import com.matrix.cloud.microservice.entity.QueryParam;
import com.matrix.cloud.microservice.entity.QueryParamDto;
import com.matrix.cloud.microservice.entity.ResultDoc;
import com.matrix.cloud.microservice.service.IndexerService;
import com.matrix.cloud.microservice.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService
{
    
    private static Logger logger = LoggerFactory.getLogger( SearchServiceImpl.class );

    @Autowired
    private IndexerService solrService;
    
    @Autowired
    private Config config;
    
    @Override
    public ResultDoc search( QueryParamDto qDto )
    {
        ResultDoc resultDoc = new ResultDoc();
        
        DocHeader responseHeader = new DocHeader();
        resultDoc.setResponseHeader( responseHeader );
        
        responseHeader.setStatus( 0 );
        
        long currentStart = System.currentTimeMillis();
        
        Map<String, String> params = responseHeader.getParams();
        
        responseHeader.setParams( params );
        
        params.put( "user_id", qDto.getUserId() );
        params.put( "customer_code", qDto.getCustomerCode() );
        params.put( "keyword", qDto.getKeyword() );
        
        Map<String, FacetDoc> grouped = new HashMap<String, FacetDoc>();

        resultDoc.setGrouped( grouped );

        FacetDoc facetDoc = new FacetDoc();

        List<GroupDoc> groups = new ArrayList<GroupDoc>();

        facetDoc.setGroups( groups );

        if ( null != qDto )
        {
            List<String> scope = qDto.getScope();

            if ( null != scope && !scope.isEmpty() )
            {
                List<Future<GroupDoc>> futures = new ArrayList<Future<GroupDoc>>();
                ExecutorService executor = Executors.newCachedThreadPool();

                for ( String connection : scope )
                {
                    Future<GroupDoc> future = executor.submit( new SearchTask( qDto, connection ) );

                    futures.add( future );
                }
                
                long current1 = System.currentTimeMillis();

                for ( Future<GroupDoc> future : futures )
                {
                    try
                    {
                        long current2 = System.currentTimeMillis();

                        long limit = config.getSolrTimeout() * 1000 + current1 - current2;

                        limit = limit > 0 ? limit : 1;

                        GroupDoc groupDoc = future.get( limit, TimeUnit.MILLISECONDS );

                        facetDoc.setMatches( facetDoc.getMatches() + groupDoc.getDoclist().getNumFound() );

                        groups.add( groupDoc );
                    }
                    catch ( InterruptedException e )
                    {
                        logger.error( e.getMessage(), e );
                    }
                    catch ( ExecutionException e )
                    {
                        logger.error( e.getMessage(), e );
                    }
                    catch ( TimeoutException e )
                    {
                        logger.error( e.getMessage(), e );
                    }
                }
            }
        }

        grouped.put( "indexDoctype_ID", facetDoc );
        
        responseHeader.setQTime( System.currentTimeMillis() - currentStart );

        return resultDoc;
    }
    
    private class SearchTask implements Callable<GroupDoc>
    {

        private QueryParamDto qDto;

        private String scope;

        SearchTask( QueryParamDto qDto, String scope )
        {
            this.qDto = qDto;
            this.scope = scope;
        }

        @Override
        public GroupDoc call() throws Exception
        {
            if ( "1".equals( scope ) )
            {
                return search1( qDto );
            }
            else if ( "3".equals( scope ) )
            {
                return search3( qDto );
            }
            else if ( "6".equals( scope ) )
            {
                return search6( qDto );
            }

            return null;
        }

    }
    
    /**
     * 联系人搜索（企业通讯录搜索） scope=1
     * @param qDto
     * @return
     */
    private GroupDoc search1( QueryParamDto qDto )
    {
        QueryParam queryParam = new QueryParam();

        StringBuffer sb = new StringBuffer();
        sb.append( "indexDoctype_ID:1" )
            .append( " AND customercode:" ).append( qDto.getCustomerCode() )
            .append( " AND user_status:1" )
            .append( " AND (" )
            .append( " text:" ).append( qDto.getKeyword() ).append( "~" ).append( qDto.getKeyword().length() )
            .append( " OR text:" ).append( qDto.getKeyword() )
            .append( analysisKeyWord( qDto.getKeyword() ) )
            .append( ")" );

        queryParam.setQueyrParam( sb.toString() );
        queryParam.setFilterParam( "customercode:" + qDto.getCustomerCode() );

        DocBody docBody = solrService.searchDoc( queryParam );

        GroupDoc groupDoc = new GroupDoc();
        groupDoc.setGroupValue( 1 );
        groupDoc.setDoclist( docBody );

        return groupDoc;
    }
    
    /**
     * 消息搜索 scope=3
     * @param qDto
     * @return
     */
    private GroupDoc search3( QueryParamDto qDto )
    {
        QueryParam queryParam = new QueryParam();
        
        StringBuffer sb = new StringBuffer();
        sb.append( "indexDoctype_ID:3" )
        .append( " AND ( appid:1 OR appid:7 )" )
        .append( " AND text:" ).append( qDto.getKeyword() )
        .append( " AND (user_id:" ).append( qDto.getUserId() )
        .append( " OR to_user_id:" ).append( qDto.getUserId() )
        .append( " OR group_member_ids:" ).append( qDto.getUserId() )
        .append( " OR group_members:" ).append( qDto.getUserId() )
        .append( ")" );
        
        queryParam.setQueyrParam( sb.toString() );
        queryParam.setFilterParam( "customercode:" + qDto.getCustomerCode() );
        
        DocBody docBody = solrService.searchDoc( queryParam );
        
        GroupDoc groupDoc = new GroupDoc();
        groupDoc.setGroupValue( 3 );
        groupDoc.setDoclist( docBody );
        
        return groupDoc;
    }
    
    /**
     * 文件名搜索 scope=6
     * @param qDto
     * @return
     */
    private GroupDoc search6( QueryParamDto qDto )
    {
        QueryParam queryParam = new QueryParam();
        
        StringBuffer sb = new StringBuffer();
        sb.append( "indexDoctype_ID:3" )
        .append( " AND ( appid:1 OR appid:7 )" )
        .append( " AND text:" ).append( qDto.getKeyword() )
        .append( " AND (user_id:" ).append( qDto.getUserId() )
        .append( " OR to_user_id:" ).append( qDto.getUserId() )
        .append( " OR group_member_ids:" ).append( qDto.getUserId() )
        .append( " OR group_members:" ).append( qDto.getUserId() )
        .append( ")" );
        
        queryParam.setQueyrParam( sb.toString() );
        queryParam.setFilterParam( "customercode:" + qDto.getCustomerCode() );
        
        DocBody docBody = solrService.searchDoc( queryParam );
        
        GroupDoc groupDoc = new GroupDoc();
        groupDoc.setGroupValue( 3 );
        groupDoc.setDoclist( docBody );
        
        return groupDoc;
    }
    
    private String analysisKeyWord( String keyword )
    {
        String analysisKeyWord = "";
        String replaceStr = keyword.replaceAll( "[^\\u4e00-\\u9fa5]", "" );
        StringBuffer sb = new StringBuffer();
        
        if ( replaceStr.length() > 1 && replaceStr.length() <= 10 )
        {// "/(\w)(?=\w)/g"
            char[] cs = replaceStr.toCharArray();
            for ( char c : cs )
            {
                sb.append( c + " " );
            }
            String trimStr = sb.toString().trim();
            analysisKeyWord = "OR (text:" + trimStr + ")";
        }
        
        return analysisKeyWord;
    }

    @Override
    public boolean addDoc( String docId, Map<String, String> docFields )
    {
        return solrService.addDoc( docId, docFields );
    }

    @Override
    public boolean deleteDoc( String docId )
    {
        return solrService.deleteDoc( docId );
    }

    @Override
    public boolean updateDoc( String docId, Map<String, String> docFields )
    {
        return solrService.updateDoc( docId, docFields );
    }

}
