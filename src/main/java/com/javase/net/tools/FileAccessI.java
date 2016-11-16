package com.javase.net.tools;

/* 
 **FileAccess.java 负责文件的存储。
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
		// 定位文件指针到 nPos 位置 
		oSavedFile.seek(nPos);
	}

	// 从输入流中读入字节流，然后写到文件中
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