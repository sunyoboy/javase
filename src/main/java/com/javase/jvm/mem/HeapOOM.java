/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: HeapOOM.java
 * Author:   DD240
 * Date:     2015-12-29 ����4:57:39
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.javase.jvm.mem;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError<br> 
 *  MyEclipse VM Args : -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class HeapOOM {
    static class OOMObject {
        
    }
    
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while(true) {
            list.add(new OOMObject());
        }
    }
}
