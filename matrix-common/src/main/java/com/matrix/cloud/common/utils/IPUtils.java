package com.matrix.cloud.common.utils;

import javax.servlet.http.HttpServletRequest;

/**   
* @Description: TODO(这里用一句话描述这个类的作用)  
* 
* @author matrix 
* @date 2018年1月14日  下午4:11:18
*
* @Copyright: 2018 www.matrix.com Inc. All rights reserved. 
*/  
public class IPUtils
{
    private static final String UNKNOWN = "unknown";
    
    private static final String X_FORWARDED_FOR = "x-forwarded-for";
    
    private static final String PROXY_CLIENT_IP = "Proxy-Client-IP";
    
    private static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
    
    
    public static String getIpAddr( HttpServletRequest request )
    {
        String ip = request.getHeader( X_FORWARDED_FOR );
        
        if ( ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase( ip ) )
        {
            ip = request.getHeader( PROXY_CLIENT_IP );
        }
        
        if ( ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase( ip ) )
        {
            ip = request.getHeader( WL_PROXY_CLIENT_IP );
        }
        
        if ( ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase( ip ) )
        {
            ip = request.getRemoteAddr();
        }
        
        return ip;
    }

}
