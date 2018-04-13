package com.xh.proxy.dynamicproxy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.ProxyGenerator;

public class ProxyWriter {
	
	public static void writeToFile(Class clazz) {
		byte[] proxyClass = ProxyGenerator.generateProxyClass(clazz.getSimpleName(), clazz.getInterfaces());
		File path = new File("d:\\class\\" + clazz.getSimpleName() + ".class");
		if (!path.getParentFile().exists()) {
			path.getParentFile().mkdirs();
		} 
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(path);
			outputStream.write(proxyClass);
			outputStream.flush();
			outputStream.close();
			System.out.printf("class saved to: %s", path.getAbsolutePath());
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
