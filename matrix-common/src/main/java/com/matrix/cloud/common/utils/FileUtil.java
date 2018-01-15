package com.matrix.cloud.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil
{
    public static Logger log = LoggerFactory.getLogger( FileUtil.class );

    public static byte[] readByteFile( String fileName )
    {
        FileInputStream fi = null;

        try
        {
            File file = new File( fileName );
            long fileSize = file.length();
            if ( fileSize > Integer.MAX_VALUE )
            {
                throw new Exception( "file size is large, more than INT_MAX." );
            }

            fi = new FileInputStream( file );
            byte[] buffer = new byte[( int ) fileSize];

            int offset = 0;
            int numRead = 0;

            while ( offset < buffer.length && (numRead = fi.read( buffer, offset, buffer.length - offset )) >= 0 )
            {
                offset += numRead;
            }

            if ( offset != buffer.length )
            {
                throw new Exception( "Could not completely read file " + file.getName() );
            }

            return buffer;
        }
        catch ( Exception e )
        {
            log.error( String.format( "read byte from file %s error: %s.", fileName, e.getMessage() ) );
            return null;
        }
        finally
        {
            if ( null != fi )
            {
                try
                {
                    fi.close();
                }
                catch ( IOException e )
                {
                    log.error( String.format( "close io for file %s error: %s.", fileName, e.getMessage() ) );
                }
            }
        }
    }

    public static File copyFile( String newFileName, File orgFile )
    {
        FileOutputStream fou = null;
        FileInputStream fin = null;
        try
        {
            File newFile = new File( newFileName );
            File parent = newFile.getParentFile();

            if ( null != parent && !parent.exists() )
            {
                parent.mkdirs();
            }

            if ( !newFile.exists() )
            {
                newFile.createNewFile();
            }

            fou = new FileOutputStream( newFile );
            fin = new FileInputStream( orgFile );
            byte[] data = new byte[512];

            int count = 0;
            while ( (count = fin.read( data )) != -1 )
            {
                fou.write( data, 0, count );
            }

            return newFile;
        }
        catch ( Exception e )
        {
            log.error( String.format( "copy file %s to file %s failed: %s", orgFile.getName(), newFileName, e.getMessage() ) );
            return null;
        }
        finally
        {
            try
            {
                if ( null != fin )
                {
                    fin.close();
                }
            }
            catch ( Exception e )
            {
                log.error( String.format( "copy file %s to file %s close input stream failed: %s", orgFile.getName(), newFileName, e.getMessage() ) );
            }

            try
            {
                if ( null != fou )
                {
                    fou.close();
                }
            }
            catch ( Exception e )
            {
                log.error( String.format( "copy file %s to file %s close output stream failed: %s", orgFile.getName(), newFileName, e.getMessage() ) );
            }
        }
    }

    public static boolean writeByteFile( String fileName, byte[] data )
    {
        FileOutputStream fo = null;

        try
        {
            File file = new File( fileName );
            File parent = file.getParentFile();
            if ( null != parent && !parent.exists() )
            {
                parent.mkdirs();
            }

            if ( !file.exists() )
            {
                file.createNewFile();
            }

            fo = new FileOutputStream( file );
            if ( null != data && data.length > 0 )
            {
                fo.write( data );
            }

            return true;
        }
        catch ( Exception e )
        {
            log.error( String.format( "read byte from file %s error: %s", fileName, e.getMessage() ) );
            return false;
        }
        finally
        {
            try
            {
                if ( null != fo )
                {
                    fo.close();
                }
            }
            catch ( Exception e )
            {
                log.error( String.format( "read byte from file %s close output stream error: %s", fileName, e.getMessage() ) );
            }
        }
    }

    public static String readTextFile( String fileName )
    {
        InputStreamReader isr = null;

        try
        {
            StringBuilder content = new StringBuilder();

            isr = new InputStreamReader( new FileInputStream( fileName ), "UTF-8" );

            char buf[] = new char[256];
            int numRead = 0;

            while ( (numRead = isr.read( buf, 0, buf.length )) >= 0 )
            {
                content.append( buf, 0, numRead );
            }

            return content.toString();
        }
        catch ( Exception e )
        {
            log.error( String.format( "read text from file %s error: %s.", fileName, e.getMessage() ) );
            return null;
        }
        finally
        {
            if ( null != isr )
            {
                try
                {
                    isr.close();
                }
                catch ( IOException e )
                {
                    log.error( String.format( "close io for file %s error: %s.", fileName, e.getMessage() ) );
                }
            }
        }
    }

    public static boolean writeTextFile( String fileName, String content )
    {
        OutputStreamWriter fw = null;

        try
        {
            File file = new File( fileName );
            File parent = file.getParentFile();

            if ( null != parent && !parent.exists() )
            {
                parent.mkdirs();
            }

            if ( !file.exists() )
            {
                file.createNewFile();
            }

            fw = new OutputStreamWriter( new FileOutputStream( file ), "UTF-8" );

            if ( null != content && !content.isEmpty() )
            {
                fw.write( content, 0, content.length() );
            }

            return true;
        }
        catch ( Exception e )
        {
            log.error( String.format( "read byte from file %s error: %s.", fileName, e.getMessage() ) );
            return false;
        }
        finally
        {
            if ( null != fw )
            {
                try
                {
                    fw.close();
                }
                catch ( IOException e )
                {
                    log.error( String.format( "close io for file %s error: %s.", fileName, e.getMessage() ) );
                }
            }
        }
    }

    public static String getPath( String fileName )
    {
        int pos = fileName.lastIndexOf( File.separatorChar );

        if ( -1 == pos )
        {
            return null;
        }

        return fileName.substring( 0, pos );
    }

    public static String getName( String fileName )
    {
        int pos = fileName.lastIndexOf( File.separatorChar );

        if ( -1 == pos )
        {
            return fileName;
        }

        return fileName.substring( pos + 1 );
    }

    public static String getExtName( String fileName )
    {
        String name = getName( fileName );
        int pos = name.lastIndexOf( '.' );

        if ( -1 == pos )
        {
            return "";
        }

        return name.substring( pos + 1 );
    }

    public static String getBaseName( String fileName )
    {
        String name = getName( fileName );
        int pos = name.lastIndexOf( '.' );

        if ( -1 == pos )
        {
            return name;
        }

        return name.substring( 0, pos );
    }

    public static String getNoExtName( String fileName )
    {
        int pos = fileName.lastIndexOf( '.' );

        if ( -1 == pos )
        {
            return fileName;
        }

        return fileName.substring( 0, pos );
    }

    static public final int FTYPE_NONE = 0x00;

    static public final int FTYPE_FILE = 0x01;

    static public final int FTYPE_DIR = 0x02;

    public static int getType( String fileName )
    {
        File file = new File( fileName );

        if ( file.isFile() )
        {
            return FTYPE_FILE;
        }
        else if ( file.isDirectory() )
        {
            return FTYPE_DIR;
        }

        return FTYPE_NONE;
    }

    public static boolean isExist( String fileName )
    {
        File file = new File( fileName );

        return file.exists();
    }

    public static boolean isFile( String fileName )
    {
        File file = new File( fileName );

        return file.isFile();
    }

    public static boolean isDirectory( String fileName )
    {
        File file = new File( fileName );

        return file.isDirectory();
    }

    public static boolean mkdirs( String fileName )
    {
        File file = new File( fileName );

        try
        {
            return file.mkdirs();
        }
        catch ( Exception e )
        {
            return false;
        }
    }

    public static boolean chmod( String fileName )
    {
        return false;
    }

    public static boolean chown( String user, String group )
    {
        return false;
    }
}
