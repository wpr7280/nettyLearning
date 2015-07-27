package com.wpr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class NIOTest {
	public static final int BSIZE = 1024;
	@Test
	public void copyFileByNIO() throws IOException{
		FileChannel in = new FileInputStream("D://biz_pending.log").getChannel(),
				out = new FileOutputStream("D://1.txt").getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		while(in.read(buffer)!=-1){
			buffer.flip();           //准备缓冲器以便它的信息可以有write提取
			out.write(buffer);       //write()操作后，信息仍然在缓冲器中，clear()操作对内部指针重新安排
			buffer.clear();
		}
	}
	/**
	 * 使用FileChannel的transform方法来复制数据
	 * @throws IOException 
	 */
	@Test
	public void copyFileDirectUseChannel() throws IOException{
		FileChannel in = new FileInputStream("D://biz_pending.log").getChannel(),
				out = new FileOutputStream("D://1.txt").getChannel();
		int start =0;
		long count = in.size();
		out.transferFrom(in,0, count);
	}
}
