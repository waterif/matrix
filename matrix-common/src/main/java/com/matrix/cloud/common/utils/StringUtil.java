package com.matrix.cloud.common.utils;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**   
* @Description: TODO(这里用一句话描述这个类的作用)  
* 
* @author matrix 
* @date 2018年1月14日  下午4:11:37
*
* @Copyright: 2018 www.matrix.com Inc. All rights reserved. 
*/  
public class StringUtil
{

    private static final int CHAR_NUMBER = 0x01;

    private static final int CHAR_UPPERCASE_LITTER = 0x02;

    private static final int CHAR_LOWERCASE_LITTER = 0x04;

    private static final int CHAR_SIGN = 0x08;

    private static final int CHAR_SPACE = 0x10;

    private static final int CHAR_CONTROL = 0x20;
    
    private static final Pattern P_TAB_ENTER = Pattern.compile( "\t|\r|\n" );
    
    private static final Pattern P_ENTER = Pattern.compile( "\r|\n" );

    public static String replaceBlank( String str )
    {
        String dest = "";
        if ( str != null )
        {
            Matcher m = P_TAB_ENTER.matcher( str.trim() );
            dest = m.replaceAll( "" );
        }
        return dest;
    }

    public static String replaceEnter( String str )
    {
        String dest = "";
        if ( str != null )
        {
            Matcher m = P_ENTER.matcher( str );
            dest = m.replaceAll( "" );
        }
        return dest;
    }

    // ---------------------------------------------------------------- the one
    /**
     * Compares string with at least one from the provided array. If at least
     * one equal string is found, returns its index. Otherwise, <code>-1</code>
     * is returned.
     */
    public static int equalsOne( String src, String[] dest )
    {
        for ( int i = 0; i < dest.length; i++ )
        {
            if ( src.equals( dest[i] ) )
            {
                return i;
            }
        }
        return -1;
    }

    public static String randomString( int siz, int types )
    {
        if ( siz <= 0 )
        {
            return null;
        }

        return randomString( siz, getChars( types ) );
    }

    public static String randomStringSpecialScope( int siz, String charScope )
    {
        if ( siz <= 0 )
        {
            return null;
        }

        if ( StringUtils.isEmpty( charScope ) )
        {
            return null;
        }

        return randomString( siz, charScope );
    }

    public static String randomString( int siz, String chars )
    {
        if ( siz <= 0 || null == chars || chars.isEmpty() )
        {
            return null;
        }

        int i, charsSize = chars.length();
        StringBuilder res = new StringBuilder();
        SecureRandom rand = new SecureRandom();
        rand.setSeed( System.currentTimeMillis() );

        for ( i = 0; i < siz; i++ )
        {
            res.append( chars.charAt( rand.nextInt( charsSize - 1 ) ) );
        }

        return res.toString();
    }

    public static String getChars( int types )
    {
        int i;
        StringBuilder res = new StringBuilder();

        if ( 0 != (types & CHAR_NUMBER) )
        {
            for ( i = ( int ) '0'; i <= ( int ) '9'; i++ )
            {
                res.append( ( char ) i );
            }
        }

        if ( 0 != (types & CHAR_UPPERCASE_LITTER) )
        {
            for ( i = ( int ) 'A'; i <= ( int ) 'Z'; i++ )
            {
                res.append( ( char ) i );
            }
        }

        if ( 0 != (types & CHAR_LOWERCASE_LITTER) )
        {
            for ( i = ( int ) 'a'; i <= ( int ) 'z'; i++ )
            {
                res.append( ( char ) i );
            }
        }

        if ( 0 != (types & CHAR_SIGN) )
        {
            for ( i = ( int ) '!'; i <= ( int ) '/'; i++ )
            {
                res.append( ( char ) i );
            }

            for ( i = ( int ) ':'; i <= ( int ) '@'; i++ )
            {
                res.append( ( char ) i );
            }

            for ( i = ( int ) '['; i <= ( int ) '`'; i++ )
            {
                res.append( ( char ) i );
            }

            for ( i = ( int ) '{'; i <= ( int ) '~'; i++ )
            {
                res.append( ( char ) i );
            }
        }

        if ( 0 != (types & CHAR_SPACE) )
        {
            res.append( ' ' );
        }

        if ( 0 != (types & CHAR_CONTROL) )
        {
            for ( i = 1; i < 32; i++ )
            {
                res.append( ( char ) i );
            }

            res.append( ( char ) 127 );
        }

        return res.toString();
    }

    public static void main( String[] args )
    {
        String tmp = " 这是 一个\r\n 测     试 \r\n";
        System.out.println( tmp );
        System.out.println( "[" + replaceBlank( tmp ) + "]" );
    }
}
