package com.matrix.cloud.common.test;

/**
 * @Description: 类加载
 * 
 * @author matrix
 * @date 2018年1月15日 下午10:17:39
 *
 * @Copyright: 2018 www.matrix.com Inc. All rights reserved.
 */
class Singleton
{

    private static Singleton singleton = new Singleton();

    public static int count1;

    public static int count2 = 0;

    private Singleton()
    {
        count1++;
        count2++;
    }

    public static Singleton getInstence()
    {
        return singleton;
    }
}

public class SingletonTest
{
    public static void main( String[] args )
    {
        Singleton singleton = Singleton.getInstence();

        System.out.println( "count1=" + singleton.count1 );
        System.out.println( "count2=" + singleton.count2 );
    }
}
