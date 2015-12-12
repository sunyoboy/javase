/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: CTest.java
 * Author:   DD240
 * Date:     2015-11-9 ����6:52:29
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.junit.tdd;


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
public class CTest {
    
/*    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        Assert.assertEquals(10, product.amount);
        product = five.times(3);
        Assert.assertEquals(15, product.amount);
    }*/
    
    /*    @Test
    public void testMultiplication1() {
        Dollar five = new Dollar(5);
        five.times(2);
        Assert.assertEquals(10, five.amount);
    }
    */
    public void testEquality() {
        Assert.assertTrue(new Dollar(5).equals(new Dollar(5)));
        Assert.assertFalse(new Dollar(5).equals(new Dollar(6)));
    }
    
    @Test
    public void testFrancMultiplication() {
        Franc five = new Franc(5);
        // Dollar product = five.times(2);
        Assert.assertEquals(new Franc(10), five.times(2));
        // product = five.times(3);
        Assert.assertEquals(new Franc(15), five.times(3));
    }        

    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        // Dollar product = five.times(2);
        Assert.assertEquals(new Dollar(10), five.times(2));
        // product = five.times(3);
        Assert.assertEquals(new Dollar(15), five.times(3));
    }
    
/*@Test
    public void testMultiplication3() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        Assert.assertEquals(new Dollar(10), product);
        product = five.times(3);
        Assert.assertEquals(new Dollar(15), product);
    }*/

    class Dollar {
        // v1 int amount = 10;
        private int amount;
        
        Dollar(int amount) {
            this.amount = amount;
        }
        
        public boolean equals(Object object) {
            Dollar dollar = (Dollar) object;
            return amount == dollar.amount;
            // return true;
        }
        
    /*    public void times(int multiplier) {
            amount *= multiplier;
        }*/
        
        public Dollar times(int multiplier) {
            return new Dollar(amount * multiplier);
            // return null;
        }    
        
    }

    class Franc {
        // v1 int amount = 10;
        private int amount;
        
        Franc(int amount) {
            this.amount = amount;
        }
        
        public boolean equals(Object object) {
            Franc dollar = (Franc) object;
            return amount == dollar.amount;
            // return true;
        }
        
    /*    public void times(int multiplier) {
            amount *= multiplier;
        }*/
        
        public Franc times(int multiplier) {
            return new Franc(amount * multiplier);
            // return null;
        }    
        
    }    
    
}

