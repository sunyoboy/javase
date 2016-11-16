/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: OOMObject.java
 * Author:   DD240
 * Date:     2015-12-29 ����4:57:06
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.jvm.mem;

/**
 * VM Args : -Xss128k
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class JavaVMStackSOF {
    
    private int stackLength = 1;
    
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
    
    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom  = new JavaVMStackSOF();
            try {
                oom.stackLeak();
            } catch (Throwable e) {
                System.out.println("stack length : " + oom.stackLength);
                throw e;
            }
    }
}
