package com.xh.proxy.dynamicproxy.cglib;

import java.lang.reflect.Method;

import com.xh.proxy.staticproxy.IFootBath;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 *
 * @ClassName:  FootBathMethodInterceptor 
 *
 * @Description:The proxy subject.
 *
 * @author xiaohe
 *
 * @date: 2018年4月12日 下午6:39:02
 *
 * @version V1.0  
 *
 * @Copyright: 2018 www.xh
 *
 */
public class FootBathMethodInterceptor implements MethodInterceptor {
	
	private IFootBath footBath;
	
	public FootBathMethodInterceptor(IFootBath footBath) {
		this.footBath = footBath;
	}

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) 
			throws Throwable {
		if(method.getName().equals("normalFootbath")) {
			System.out.println("[proxy Subject] customer want to normalFootbath...");
			System.out.println("[proxy Subject] pay the fees...");
			int score = (Integer)proxy.invoke(footBath, args);;
			return score;
		} else if(method.getName().equals("takeAway")) {
			System.out.println("[proxy Subject] customer want to takeAway...");
			System.out.println("[proxy Subject] check customer's CID...");
			return proxy.invoke(footBath, args);
		}
		return null;
	}

}
