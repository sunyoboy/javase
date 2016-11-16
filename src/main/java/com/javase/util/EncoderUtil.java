/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: EncoderUtil.java
 * Author:   DD240
 * Date:     2015-11-30 下午3:38:35
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.javase.util;


import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Assert;


/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class EncoderUtil {
    public static void main(String[] args) {
        String str = "password";
        String base64Encoded = Base64.encodeToString(str.getBytes());
        System.out.println("encodedStr of str :" + base64Encoded);
        
        String str2 = new String(Base64.decode(base64Encoded));
        String str3 = org.apache.shiro.codec.Base64.decodeToString(base64Encoded);
        
        Assert.assertEquals(str, str3);
        System.out.println(str.equals(str2));
        
        // 16进制字符串编/解码
        
        String passwd = "password";
        String encodedPwd = Hex.encodeToString(passwd.getBytes());
        String passwd2 = new String(Hex.decode(encodedPwd.getBytes()));
        Assert.assertEquals(passwd, passwd2);
        System.out.println(passwd.equals(passwd2));
        
        // CodecSupport 提供toBytes(str, "utf-8") / toString(bytes,"utf-8")用于在byte数组与String之间进行转换
        byte bytes[] = CodecSupport.toBytes("abcdef");
        byte aBytes[] = CodecSupport.toBytes("abcdef", "utf-8");
        for(int i=0; i<bytes.length; i++) {
            System.out.print(bytes[i] + "\t");
            // System.out.print(aBytes[i] + "\t");
        }
        System.out.println();
        
        // 散列算法
        String adminStr = new Md5Hash("admin").toString();
        System.out.println(adminStr); // result : 21232f297a57a5a743894a0e4a801fc3
        
        String user="hello";
        String salt="123";
        
        String pwd = new Md5Hash(user,salt).toString();
        System.out.println(pwd); // result : 86fcb4c0551ea48ede7df5ed9626eee7
        
        System.out.println(new Md5Hash(user, salt, 3).toString());
    }
}
