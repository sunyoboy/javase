package com.usual.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<Integer> list2 = new ArrayList<Integer>();
		System.out.println("list1.class :" + list1.getClass());
		
		/* һ�������������ʵ��������ʱ������ͬ������ʱ��(class)�����������ǵ�ʵ�����Ͳ����� */
		System.out.println("list1.getClass()  == list2.getClass() :" + (list1.getClass() == list2.getClass()));
		
		System.out.println("Class.class : " + Class.class);
		System.out.println("Serializable.class : " + Serializable.class);
		
		
		/*  ����ʹ�ô����Ͳ���ֵ�����������飬ȴ�����д�������  */
		List<Integer>[] iListArray;
		// iListArray =  new ArrayList<Integer>[10];//����ʱ����
	}
}


/* result: 
list1.class :class java.util.ArrayList
list1.getClass()  == list2.getClass() :true
Class.class : class java.lang.Class
Serializable.class : interface java.io.Serializable
 * */
