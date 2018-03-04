package com.matrix.cloud.microservice.service.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.matrix.cloud.microservice.entity.QueryParam;


//@RunWith( SpringRunner.class )
//@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class SolrServiceTest
{

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
    }

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testAddDoc()
    {
        fail( "Not yet implemented" );
    }

    @Test
    public void testDeleteDoc()
    {
        fail( "Not yet implemented" );
    }

    @Test
    public void testUpdateDoc()
    {
        fail( "Not yet implemented" );
    }

    @Test
    public void testSearchDoc()
    {
        SolrService solrService = new SolrService("http://10.255.1.35:8983/solr/Test300/");
        
        QueryParam queryParam = new QueryParam();
        
        queryParam.setQueyrParam( "customercode:006201 and indexDoctype_ID:25" );
        
        queryParam.setGroupField( "indexDoctype_ID" );
        
        Object searchDoc = solrService.searchDoc( queryParam );
        
        System.out.println( JSON.toJSONString( searchDoc ) );
    }

}
