package com.xh.proxy.dynamicproxy.cglib;

import com.xh.proxy.dynamicproxy.ProxyWriter;
import com.xh.proxy.staticproxy.IFootBath;
import com.xh.proxy.staticproxy.Masseuse;

import net.sf.cglib.proxy.Enhancer;

/**
 *
 * @ClassName:  CustomerCglib 
 *
 * @Description:The main method.
 *
 * @author xiaohe
 *
 * @date: 2018年4月12日 下午6:45:17
 *
 * @version V1.0  
 *
 * @Copyright: 2018 www.xh
 *
 */
public class CustomerCglib {

	public static void main(String[] args) {
		IFootBath footBath = new Masseuse.Builder()
				.setAge(22)
				.setFaceScore(80)
				.setNickName("xs")
				.setPrice(5000)
				.setSkill(85).build();
		Enhancer enhancer = new Enhancer();
		// the RealSubject not Subject.
		enhancer.setSuperclass(Masseuse.class); 
		// the Proxy subject and it implements MethodInterceptor interface.
		enhancer.setCallback(new FootBathMethodInterceptor(footBath));
		Masseuse proxyFootBath = (Masseuse)enhancer.create();
		ProxyWriter.writeToFile(proxyFootBath.getClass());
		proxyFootBath.normalFootbath();
		proxyFootBath.takeAway(1000);
		proxyFootBath.takeAway(60000);
		
	}

}
