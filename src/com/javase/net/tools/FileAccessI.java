package com.javase.net.tools;

/* 
 **FileAccess.java �����ļ��Ĵ洢��
 */
import java.io.*;

public class FileAccessI implements Serializable {
	RandomAccessFile oSavedFile;
	long nPos;

	public FileAccessI() throws IOException {
		this("", 0);
	}

	public FileAccessI(String sName, long nPos) throws IOException {
		oSavedFile = new RandomAccessFile(sName, "rw");
		this.nPos = nPos;
		// ��λ�ļ�ָ�뵽 nPos λ�� 
		oSavedFile.seek(nPos);
	}

	// ���������ж����ֽ�����Ȼ��д���ļ���
	public synchronized int write(byte[] b, int nStart, int nLen) {
		int n = -1;
		try {
			oSavedFile.write(b, nStart, nLen);
			n = nLen;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return n;
	}
}