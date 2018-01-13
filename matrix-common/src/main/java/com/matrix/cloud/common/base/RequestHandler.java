package com.matrix.cloud.common.base;

import java.util.Map;
import java.util.UUID;

import org.springframework.util.StringUtils;

import com.matrix.cloud.common.constant.Constants;


public class RequestHandler
{
    public static String getRequestId()
    {
        Map<String, Object> context = CommonThreadLocal.getThreadLocalContext();

        String requestId = null;

        if ( context.containsKey( Constants.REQUEST_ID ) )
        {
            requestId = String.valueOf( context.get( Constants.REQUEST_ID ) );
        }

        if ( StringUtils.isEmpty( requestId ) )
        {

            requestId = UUID.randomUUID().toString();
            context.put( Constants.REQUEST_ID, requestId );
        }

        return requestId;

    }
}
