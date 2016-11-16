/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: DbUtil.java
 * Author:   DD240
 * Date:     2015-12-28 下午2:54:19
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.javase.sql;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.dbutils.DbUtils;
import org.apache.log4j.Logger;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class DbUtil {
    
    private static Logger logger = Logger.getLogger(DbUtil.class);
    private final static Properties prop = new Properties();

    static {
        InputStream inStream = null;
        try {
            logger.debug("load db.propreties ");
            inStream = DbUtil.class.getResourceAsStream("/db.properties");
            try {
                prop.load(inStream);
            } catch (IOException e) {
                logger.debug("IOException ", e);
                e.printStackTrace();
            } finally {
                inStream.close();
            }
        } catch (FileNotFoundException e1) {
            logger.debug("FileNotFoundException ", e1);
            e1.printStackTrace();
        } catch (IOException e) {
            logger.debug("IOException ", e);
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() {
        DbUtils.loadDriver(prop.getProperty("driver"));
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(prop.getProperty("url"), 
                    prop.getProperty("username"), 
                    prop.getProperty("password"));
            logger.debug(prop.getProperty("url") + "/" + prop.getProperty("username"));
        } catch (SQLException e) {
            logger.debug("SQLException ", e);
            e.printStackTrace();
        }
        return conn; 
    }
    
    public static String formatDate(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(d);
    }
    
    
}
