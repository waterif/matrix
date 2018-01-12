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

        if ( context.containsKey( Constants.REQUESTID ) )
        {
            requestId = String.valueOf( context.get( Constants.REQUESTID ) );
        }

        if ( StringUtils.isEmpty( requestId ) )
        {

            requestId = UUID.randomUUID().toString();
            context.put( Constants.REQUESTID, requestId );
        }

        return requestId;

    }
}
