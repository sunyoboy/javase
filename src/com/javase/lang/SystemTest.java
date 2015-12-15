package com.javase.lang;

import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class SystemTest {
	public static void main(String[] args) {
		System.out.println(SystemTest.class.getProtectionDomain().getCodeSource()
				.getLocation());// 获取程序的根目录
		URL url = Thread.currentThread().getContextClassLoader()
				.getResource("");
		System.out.println(url.toString());

		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.indexOf("win") >= 0) { // linux下不要设置此值，不然会报错
			System.out.println("Win " + osName);
			if (System.getProperty("line.separator").equals("\r\n")) {
				System.out.println(" line.separator in Win equals \\r\\n");
			}
		} else {
			System.out.println("Os name " + osName);
			if (System.getProperty("line.separator").equals("\n")) {
				System.out.println(" line.separator in " + osName
						+ " equals \\n");
			}
		}

		System.out.println("File.separator : " + File.separator);
		System.out.print("aa\nbb");
		System.out.print("aa\rbb");
		System.out.println("aa\tbb");

		/* 读取系统属性信息 */
		Properties props = System.getProperties();
		Set<Entry<Object, Object>> set = props.entrySet();
		Iterator<Entry<Object, Object>> iterator = set.iterator();
		System.out.println("proprety items length  " + set.size());
		while (iterator.hasNext()) {
			Entry<Object, Object> entry = iterator.next();
			// System.out.println(entry.getKey() + "-------->(" +
			// entry.getValue() + ")");
		}

		String abc = "abc def ghk";
		// abc.split("s");
		String[] abcs = abc.split("s");
		for (int i = 0; i < abcs.length; i++) {
			System.out.println(i + " " + abcs[i]);
		}

		/* 验证空格字符 */
		System.out.println("－－－－－－－－" + "s" + "--------------");
	}
}
