/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: DirectMemoryOOM.java
 * Author:   DD240
 * Date:     2015-12-29 ����7:11:46
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.jvm.mem;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * VM args : -Xmx20M -XX:MaxDirectMemorySize=10M
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;
    
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
