package com.matrix.cloud.common.utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Pinyin4jUtilTest
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
    public void testConverterToFirstSpell()
    {
//        fail( "Not yet implemented" );
        String str = "长沙市长";

        String pinyin = Pinyin4jUtil.converterToFirstSpell( str );
        System.out.println( str + " short pin yin ：" + pinyin );

    }

    @Test
    public void testConverterToSpell()
    {
//        fail( "Not yet implemented" );
        String str = "长沙市长";
        String pinyin = Pinyin4jUtil.converterToSpell( str );
        System.out.println( str + " pin yin ：" + pinyin );
    }

}
