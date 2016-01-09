package com.javase.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import org.apache.log4j.Logger;
import org.junit.Test;

public class LockingMappedFile {
	
	public static final int LENGTH = 0x8F; 
	
	public static FileChannel fc;
	
	private static Logger logger = Logger.getLogger(LockingMappedFile.class);
	
	@Test
	public void lock() {
		try {
			fc = new RandomAccessFile("readme.txt", "rw").getChannel();
			MappedByteBuffer out = 
					fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
			
			for(int i=0; i < LENGTH; i++) {
				out.put((byte)'x');
			}
			new LockAndModify(out, 0, LENGTH/3);
			new LockAndModify(out, LENGTH/2, LENGTH/2 + LENGTH/4);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static class LockAndModify extends Thread {
		private ByteBuffer buff;
		private int start, end;
		
		LockAndModify(ByteBuffer bbuffer, int start, int end) {
			this.start = start;
			this.end = end;
			bbuffer.limit(end);
			bbuffer.position(start);
			buff = bbuffer.slice();
			start();
		}

		public void run() {
			try {
				FileLock lock = fc.lock(start, end, false);
				logger.debug("Locked : " + start + " to " + end);
				// perform modification				
				while(buff.position() < buff.limit() - 1)
					buff.put((byte)(buff.get() + 1));
				lock.release();
				logger.debug("Released : " + start + " to " + end);
				
			} catch (IOException e) {
				logger.debug("", e);
				e.printStackTrace();
			}
		}
		
		
		
	}
}
