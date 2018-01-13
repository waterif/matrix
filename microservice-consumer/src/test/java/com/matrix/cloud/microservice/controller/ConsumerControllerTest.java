package com.matrix.cloud.microservice.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
public class ConsumerControllerTest
{
    @Test
    public void contextLoads()
    {
    }

    private MockMvc mockMvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。

    @Autowired
    private WebApplicationContext wac; // 注入WebApplicationContext

    // @Autowired
    // private MockHttpSession session;// 注入模拟的http session
    
    // @Autowired
    // private MockHttpServletRequest request;// 注入模拟的http request\
    
    
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
    public void testFindById()
    {
        MvcResult result;
        try
        {
            result = mockMvc.perform( get( "/user/2" ) )
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
