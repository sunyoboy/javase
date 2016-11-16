/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: TenuredGC.java
 * Author:   DD240
 * Date:     2015-12-30 ����11:28:03
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.jvm.gc;

/**
 * VM Args -XX:PretenureSizeThreshold = 3145728
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class TenuredGC {
    private static final int _MB = 1024 * 1024;

    public static void  testPretenureSizeThreshold() {
        byte[]  allocation;
        allocation = new byte[4 * _MB]; // ֱ�ӷ��䵽�������
    }
    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
