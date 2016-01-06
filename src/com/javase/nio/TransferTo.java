/*
 * Copyright (C), 2002-2016, 北京世纪鼎点软件有限公司
 * FileName: TransferTo.java
 * Author:   DD240
 * Date:     2016-1-6 下午3:09:31
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.javase.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class TransferTo {
    
    public static void main(String[] args) {
        try {
            FileChannel fcIn = new FileInputStream("readme.txt").getChannel();
            FileChannel fcOut = new FileOutputStream("me.txt").getChannel();
            fcIn.transferTo(0, fcIn.size(), fcOut);
            
            // or :
            // fcOut.transferFrom(fcIn, 0, fcIn.size());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
