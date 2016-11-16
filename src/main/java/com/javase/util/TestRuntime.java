/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: TestRuntime.java
 * Author:   DD240
 * Date:     2015-10-30 ����5:09:26
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.util;
import java.util.List;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */

public class TestRuntime {

    public static void main(String[] args) {
        List l;
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
        System.out.println(TestRuntime.getMemByMB(runtime.totalMemory()));
        System.out.println(TestRuntime.getMemByMB(runtime.maxMemory()));
    }
    
    public static long getMemByMB(long aByte) {
        return (aByte / 1024L) / 1024L;
    }
}
