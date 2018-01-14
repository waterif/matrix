package com.matrix.cloud.common.utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**   
* @Description: TODO(这里用一句话描述这个类的作用)  
* 
* @author matrix 
* @date 2018年1月14日  下午4:11:56
*
* @Copyright: 2018 www.matrix.com Inc. All rights reserved. 
*/  
public class AES128UtilTest
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
    public void testEncrypt()
    {
        try
        {
            Assert.assertEquals( AES128Util.decrypt( AES128Util.encrypt( "9c922313-d67b-474e-a700-de3c49f32a49" ) ), "9c922313-d67b-474e-a700-de3c49f32a49" );
        }
        catch ( Exception e )
        {
            fail( e.getMessage() );
        }
    }

    @Test
    public void testDecrypt()
    {
        try
        {
            assertEquals( AES128Util.decrypt( "WGBmy1sQHMRrfYNLM3yTvOIN8cvPfV3dYI3bSehiSYrtdA55KiZ65rkZWT0HMNHgf3xflhq4x77lmm1g" ), "9c922313-d67b-474e-a700-de3c49f32a49" );
        }
        catch ( Exception e )
        {
            fail( e.getMessage() );
        }
    }

}
