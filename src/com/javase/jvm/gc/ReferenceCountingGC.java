/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: ReferenceCountingGC.java
 * Author:   DD240
 * Date:     2015-12-30 ����10:54:16
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.jvm.gc;


/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class ReferenceCountingGC {
   private Object instance = null;
   
   private static final int _MB = 1024 * 1024;
   
   /**
    * ռ���ڴ棬�Ա�����GC��־�п�����Ƿ񱻻��չ�
    */
   
   private byte[] bigSize = new byte[2 * _MB];
   
   public static void testGC() {
       ReferenceCountingGC objA = new ReferenceCountingGC();
       ReferenceCountingGC objB = new ReferenceCountingGC();
       objA.instance = objB;
       objB.instance = objA;
       
       objA = null;
       objB = null;
       
       // objA��objB�Ƿ��ڷ���GC�ܱ�����
       System.gc();
   }
   
   public static void main(String[] args) {
       testGC();
   }
}
