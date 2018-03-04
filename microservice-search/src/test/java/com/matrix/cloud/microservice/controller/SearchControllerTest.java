package com.matrix.cloud.microservice.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith( SpringRunner.class )
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class SearchControllerTest
{
    @Test
    public void contextLoads()
    {
    }

    // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。
    private MockMvc mockMvc; 

    @Autowired
    private WebApplicationContext wac; // 注入WebApplicationContext

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
        this.mockMvc = MockMvcBuilders.webAppContextSetup( this.wac ).build();
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testSearch()
    {
        MvcResult result;
        try
        {
            result = mockMvc.perform( get( "/search"  ).contentType(MediaType.APPLICATION_JSON_UTF8)
                    .param("start", "0")
                    .param("rows", "10")
                    .param("group.limit", "10")
                    .param("group.offset", "0")
                    .param("user_id", "63822192")
                    .param("scope", "[1, 2]")
                    .param("keyword", "test")
                    .param("customer_code", "002726")
                    .param("site_id", "72386")
                    .param("category", "bbs%2Ctask")
                    .accept(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect( status().isOk() )// 模拟向testRest发送get请求
                    .andExpect( content().contentType( MediaType.APPLICATION_JSON_UTF8 ) )// 预期返回值的媒体类型text/plain;charset=UTF-8
                    .andReturn();
            
            // 返回执行请求的结果
            System.out.println( result.getResponse().getContentAsString() );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
            fail( e.getMessage() );
        }
    }
    
    @Test
    public void testFindById2()
    {
        RequestBuilder request = MockMvcRequestBuilders.get( "/user/3" ).contentType( MediaType.APPLICATION_JSON_UTF8 ).header( "SESSIONNO", "" );

        try
        {
            MvcResult mvcResult = mockMvc.perform( request ).andReturn();

            int status = mvcResult.getResponse().getStatus();
            String content = mvcResult.getResponse().getContentAsString();

            Assert.assertTrue( "正确", status == 200 );
            Assert.assertFalse( "错误", status != 200 );

            System.out.println( "返回结果status：" + status );
            System.out.println( "返回结果status：" + content );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
            fail( e.getMessage() );
        }
    }

}
