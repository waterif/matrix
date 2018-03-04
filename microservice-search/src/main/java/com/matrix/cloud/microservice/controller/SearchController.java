package com.matrix.cloud.microservice.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.matrix.cloud.common.base.BaseException;
import com.matrix.cloud.common.base.ErrorCode;
import com.matrix.cloud.common.base.ResponseEntity;
import com.matrix.cloud.microservice.entity.DocHeader;
import com.matrix.cloud.microservice.entity.QueryParamDto;
import com.matrix.cloud.microservice.entity.ResultDoc;
import com.matrix.cloud.microservice.service.SearchService;

@RestController
@RequestMapping( "/search" )
public class SearchController
{
    private static Logger logger = LoggerFactory.getLogger( SearchController.class );

    @Autowired
    private SearchService searchService;

    @PostMapping( value = "/V2", consumes = { "application/json; charset=UTF-8" }, produces = { "application/json; charset=UTF-8" } )
    public ResponseEntity<ResultDoc> search2( @RequestBody QueryParamDto qpDto )
    {

        // 接口日志1： request信息
        logger.info( "/search QueryParamDto={}", qpDto );

        try
        {
            ResultDoc resultDoc = searchService.search(qpDto);

            // 接口日志2： response信息
            logger.info( "/search return : resultDoc={}", JSON.toJSONString( resultDoc ) );
            return new ResponseEntity<ResultDoc>( resultDoc );
        }
        catch ( BaseException e )
        {
            // 异常日志
            logger.error( e.getMessage(), e );
            return new ResponseEntity<ResultDoc>( e.getErrorCode(), e.getMessage() );
        }
        catch ( Exception e )
        {
            // 异常日志
            logger.error( e.getMessage(), e );
            return new ResponseEntity<ResultDoc>( ErrorCode.ERROR_COMMON_FAILURE );
        }
    }

    @GetMapping( produces = { "application/json; charset=UTF-8" } )
    public ResultDoc search( 
            @RequestParam( name = "start", required = false ) Long start,
            @RequestParam( name = "rows", required = false ) Long rows,
            @RequestParam( name = "sort", required = false ) String sort,
            @RequestParam( name = "group.limit", required = false ) Long groupLimit,
            @RequestParam( name = "group.offset", required = false ) Long groupOffset, 
            @RequestParam( name = "user_id", required = true ) String userId,
            @RequestParam( name = "scope", required = true ) String scope, 
            @RequestParam( name = "keyword", required = false, defaultValue = "*" ) String keyword,
            @RequestParam( name = "customer_code", required = true ) String customerCode, 
            @RequestParam( name = "site_id", required = false ) String siteId,
            @RequestParam( name = "category", required = false ) String category, 
            @RequestParam( name = "board_id", required = false ) String boardId,
            @RequestParam( name = "org_id", required = false ) String orgId, 
            @RequestParam( name = "org_ids", required = false ) String orgIds,
            @RequestParam( name = "conversation", required = false ) String conversation, 
            @RequestParam( name = "complete", required = false ) String complete,
            @RequestParam( name = "from_time", required = false ) String fromTime, 
            @RequestParam( name = "to_time", required = false ) String toTime )
    {

        QueryParamDto qpDto = new QueryParamDto();
        qpDto.setStart( start );
        qpDto.setRows( rows );
        qpDto.setSort( sort );
        qpDto.setGroupLimit( groupLimit );
        qpDto.setGroupOffset( groupOffset );
        qpDto.setUserId( userId );
        qpDto.setScope( JSON.parseArray( scope, String.class ) );
        qpDto.setKeyword( keyword );
        qpDto.setCustomerCode( customerCode );
        qpDto.setSiteId( siteId );
        qpDto.setCategory( category );
        qpDto.setBoardId( boardId );
        qpDto.setOrgId(orgId);
        qpDto.setOrgIds( orgIds );
        qpDto.setConversation( conversation );
        qpDto.setComplete( complete );
        qpDto.setFromTime( fromTime );
        qpDto.setToTime( toTime );
        
        
        // 接口日志1： request信息
        logger.info( "/search QueryParamDto={}", JSON.toJSONString( qpDto ) );
        
        ResultDoc resultDoc = null;

        try
        {
            resultDoc = searchService.search(qpDto);

            // 接口日志2： response信息
            logger.info( "/search return : resultDoc={}", JSON.toJSONString( resultDoc ) );

            return resultDoc;
        }
        catch ( BaseException e )
        {
            // 异常日志
            logger.error( e.getMessage(), e );
            
            resultDoc = new ResultDoc();
            
            DocHeader responseHeader = new DocHeader();
            
            responseHeader.setStatus( 1 );
            
            resultDoc.setResponseHeader( responseHeader );
            
            return resultDoc;
        }
        catch ( Exception e )
        {
            // 异常日志
            logger.error( e.getMessage(), e );
            
            resultDoc = new ResultDoc();
            
            DocHeader responseHeader = new DocHeader();
            
            responseHeader.setStatus( 1 );
            
            resultDoc.setResponseHeader( responseHeader );
            
            return resultDoc;
        }
    }
    
    @PostMapping( value = "/addDoc", consumes = { "application/json; charset=UTF-8" }, produces = { "application/json; charset=UTF-8" } )
    public ResponseEntity<Boolean> addDoc( 
            @RequestParam( name = "customercode", required = true ) String customerCode,
            @RequestParam( name = "indexDoctype_ID", required = true ) String docType,
            @RequestParam( name = "docId", required = true ) String docId,
            @RequestBody Map<String, String> addDocDto )
    {
     // 接口日志1： request信息
        logger.info( "/addDoc addDocDto={}", addDocDto );

        try
        {
            boolean addDoc = searchService.addDoc( docId, addDocDto );

            // 接口日志2： response信息
            logger.info( "/addDoc return : result={}", JSON.toJSONString( addDoc ) );
            return new ResponseEntity<Boolean>( addDoc );
        }
        catch ( BaseException e )
        {
            // 异常日志
            logger.error( e.getMessage(), e );
            return new ResponseEntity<Boolean>( e.getErrorCode(), e.getMessage() );
        }
        catch ( Exception e )
        {
            // 异常日志
            logger.error( e.getMessage(), e );
            return new ResponseEntity<Boolean>( ErrorCode.ERROR_COMMON_FAILURE );
        }
    }
    
    @PostMapping( value = "/updateDoc", consumes = { "application/json; charset=UTF-8" }, produces = { "application/json; charset=UTF-8" } )
    public ResponseEntity<Boolean> updateDoc( 
            @RequestParam( name = "customercode", required = true ) String customerCode,
            @RequestParam( name = "indexDoctype_ID", required = true ) String docType,
            @RequestParam( name = "docId", required = true ) String docId,
            @RequestBody Map<String, String> updateDocDto )
    {
        // 接口日志1： request信息
        logger.info( "/updateDoc updateDocDto={}", updateDocDto );
        
        try
        {
            boolean updateDoc = searchService.updateDoc( docId, updateDocDto );
            
            // 接口日志2： response信息
            logger.info( "/updateDoc return : result={}", JSON.toJSONString( updateDoc ) );
            return new ResponseEntity<Boolean>( updateDoc );
        }
        catch ( BaseException e )
        {
            // 异常日志
            logger.error( e.getMessage(), e );
            return new ResponseEntity<Boolean>( e.getErrorCode(), e.getMessage() );
        }
        catch ( Exception e )
        {
            // 异常日志
            logger.error( e.getMessage(), e );
            return new ResponseEntity<Boolean>( ErrorCode.ERROR_COMMON_FAILURE );
        }
    }
    
    @PostMapping( value = "/deleteDoc", consumes = { "application/json; charset=UTF-8" }, produces = { "application/json; charset=UTF-8" } )
    public ResponseEntity<Boolean> deleteDoc( @RequestParam( name = "docId", required = true ) String docId )
    {
        // 接口日志1： request信息
        logger.info( "/deleteDoc docId={}", docId );
        
        try
        {
            boolean deleteDoc = searchService.deleteDoc( docId );
            
            // 接口日志2： response信息
            logger.info( "/deleteDoc return : result={}", JSON.toJSONString( deleteDoc ) );
            return new ResponseEntity<Boolean>( deleteDoc );
        }
        catch ( BaseException e )
        {
            // 异常日志
            logger.error( e.getMessage(), e );
            return new ResponseEntity<Boolean>( e.getErrorCode(), e.getMessage() );
        }
        catch ( Exception e )
        {
            // 异常日志
            logger.error( e.getMessage(), e );
            return new ResponseEntity<Boolean>( ErrorCode.ERROR_COMMON_FAILURE );
        }
    }
}
