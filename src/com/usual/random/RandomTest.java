package com.usual.random;


public class RandomTest {
	public static void main(String[] args) {
		// Math.random() :  ���ش����ŵ� double ֵ����ֵ���ڵ��� 0.0 ��С�� 1.0
		/**
		 * java.util.Random()
		 * java.util.Random���̰߳�ȫ�ģ����Բ����ڶ���̵߳��û��ƻ�����(seed)�ķ��ա�
		 */
		
		// http://blog.csdn.net/hengyunabc/article/details/9913143
/*		System.out.println(Math.random());
		System.out.println(Math.round(Math.random() * 10));
		System.out.println(Math.round(Math.random() * 10));
		
		int rand = java.util.concurrent.ThreadLocalRandom.current().nextInt(10);
		
		System.out.println(rand);
		
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		System.out.println(new String(bytes));
		for(int i=0; i<bytes.length; i++) {
			System.out.println(bytes[i]);
		}
		System.out.println();
		
		System.out.println(ThreadLocalRandom.current().nextLong());*/
		
		TestMathRandom();
		System.out.println(System.nanoTime());
	}
	
	public static void TestMathRandom() {
		for(int i=0; i<3; i++) {
			RandomTask t = new RandomTask();
			new Thread(t).start();
		}
		
	}
}
