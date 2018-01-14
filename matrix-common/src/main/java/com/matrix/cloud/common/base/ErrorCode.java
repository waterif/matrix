package com.matrix.cloud.common.base;


/**   
* @Description: TODO(这里用一句话描述这个类的作用)  
* 
* @author matrix 
* @date 2018年1月14日  下午4:10:05
*
* @Copyright: 2018 www.matrix.com Inc. All rights reserved. 
*/  
public class ErrorCode
{
    /**
     * 成功
     */
    public static final int SUCCESS = 0;

    /**
     * 未知错误
     */
    public static final int ERROR_UNKNOWN = -1;

    /**
     * 通用错误
     */
    public static final int ERROR_COMMON_FAILURE = 1;

    /**
     * 鉴权错误
     */
    public static final int ERROR_AUTH_SUCCESS = 10000;
    
    
    /**
     * 获取云问token失败
     */
    public static final int ERROR_YUNWEN_TOKEN_GET = 20001;

}
