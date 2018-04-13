package com.xh.proxy.dynamicproxy.jdk;

import com.xh.proxy.dynamicproxy.ProxyWriter;
import com.xh.proxy.staticproxy.IFootBath;
import com.xh.proxy.staticproxy.Masseuse;

/**
 *
 * @ClassName:  CustomerJdk 
 *
 * @Description:The main method.
 *
 * @author xiaohe
 *
 * @date: 2018年4月12日 下午6:37:22
 *
 * @version V1.0  
 *
 * @Copyright: 2018 www.cqys
 *
 */
public class CustomerJdk {
	public static void main(String[] args) {
		IFootBath footBath = new Masseuse.Builder()
				.setAge(22)
				.setFaceScore(80)
				.setNickName("xs")
				.setPrice(5000)
				.setSkill(85).build();
		ProxyFactory factory = new ProxyFactory(footBath);
		IFootBath proxyFootBath = 
				(IFootBath) factory.getProxyObject(CustomerJdk.class.getClassLoader());
		ProxyWriter.writeToFile(proxyFootBath.getClass());
		int score = proxyFootBath.normalFootbath();
		System.out.println(score);
		System.out.println(proxyFootBath.toString());
		proxyFootBath.takeAway(2000);
	}

}
