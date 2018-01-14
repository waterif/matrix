package com.matrix.cloud.common.base.lock;

/**   
* @Description: TODO(这里用一句话描述这个类的作用)  
* 
* @author matrix 
* @date 2018年1月14日  下午4:10:48
*
* @Copyright: 2018 www.matrix.com Inc. All rights reserved. 
*/  
public class Lock
{
    private String name;

    private String value;

    public Lock( String name, String value )
    {
        this.name = name;
        this.value = value;
    }

    public String getName()
    {
        return name;
    }

    public String getValue()
    {
        return value;
    }

}
