package com.matrix.cloud.common.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**   
* @Description: TODO(这里用一句话描述这个类的作用)  
* 
* @author matrix 
* @date 2018年1月14日  下午12:47:44
*
* @Copyright: 2018 www.matrix.com Inc. All rights reserved. 
*/  
@SuppressWarnings( "serial" )
public class BaseException extends RuntimeException
{

    private Logger logger = LoggerFactory.getLogger( BaseException.class );

    private int errorCode;

    /**
     * 构造方法
     */
    public BaseException()
    {
        errorCode = 0;
    }

    /**
     * 构造方法 BaseException
     * @param errorMsg 异常描述
     */
    public BaseException( String errorMsg )
    {
        super( errorMsg );
        errorCode = 0;
    }

    /**
     * @param errorMsg
     * @param cause
     */
    public BaseException( String errorMsg, Throwable cause )
    {
        super( errorMsg, cause );
        errorCode = 0;
    }

    /**
     * @param errorCode
     * @param errorMsg
     * @roseuid 45F7E8850119
     */
    public BaseException( int errorCode, String errorMsg )
    {
        super( errorMsg );
        this.errorCode = errorCode;
        logger.error( errorMsg, errorCode );
    }

    /**
     * @param errorCode
     * @param errorMsg
     * @param cause
     */
    public BaseException( int errorCode, String errorMsg, Throwable cause )
    {
        super( errorMsg, cause );
        this.errorCode = errorCode;
        logger.error( errorMsg, cause );
    }

    /**
     * @return int
     * @roseuid 45F7E7CD006D
     */
    public int getErrorCode()
    {
        return this.errorCode;
    }

    /**
     * @param errorCode
     * @roseuid 45F7E7D8003E
     */
    public void setErrorCode( int errorCode )
    {
        this.errorCode = errorCode;
    }
}