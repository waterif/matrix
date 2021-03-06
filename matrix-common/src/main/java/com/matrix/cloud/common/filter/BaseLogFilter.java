package com.matrix.cloud.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;

import com.matrix.cloud.common.base.CommonThreadLocal;
import com.matrix.cloud.common.base.RequestHandler;
import com.matrix.cloud.common.constant.Constants;
import com.matrix.cloud.common.utils.IPUtils;

/**   
* @Description: TODO(这里用一句话描述这个类的作用)  
* 
* @author matrix 
* @date 2018年1月14日  下午4:11:04
*
* @Copyright: 2018 www.matrix.com Inc. All rights reserved. 
*/  
@WebFilter( filterName = "baseLogFilter", urlPatterns = "/*", initParams = { @WebInitParam( name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico" ) // 忽略资源
} )
@Order( 0 )
public class BaseLogFilter implements Filter
{

    /** logger */
    private Logger logger = LoggerFactory.getLogger( this.getClass() );

    @Override
    public void init( FilterConfig fConfig ) throws ServletException
    {
    }

    @Override
    public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException, ServletException
    {
        MDC.put( Constants.REQUEST_ID, RequestHandler.getRequestId() );
        MDC.put( Constants.SOURCE_IP, IPUtils.getIpAddr( ( HttpServletRequest ) request ) );
        try
        {
            logger.debug( "dofilter." );
            chain.doFilter( request, response );
        }
        finally
        {
            MDC.remove( Constants.SOURCE_IP );
            MDC.remove( Constants.REQUEST_ID );
            CommonThreadLocal.clear();
        }
    }

    @Override
    public void destroy()
    {
    }
}
