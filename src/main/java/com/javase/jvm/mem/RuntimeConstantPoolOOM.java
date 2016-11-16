/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: RuntimeConstantPoolOOM.java
 * Author:   DD240
 * Date:     2015-12-29 ����5:47:56
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.jvm.mem;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class RuntimeConstantPoolOOM {

    /**
     * ��������: <br>
     * ��������ϸ������
     *
     * @param args
     * @see 
     * @since 
     */
    public static void main(String[] args) {
        // ʹ��List�����ų����ص����ã�����Full GC���ճ�������Ϊ
        List<String> list = new ArrayList<String>();
        // 10M ��PermSize��Integer��Χ���㹻����OOM��
        int i = 0;
        while(true) {
            
            list.add(("abccef" + i++ ).intern());
            System.out.println(" " + ("abccef" + i++ ));
        }
    }

}
/* jdk1.7.0_75
abccef7561171
abccef7561173
abccef7561175
Exception in thread "RMI TCP Connection(idle)" java.lang.OutOfMemoryError: Java heap space
Exception in thread "RMI TCP Connection(idle)" java.lang.OutOfMemoryError: Java heap space*/

/*  jdk1.6.0_45     abccef470309
Exception in thread "main" java.lang.OutOfMemoryError: PermGen space
   at java.lang.String.intern(Native Method)
   at com.javase.jvm.RuntimeConstantPoolOOM.main(RuntimeConstantPoolOOM.java:39)*/