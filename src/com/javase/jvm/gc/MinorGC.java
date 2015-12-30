/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: MinorGC.java
 * Author:   DD240
 * Date:     2015-12-30 ����11:12:52
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.jvm.gc;

/**
 * VM Args -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class MinorGC {
    private static final int _MB = 1024 * 1024;
    
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _MB];
        allocation2 = new byte[2 * _MB];
        allocation3 = new byte[2 * _MB];
        allocation4 = new byte[4 * _MB]; // ����һ��Minor GC
    }
    
    public static void main(String[] args) {
        testAllocation();
    }
}
