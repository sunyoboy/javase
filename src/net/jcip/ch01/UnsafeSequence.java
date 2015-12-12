package net.jcip.ch01;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {
	private int value;
	
	public UnsafeSequence() {
		this.value = 0;
	}
	
	public UnsafeSequence(int value) {
		this.value = value;
	}
	
	/* ����һ��Ψһ����ֵ */
	public int getNext() {
		return value++;
	}
}
