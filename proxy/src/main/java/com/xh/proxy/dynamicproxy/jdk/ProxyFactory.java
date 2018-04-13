package com.xh.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.xh.proxy.staticproxy.IFootBath;
import com.xh.proxy.staticproxy.Masseuse;

/**
 *
 * @ClassName:  ProxyFactory 
 *
 * @Description:The proxy factory.
 *
 * @author xiaohe
 *
 * @date: 2018年4月12日 下午5:37:58
 *
 * @version V1.0  
 *
 * @Copyright: 2018 www.xh
 *
 */
public class ProxyFactory implements InvocationHandler {
	
	private IFootBath footBath;
	
	public ProxyFactory(IFootBath footBath) {
		this.footBath = footBath;
	}
	
	public ProxyFactory() {
		footBath = new Masseuse.Builder()
				.setAge(22)
				.setFaceScore(80)
				.setNickName("xs")
				.setPrice(5000)
				.setSkill(85).build();
	}
	
	/**
	 *   
	 * @Title: getProxyObject 
	 *
	 * @author: xiaohe
	 *
	 * @Description: Dynamically generated proxy class.
	 *
	 * @param loader
	 *    This ClassLoader.
	 *
	 * @return: Object
	 *    Generated proxy class.
	 *
	 */
	public Object getProxyObject(ClassLoader loader) {
		return Proxy.newProxyInstance(loader, footBath.getClass().getInterfaces(), this);
	}

	/**
	 *
	 * <p>Title: invoke</p>   
	 *
	 * <p>Description: </p>   
	 *
	 * @param proxy
	 *     the proxy instance that the method was invoked on.
	 * 
	 * @param method
	 *     the {@code Method} instance corresponding to 
	 *     the interface method invoked on the proxy instance.
	 * 
	 * @param args
	 *     The param of this method.
	 * 
	 * @return
	 *     The proxy instance.
	 * 
	 * @throws Throwable   
	 *
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])   
	 *
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("[the invoke : ]" + proxy.getClass().getName());
		if(method.getName().equals("normalFootbath")) {
			System.out.println("[Proxy Factory] customer want to normalFootbath...");
			System.out.println("[Proxy Factory] pay the fees...");
			int score = (Integer)method.invoke(footBath, args);
			return score;
		} else if(method.getName().equals("takeAway")) {
			System.out.println("[Proxy Factory] customer want to takeAway...");
			System.out.println("[Proxy Factory] check customer's CID...");
			return method.invoke(footBath, args);
		}
		// ? Very important, reference Client 21 line, System.out.println(manager.toString());
		return method.invoke(footBath, args); 
	}

}
