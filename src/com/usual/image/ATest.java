/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: ATest.java
 * Author:   DD240
 * Date:     2015-11-9 ����5:25:43
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.usual.image;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class ATest {
    
    @Test
    public void TestCollection() {
        Collection c = new ArrayList();
        Assert.assertNotNull(c);
        Assert.assertNull(c);
        
    }
}
