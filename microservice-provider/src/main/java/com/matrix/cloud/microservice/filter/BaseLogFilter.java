package com.matrix.cloud.microservice.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;

import com.matrix.cloud.microservice.base.CommonThreadLocal;
import com.matrix.cloud.microservice.base.RequestHandler;
import com.matrix.cloud.microservice.constant.Constants;

@WebFilter( filterName = "baseLogFilter", urlPatterns = "/*", initParams = { @WebInitParam( name = "exclusions", value = "/health,*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico" ) // 忽略资源
} )
@Order( 0 )
public class BaseLogFilter implements Filter
{

    /** logger */
    private Logger logger = LoggerFactory.getLogger( this.getClass() );

    public void init( FilterConfig fConfig ) throws ServletException
    {
    }

    public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException, ServletException
    {
        MDC.put( Constants.REQUESTID, RequestHandler.getRequestId() );
        try
        {
            logger.debug( "dofilter." );
            chain.doFilter( request, response );
        }
        finally
        {
            MDC.remove( Constants.REQUESTID );
            CommonThreadLocal.clear();
        }
    }

    public void destroy()
    {
    }
}
