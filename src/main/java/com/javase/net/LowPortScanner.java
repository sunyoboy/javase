/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: LowPortScanner.java
 * Author:   DD240
 * Date:     2015-12-23 上午11:01:51
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.javase.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class LowPortScanner {
    public static void main(String[] args) {
        String host = "192.168.8.83";
        
        if(args.length > 0) {
            host = args[0];
        }
        Socket s = null;
        for (int i = 1; i < 1024; i++) {
            try {
                s = new Socket(host, i);
                System.out.println("There is a server on port " + i + " "+ host);
            } catch (UnknownHostException ex) {
                System.err.println(ex);
                break;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
